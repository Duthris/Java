package interfaces;

public class Main {

	public static void main(String[] args) 
	{	
		Logger[] loggers = {new SmsLogger(), new EmailLogger(), new DatabaseLogger(), new FileLogger()};
		
		CustomerManager customerManager = new CustomerManager(loggers);
		Customer an�l = new Customer(1,"An�l","Yal�mdemir");
		customerManager.add(an�l);
	}

}
