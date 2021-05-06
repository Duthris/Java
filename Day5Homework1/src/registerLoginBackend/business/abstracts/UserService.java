package registerLoginBackend.business.abstracts;

import java.util.List;

import registerLoginBackend.entities.concretes.User;

public interface UserService {
	void add(User user);
	void update(User user);
	void delete(User user);
	void verifyUser(int id);
	User getById(int id);
	User getByEmail(String email);
	User getLoginInfos(String email, String password);
	List<User> getAll();
}
