package kodlama.io.hrms.business.concretes;

import java.util.regex.*;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.hrms.configurations.*;
import kodlama.io.hrms.business.abstracts.EmployerService;

import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.helpers.email.EMailService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.abstracts.EmployerForRegisterDto;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private UserService userService;
	private UserDao userDao;
	private EMailService eMailService;

	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService, UserDao userDao, EMailService eMailService) {
		this.employerDao = employerDao;
		this.userService = userService;
		this.userDao = userDao;	
		this.eMailService = eMailService;

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers are listed!");
	}

	@Override
	public Result register(Employer employer) {
		if (!isAllFieldsFilled(employer)) {
			return new ErrorResult("All fields must be filled!");
		}
		
		if (isMailExist(employer)) {
			return new ErrorResult("E-mail is already exist!");
		}
		
		if (!isWebSiteValid(employer)) {
			return new ErrorResult("Website is invalid!");
		}
		
		if (!isSameFormat(employer)) {
			return new ErrorResult("Your mail must be a company mail!");
		}
		
		else {		
			employerDao.save(employer);
			eMailService.sendEMail("Verification E-Mail Demo");
			return new SuccessResult("Employer is succesfully registered. Please check your E-Mail to verify your account.");
		}
	}
	
	private boolean isAllFieldsFilled(Employer employer) {
		if (employer.getCompanyName().length() == 0 || employer.getEmail().length() == 0 || employer.getPassword().length() == 0 ||
				employer.getPasswordAgain().length() == 0 || employer.getPhoneNumber().length() == 0 || 
				employer.getWebsite().length() == 0) 
		{
			return false;
		}
		
		return true;
	}
	
	private boolean isWebSiteValid(Employer employer) {
		Pattern webSitePattern = Pattern.compile(("^(\\/\\/)?(www\\.)?([\\w]+\\.)+[\u200C\u200B\\w]{2,63}\\/?$"));
		Matcher webSiteMatcher = webSitePattern.matcher(employer.getWebsite());
		return webSiteMatcher.matches();
	}
	
	private boolean isSameFormat(Employer employer) {
		String domain = employer.getEmail().substring(employer.getEmail().indexOf("@")+1);
		return employer.getWebsite().contains(domain);
	}
	
	private boolean isMailExist(Employer employer) {
		boolean isExistMail = false;
		
		for (User user : employerDao.findAll()) {
			if (user.getEmail() == employer.getEmail()) {
				isExistMail = true;
			}
		}
		
		return isExistMail;
	}
	
}
