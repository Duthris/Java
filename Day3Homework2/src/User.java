
public class User 
{
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String course;
	private String userType;
	
	public User()
	{
		
	}
	
	public User(int id, String firstName, String lastName, String userName, String password, String email, 
			String course, String userType) 
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userType = userType;
	}

	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getCourse() 
	{
		return course;
	}

	public void setCourse(String course) 
	{
		this.course = course;
	}

	public String getUserType() 
	{
		return userType;
	}

	public void setUserType(String userType)
{
		this.userType = userType;
	}
}
