package registerLoginBackend.business.concretes;

import registerLoginBackend.business.abstracts.EmailService;
import registerLoginBackend.entities.concretes.User;

public class EmailManager implements EmailService {

	@Override
	public void send(String message) {
		System.out.println("\nSent Message: " + message);
	}

}
