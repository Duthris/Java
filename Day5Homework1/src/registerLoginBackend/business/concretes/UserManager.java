package registerLoginBackend.business.concretes;

import java.util.List;

import registerLoginBackend.business.abstracts.UserService;
import registerLoginBackend.dataAccess.abstracts.UserDao;
import registerLoginBackend.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public void verifyUser(int id) {
		User tempUser = userDao.getById(id);
		System.out.println("\nSuccess: " + tempUser.getEmail() + " is verified!");
		tempUser.setVerifiedUser(true);
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User getLoginInfos(String email, String password) {
		return userDao.getLoginInfos(email, password);
	}

}
