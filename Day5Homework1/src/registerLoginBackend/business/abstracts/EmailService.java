package registerLoginBackend.business.abstracts;

import registerLoginBackend.entities.concretes.User;

public interface EmailService {
	void send(String message);
}
