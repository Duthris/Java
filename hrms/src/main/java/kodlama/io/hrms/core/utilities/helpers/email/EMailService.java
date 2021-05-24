package kodlama.io.hrms.core.utilities.helpers.email;

import kodlama.io.hrms.core.utilities.results.Result;


public interface EMailService {
	Result sendEMail(String message);
}
