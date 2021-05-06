package registerLoginBackend.core;

import registerLoginBackend.googleLogin.GoogleLoginManager;

public class GoogleLoginManagerAdapter implements AuthService {

	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		GoogleLoginManager googleLoginManager = new GoogleLoginManager();
		googleLoginManager.register(email, password);
		
	}

	@Override
	public void login(String email, String password) {
		GoogleLoginManager googleLoginManager = new GoogleLoginManager();
		googleLoginManager.login(email, password);
		
	}
	
}
