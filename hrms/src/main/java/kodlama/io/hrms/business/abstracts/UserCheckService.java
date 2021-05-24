package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface UserCheckService {
	boolean isValidEMail(String email);
	boolean isEMailExist(String email);
	boolean isFirstNameOk(String firstName);
	boolean isLastNameOk(String lastName);
	boolean isPasswordOk(String password);
	boolean isNationalityIdUnique(String nationalityId);
}
