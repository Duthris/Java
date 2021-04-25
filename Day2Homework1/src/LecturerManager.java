
public class LecturerManager 
{
	public void Add(Lecturer lecturer)
	{
		System.out.println("\n" + lecturer.name + " " + lecturer.lastName + " is successfully added!\n");
	}
	
	public void Delete(Lecturer lecturer)
	{
		System.out.println("\n" + lecturer.name + " " + lecturer.lastName + " is successfully removed!\n");
	}
	
	public void Update(Lecturer lecturer)
	{
		System.out.println("\n" + lecturer.name + " " + lecturer.lastName + " is successfully updated!\n");
	}	
}
