
public class StudentManager 
{
	public void Add(Student student)
	{
		System.out.println("\n" + student.name + " " + student.lastName + " is successfully added!\n");
	}
	
	public void Delete(Student student)
	{
		System.out.println("\n" + student.name + " " + student.lastName + " is successfully removed!\n");
	}
	
	public void Update(Student student)
	{
		System.out.println("\n" + student.name + " " + student.lastName + " is successfully updated!\n");
	}
}
