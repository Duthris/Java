package interfaces;

public class CustomerManager 
{
	private Logger[] loggers;
	
	public CustomerManager(Logger[] loggers) 
	{
		this.loggers = loggers;
	}

	public void add(Customer customer)
	{
		System.out.println("Customer added!\nAdded Customer: " + customer.getFirstName() + " " + customer.getLastName());

		Utils.runLoggers(loggers, customer.getFirstName());
	}
	
	public void delete(Customer customer)
	{
		System.out.println("Customer deleted!\nDeleted Customer: " + customer.getFirstName() + " " + customer.getLastName());
		
		Utils.runLoggers(loggers, customer.getFirstName());

	}
	
	public void update(Customer customer)
	{
		System.out.println("Customer updated!\nUpdated Customer: " + customer.getFirstName() + " " + customer.getLastName());
		
		Utils.runLoggers(loggers, customer.getFirstName());
	
	}
}
