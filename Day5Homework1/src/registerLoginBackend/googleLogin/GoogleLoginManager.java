package registerLoginBackend.googleLogin;

public class GoogleLoginManager {
	
	public void register(String email, String password) {
		System.out.println("\nRegistered with Google Account: " + email);
	}
	
	public void login(String email, String password) {
		System.out.println("\nLogged in with Google Account: " + email);
	} 

}
