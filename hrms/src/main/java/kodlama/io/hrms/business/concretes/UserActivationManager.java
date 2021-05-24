package kodlama.io.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UserActivationService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.User;

@Service
public class UserActivationManager implements UserActivationService {

	@Override
	public Result activate(User user) {
		user.setVerificationStatus(true);
		return new SuccessResult("User is activated successfully!");
	}

}
