
public class Student extends User
{
	private String studentNumber;
	
	public Student()
	{
		
	}

	public Student(String studentNumber) 
	{
		super();
		this.studentNumber = studentNumber;
	}

	public String getStudentNumber() 
	{
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber)
	{
		this.studentNumber = studentNumber;
	}
	
	

}
