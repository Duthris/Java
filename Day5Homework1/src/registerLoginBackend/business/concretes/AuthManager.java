package registerLoginBackend.business.concretes;

import registerLoginBackend.business.abstracts.EmailService;
import registerLoginBackend.business.abstracts.UserService;
import registerLoginBackend.business.abstracts.UserValidationService;
import registerLoginBackend.core.AuthService;
import registerLoginBackend.entities.concretes.User;

public class AuthManager implements AuthService {
	
	private UserService userService;
	private UserValidationService userValidationService;
	private EmailService emailService;

	public AuthManager(UserService userService, UserValidationService userValidationService,
			EmailService emailService) 
	{
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.emailService = emailService;
	}

	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		
		User tempUser = new User(id, firstName, lastName, email, password, false);
		
		if (!userValidationService.validateUser(tempUser)) {
			System.out.println("\nRegistration was NOT successful!\nPlease check your infos again!");
			return;
		}
		
		if (!isEmailNOTUsed(email)) {
			System.out.println("\nRegistration was NOT Successful: This E-mail is already exist!");
			return;
		}
		
		else {
			System.out.println("\nRegistration was Successful!\nPlease check your E-mail to verify your account!");
			emailService.send("\nTo verify your account use the link below:\nhttps://www.verificationTest.com/verify?id=12345");
			userService.add(tempUser);
		}
		
	}

	@Override
	public void login(String email, String password) {
		
		User tempUser = userService.getLoginInfos(email, password);
		
		if (!isAllFilled(email, password))
		{
			System.out.println("\nLogin was NOT successful!\nPlease check your infos again!");
			return;			
		}
			
		if (tempUser == null)
		{
			System.out.println("\nLogin was NOT successful!\nPlease check your email or password again!");
			return;
		}
		
		if (!isUserVerified(tempUser))
		{
			System.out.println("\nLogin was NOT successful!\nPlease verify your account!");
			return;
		}
		
		else 
		{			
			System.out.println("\nLogin was successful!\nWelcome " + tempUser.getFirstName() + " " + tempUser.getLastName());
		} 
	}
	
	
	private boolean isEmailNOTUsed(String email) {
		return userService.getByEmail(email) == null;
	} 
	
	private boolean isUserVerified(User user) {
		return user.isVerifiedUser();
	}
	
	private boolean isAllFilled(String email, String password)
	{
		if (email.length() > 0 && password.length() > 0)
		{
			return true;
		}
		
		return false;
	}

}
