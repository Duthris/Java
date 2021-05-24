package kodlama.io.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.adapters.CandidateCheckService;
import kodlama.io.hrms.business.abstracts.UserCheckService;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.User;


@Service
public class UserCheckManager implements UserCheckService {
	
	private CandidateCheckService candidateCheckService;
	private UserDao userDao;
	private CandidateDao candidateDao;
	
	
	@Autowired
	public UserCheckManager(CandidateCheckService candidateCheckService, UserDao userDao, CandidateDao candidateDao) {
		this.candidateCheckService = candidateCheckService;
		this.userDao = userDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public boolean isValidEMail(String email) {
		Pattern validMailPattern = Pattern.compile("^(.+)@(.+)$");
		Matcher validMailMatcher = validMailPattern.matcher(email);
		return validMailMatcher.matches();
	}

	@Override
	public boolean isEMailExist(String email) {
		boolean isExist = false;
		
		for (User user : userDao.findAll()) {
			if (user.getEmail() == email) {
				isExist = true;
			}
		}
		
		return isExist;
	}

	@Override
	public boolean isFirstNameOk(String firstName) {
		Pattern validNamePattern = Pattern.compile("[A-Z][a-z]*");
		Matcher validNameMatcher = validNamePattern.matcher(firstName);
		return validNameMatcher.matches();
	}

	@Override
	public boolean isLastNameOk(String lastName) {
		Pattern validLastNamePattern = Pattern.compile("[A-Z]+([ '-][a-zA-Z]+)*");
		Matcher validLastNameMatcher = validLastNamePattern.matcher(lastName);
		return validLastNameMatcher.matches();
	}

	@Override
	public boolean isPasswordOk(String password) {
		Pattern validPasswordPattern = Pattern.compile("^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}$");
		Matcher validPasswordMatcher = validPasswordPattern.matcher(password);
		return validPasswordMatcher.matches();
	}

	@Override
	public boolean isNationalityIdUnique(String nationalityId) {
		boolean isExist = false;
		for (Candidate candidate : candidateDao.findAll()) {
			if (candidate.getNationalityId() == nationalityId) {
				isExist = true;				
			}
		}
		
		return isExist;
	}
}
