
public class CourseManager 
{
	public void Add(Course course)
	{
		System.out.println("\n" + course.courseName + " is successfully added!\n");
	}
	
	public void Delete(Course course)
	{
		System.out.println("\n" + course.courseName + " is successfully removed!\n");
	}
	
	public void Update(Course course)
	{
		System.out.println("\n" + course.courseName + " is successfully updated!\n");
	}
}
