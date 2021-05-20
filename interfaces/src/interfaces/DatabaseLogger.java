package interfaces;

public class DatabaseLogger implements Logger
{
	@Override
	public void log(String message) 
	{
		System.out.println("\nSaved to DB!\nSaved Customer: " + message);
	}

}
