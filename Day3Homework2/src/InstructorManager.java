
public class InstructorManager
{
	public void addCourse(Instructor instructor)
	{
		System.out.println("\n" + instructor.getCourse() + " are added as course by " + 
									instructor.getUserType() + " " + instructor.getFirstName() + " " + instructor.getLastName() + ".");
	}
	
	public void removeCourse(Instructor instructor)
	{
		System.out.println("\nCourse " + instructor.getCourse() + " are removed from system by " + 
									instructor.getUserType() + " " + instructor.getFirstName() + " " + instructor.getLastName() + ".");
	}
	
	public void updateCourse(Instructor instructor)
	{
		System.out.println("\nCourse " + instructor.getCourse() + " are successfully updated by " + 
				instructor.getUserType() + " " + instructor.getFirstName() + " " + instructor.getLastName() + ".");
	}
	
	
	public void addHomework(Instructor instructor)
	{
		System.out.println("\n" + instructor.getUserType() + " " + instructor.getFirstName() + " " + instructor.getLastName() 
											+ " added a homework to system."); 		
	}
	
	public void updateHomework(Instructor instructor)
	{
		System.out.println("\n" + instructor.getUserType() + " " + instructor.getFirstName() + " " + instructor.getLastName() 
											+ " updated a homework."); 		
	}
	
	public void removeHomework(Instructor instructor)
	{
		System.out.println("\n" + instructor.getUserType() + " " + instructor.getFirstName() + " " + instructor.getLastName() 
											+ " removed a homework from system."); 		
	}
	
	public void getAll(Instructor[] instructors)
	{
		for (Instructor instructor : instructors) 
		{
			System.out.println("\nInstructor ID: " + instructor.getId() + "\nFirst & Last Name: " + 
									instructor.getFirstName() + " " + instructor.getLastName() + "\nCourse: " + instructor.getCourse());			
		}
	}
	
	public void add(Instructor instructor)
	{
		System.out.println("\n" + instructor.getFirstName() + " " + instructor.getLastName() + 
				" is added to system as " + instructor.getUserType() + ".");
	}
	
	public void update(Instructor instructor)
	{
		System.out.println("\n" + instructor.getUserType() + " " + instructor.getFirstName() + " " + instructor.getLastName() + 
				" is successfully updated.");
	}
	
	public void remove(Instructor instructor)
	{
		System.out.println("\n" + instructor.getUserType() + " " + instructor.getFirstName() + " " + instructor.getLastName() + 
				" is removed from system.");
	}
	
	public void addMultiple(Instructor[] instructors)
	{
		for (Instructor instructor : instructors) 
		{
			add(instructor);			
		}
	}
	
	public void updateMultiple(Instructor[] instructors)
	{
		for (Instructor instructor : instructors) 
		{
			update(instructor);			
		}
	}
	
	public void removeMultiple(Instructor[] instructors)
	{
		for (Instructor instructor : instructors) 
		{
			remove(instructor);			
		}
	}
}
