package registerLoginBackend;

import java.util.List;

import registerLoginBackend.business.abstracts.UserService;
import registerLoginBackend.business.concretes.AuthManager;
import registerLoginBackend.business.concretes.EmailManager;
import registerLoginBackend.business.concretes.UserManager;
import registerLoginBackend.business.concretes.UserValidationManager;
import registerLoginBackend.core.AuthService;
import registerLoginBackend.core.GoogleLoginManagerAdapter;
import registerLoginBackend.dataAccess.concretes.InMemoryUserDao;
import registerLoginBackend.entities.concretes.User;

public class Main {

	public static void main(String[] args) 
	{
		UserService userService = new UserManager(new InMemoryUserDao());
		
		AuthService authService = new AuthManager(userService, new UserValidationManager(), new EmailManager());

		
		System.out.println("\n######### Register Tests #########");
		
		authService.register(1, "Anýl", "Yalýmdemir", "cxg2520@gmail.com", "123test123"); // Successful
		authService.register(2, "Adem", "Yalýmdemir", "invalidEmail", "123test3123");  // E-mail is not in correct form
		authService.register(3, "Deneme", "Test", "testmail@gmail.com", "invld");  // Password must be at least 6 characters.
		authService.register(4, "I", "V", "testmail2@gmail.com", "validpassword123");  // First & Last Name of User must be at least 2 characters.
		authService.register(5, "Email", "Exists", "cxg2520@gmail.com", "123valid123");  // E-mail is already exist in database.
		authService.register(6, "", "", "denemeuye@gmail.com", "denemeuye123");  // All parts of register infos must be filled. First & Last name is empty.
		
		System.out.println("\n----------------------------------------------------------------\n");
		
		authService.login("cxg2520@gmail.com", "123test123"); // Infos are correct, but User is NOT verified.
		userService.verifyUser(1); // User clicked the verification link and verified.
		authService.login("cxg2520@gmail.com", "123test"); // Retried to log in, but password is wrong
		authService.login("cxg25200@gmail.com", "123test123"); // This time e-mail is not correct
		authService.login("cxg2520@gmail.com", ""); // Password cannot be empty
		authService.login("", "123test123"); // E-mail cannot be empty
		authService.login("cxg2520@gmail.com", "123test123"); // Successful
		
		userService.getAll(); // To see users registered correctly and their verification status for better tests
		
		
		System.out.println("\n\n\n######### Google Log in Simulation #########");
		
		AuthService googleLoginService = new GoogleLoginManagerAdapter();
		googleLoginService.register(6, "Google", "Test", "googletest@gmail.com", "googletest123");
		googleLoginService.login("googletest@gmail.com", "googletest123");
		
		
	}

}
