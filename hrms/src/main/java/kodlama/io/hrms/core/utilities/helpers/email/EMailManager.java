package kodlama.io.hrms.core.utilities.helpers.email;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;


@Service
public class EMailManager implements EMailService {

	@Override
	public Result sendEMail(String message) {
		return new SuccessResult("Verification mail successfully sent!");
	}

}
