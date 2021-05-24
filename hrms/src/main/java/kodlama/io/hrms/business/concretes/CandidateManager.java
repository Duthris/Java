package kodlama.io.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.adapters.CandidateCheckService;
import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.UserActivationService;
import kodlama.io.hrms.business.abstracts.UserCheckService;
import kodlama.io.hrms.core.utilities.helpers.email.EMailService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private UserCheckService userCheckService;
	private UserActivationService userActivationService;
	private EMailService eMailService;
	private CandidateCheckService candidateCheckService;
	private UserDao userDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService, 
			UserActivationService userActivationService, EMailService eMailService, CandidateCheckService candidateCheckService,
			UserDao userDao) {
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
		this.userActivationService = userActivationService;
		this.eMailService = eMailService;
		this.candidateCheckService = candidateCheckService;
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidates are listed!");
	}

	@Override
	public Result register(Candidate candidate) {
		if (!isAllFieldsFilled(candidate)) {
			return new ErrorResult("All fields must be filled!");
		}
		
		if (isEMailExist(candidate) != null) {
			return new ErrorResult("E-mail is already exist!");
		}
		
		if (isNationalityIdExist(candidate) != null) {
			return new ErrorResult("Nationality ID is already exist!");
		}
		
		if (!isSamePasswordRepeated(candidate)) {
			return new ErrorResult("Passwords doese not match!");			
		}
		
		else {
			this.candidateDao.save(candidate);
			eMailService.sendEMail("Verification E-Mail Demo");
			userActivationService.activate(candidate);
			
			return new SuccessResult("Successfully Registered!");
		}
	}
	
	private boolean isAllFieldsFilled(Candidate candidate) {
		if (candidate.getFirstName().length() == 0 || candidate.getLastName().length() == 0 || candidate.getNationalityId().length() == 0
				|| candidate.getBirthYear().length() == 0 || candidate.getEmail().length() == 0 || candidate.getPassword().length() == 0
				|| candidate.getPasswordAgain().length() == 0) 
		{
			return false;
		}
		
		return true;
	}
	
	private boolean isSamePasswordRepeated(Candidate candidate) {
		if (!candidate.getPassword().equals(candidate.getPasswordAgain())) {
			return false;
		}
		
		return true;
	}
	

	@Override
	public DataResult<Candidate> getByEMail(String email) {
		return new SuccessDataResult<Candidate>(candidateDao.findByEmail(email));
	}

	
	private Result isEMailExist(Candidate candidate) {
		if (this.getByEMail(candidate.getEmail()).getData() != null) {
			return new ErrorResult("E-mail already Exist!");
		}
		
		return null;
	}

	@Override
	public DataResult<Candidate> getByNationalityId(String nationalityId) {
		return new SuccessDataResult<Candidate>(candidateDao.findByNationalityId(nationalityId));
	}
	
	private Result isNationalityIdExist(Candidate candidate) {
		if (this.getByNationalityId(candidate.getNationalityId()).getData() != null) {
			return new ErrorResult("Nationality ID is already exist!");
		}
		
		return null;
	}

}
