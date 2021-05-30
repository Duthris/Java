package kodlama.io.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UserActivationService;
import kodlama.io.hrms.core.utilities.RandomCodeGenerator;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.MailVerificationDao;
import kodlama.io.hrms.entities.concretes.MailVerification;
import kodlama.io.hrms.entities.concretes.User;
import net.bytebuddy.asm.Advice.This;

@Service
public class UserActivationManager implements UserActivationService {
	
	private MailVerificationDao mailVerificationDao;

	public UserActivationManager(MailVerificationDao mailVerificationDao) {
		this.mailVerificationDao = mailVerificationDao;
	}

	@Override
	public Result activate(String verificationCode, int id) {
		
		MailVerification userToVerify = mailVerificationDao.findByUserId(id).stream().findFirst().get();
		
		if (userToVerify.getVerificationCode().equals(verificationCode) && userToVerify.isVerified() == false) {
			userToVerify.setVerified(true);
			return new SuccessDataResult<MailVerification> (this.mailVerificationDao.save(userToVerify), "Successfully Verified!");
		}
		
		if (userToVerify.isVerified() == true) {
			return new ErrorResult("Already Verified!");
		}
		
		else {
			return new ErrorResult("Invalid or Expired Verification Code!");
		}
			
	}

	@Override
	public void createCode(MailVerification verificationCode, int id) {
		MailVerification verifyCode = verificationCode; 
		verificationCode.setVerificationCode(null);
		verificationCode.setVerified(false);
		
		if (verificationCode.isVerified() == false) {
			RandomCodeGenerator random = new RandomCodeGenerator();
			
			String generatedCode = random.createCode();
			verificationCode.setVerificationCode(generatedCode);
			verificationCode.setUserId(id);
			
			mailVerificationDao.save(verificationCode);
		}
	}

}
