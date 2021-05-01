
public class StudentManager 
{
	public void joinCourse(Student student)
	{
		System.out.println("\n" + student.getUserType() + " " + student.getFirstName() + " " + student.getLastName() 
								+ " joined to " + student.getCourse() + ".");
	}
	
	public void leaveCourse(Student student)
	{
		System.out.println("\n" + student.getUserType() + " " + student.getFirstName() + " " + student.getLastName() 
								+ " left from the " + student.getCourse() + ".");
	}
	
	public void attendCourse(Student student)
	{
		System.out.println("\n" + student.getUserType() + " " + student.getFirstName() + " " + student.getLastName() 
								+ " is completed today's attendance of " + student.getCourse() + ".");
	}
	
	public void sendHomework(Student student)
	{
		System.out.println("\n" + student.getCourse() + ": " + student.getFirstName() + " " + student.getLastName()
								+ " sent a homework.");
	}
	
	public void getAll(Student[] students)
	{
		for (Student student : students) 
		{
			System.out.println("\nStudent ID: " + student.getId() + "\nFirst & Last Name: " + 
									student.getFirstName() + " " + student.getLastName() + "\nCourse: " + student.getCourse());			
		}
	}
	
	public void add(Student student)
	{
		System.out.println("\n" + student.getFirstName() + " " + student.getLastName() + 
				" is added to system as " + student.getUserType() + ".");
	}
	
	public void update(Student student)
	{
		System.out.println("\n" + student.getUserType() + " " + student.getFirstName() + " " + student.getLastName() + 
				" is successfully updated.");
	}
	
	public void remove(Student student)
	{
		System.out.println("\n" + student.getUserType() + " " + student.getFirstName() + " " + student.getLastName() + 
				" is removed from system.");
	}
	
	public void addMultiple(Student[] students)
	{
		for (Student student : students) 
		{
			add(student);			
		}
	}
	
	public void updateMultiple(Student[] students)
	{
		for (Student student : students) 
		{
			update(student);			
		}
	}
	
	public void removeMultiple(Student[] students)
	{
		for (Student student : students) 
		{
			remove(student);			
		}
	}
	
	

}
