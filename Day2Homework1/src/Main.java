
public class Main 
{

	public static void main(String[] args) 
	{
		Course course1 = new Course(1, "# Yaz�l�m Geli�tirici Kamp� C# + Angular #", "Engin Demiro�", 100);
		Course course2 = new Course(2, "# Yaz�l�m Geli�tirici Kamp� JAVA + React #", "Engin Demiro�", 85);
		
		Course[] courses = {course1, course2};
		
		CourseManager courseManager = new CourseManager();
		
		for (Course course : courses)
		{
			courseManager.Add(course);
		}
		
		System.out.println("\n### All Courses ###\n");
		
		for (Course course : courses)
		{
			System.out.println(course.id + " ===> " + course.courseName);
		}
		
		
		Student student1 = new Student(1, "Adem", "Yal�mdemir", "20", course1.courseName);
		Student student2 = new Student(2, "An�l", "Yal�mdemir", "21", course2.courseName);
		
		Student[] students = {student1, student2};
		
		StudentManager studentManager = new StudentManager();
		
		for (Student student : students)
		{
			studentManager.Add(student);
		}
		
		System.out.println("\n### All Students ###\n");
		
		for (Student student : students)
		{
			System.out.println("\n" + student.id + " ===> 	Name: " + student.name + " 	Last Name: " + student.lastName + 
								" 	Age: " + student.age + " 	Courses: " + student.course + "\n");
		}
		
		
		Lecturer lecturer1 = new Lecturer(1, "Engin", "Demiro�", course1.courseName);
		Lecturer lecturer2 = new Lecturer(1, "Engin", "Demiro�", course2.courseName);
		
		Lecturer[] lecturers = {lecturer1, lecturer2};
		
		LecturerManager lecturerManager = new LecturerManager();
		
		for (Lecturer lecturer : lecturers)
		{
			lecturerManager.Add(lecturer);
		}
		
		System.out.println("\n### All Lecturers ###\n");
		
		for (Lecturer lecturer : lecturers)
		{
			System.out.println("\n" + lecturer.id + " ===> 	Name: " + lecturer.name + " 	Last Name: " + lecturer.lastName  + 
					" 	Courses: " + lecturer.course + "\n");
		}
		
		
		
		
		
		
	}

}
