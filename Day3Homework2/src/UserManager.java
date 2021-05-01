
public class UserManager 
{
	public void add(User user)
	{
		System.out.println("\n" + user.getFirstName() + " " + user.getLastName() + " added to system as " + user.getUserType() + ".");
	}
	
	public void addMultiple(User[] users)
	{
		for (User user : users) 
		{
			add(user);			
		}
	}
	
	
	public void remove(User user)
	{
		System.out.println("\n" + user.getUserType() + " " + user.getFirstName() + " " + user.getLastName() + " has been removed.");
	}
	
	public void removeMultiple(User[] users)
	{
		for (User user : users) 
		{
			remove(user);			
		}
	}
	
	
	public void update(User user)
	{
		System.out.println("\n" + user.getUserType() + " " + user.getFirstName() + " " + user.getLastName() + " is successfully updated.");
	}
	
	
	public void updateMultiple(User[] users)
	{
		for (User user : users) 
		{
			update(user);			
		}
	}
	
	public void getAll(User[] users)
	{
		for (User user : users) 
		{
			System.out.println("\nUser ID: " + user.getId() + "\nFirst & Last Name: " + 
					user.getFirstName() + " " + user.getLastName() + "\nCourse: " + user.getCourse() + "\nUser Status: " + user.getUserType());			
		}
	}
}
