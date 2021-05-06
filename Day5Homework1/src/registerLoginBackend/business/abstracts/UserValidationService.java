package registerLoginBackend.business.abstracts;

import registerLoginBackend.entities.concretes.User;

public interface UserValidationService {
	boolean validateUser(User user);
}
