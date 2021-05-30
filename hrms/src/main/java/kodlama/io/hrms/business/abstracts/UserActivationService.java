package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.MailVerification;
import kodlama.io.hrms.entities.concretes.User;

public interface UserActivationService {
	Result activate(String verificationCode, int id);
	void createCode(MailVerification verificationCode, int id);

}
