package inheritance2;

public class FileLogger extends Logger
{
	@Override
	public void log()
	{
		System.out.println("Saved to File!");	
	}
}
