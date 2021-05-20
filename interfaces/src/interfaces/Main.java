package interfaces;

public class Main {

	public static void main(String[] args) 
	{	
		Logger[] loggers = {new SmsLogger(), new EmailLogger(), new DatabaseLogger(), new FileLogger()};
		
		CustomerManager customerManager = new CustomerManager(loggers);
		Customer anýl = new Customer(1,"Anýl","Yalýmdemir");
		customerManager.add(anýl);
	}

}
