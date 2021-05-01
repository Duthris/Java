
public class Main 
{

	public static void main(String[] args) 
	{
		Student student1 = new Student();
		student1.setId(1);
		student1.setFirstName("Anıl");
		student1.setLastName("YALIMDEMIR");
		student1.setUserName("student1");
		student1.setPassword("student1_123");
		student1.setEmail("student1@gmail.com");
		student1.setUserType("Student");
		student1.setCourse("Java + React Yazılımcı Geliştirme Kampı");
		
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setFirstName("Adem");
		student2.setLastName("YALIMDEMIR");
		student2.setUserName("student2");
		student2.setPassword("student2_321");
		student2.setEmail("student2@gmail.com");
		student2.setUserType("Student");
		student2.setCourse("C# + Angular Yazılımcı Geliştirme Kampı");

		
		Student[] students = new Student[] {student1, student2};
		
		Instructor instructor1 = new Instructor();
		instructor1.setId(1);
		instructor1.setFirstName("Engin");
		instructor1.setLastName("Demiroğ");
		instructor1.setUserName("engin.demirog");
		instructor1.setPassword("instructor_engin123");
		instructor1.setEmail("engindemirog@gmail.com");
		instructor1.setUserType("Instructor");
		instructor1.setCourse("C# + Angular && Java + React Yazılımcı Geliştirme Kampı");
		
		
		Instructor[] instructors = new Instructor[] {instructor1};
		
		
		User[] users = new User[] {instructor1, student1, student2};
		
		UserManager userManager = new UserManager();
		userManager.addMultiple(users);
		
		System.out.println("\n\n############## ALL USERS ##############");
		userManager.getAll(users);
		
		System.out.println("\n#########################################\n");
		
		System.out.println("\n\n############## TESTS FOR STUDENTS ##############");
		
		StudentManager studentManager = new StudentManager();
		studentManager.add(student1);
		studentManager.add(student2);
		studentManager.update(student2);
		studentManager.remove(student1);
		studentManager.addMultiple(students);
		studentManager.joinCourse(student1);
		studentManager.attendCourse(student2);
		studentManager.attendCourse(student1);
		studentManager.leaveCourse(student2);
		studentManager.sendHomework(student1);
		
		System.out.println("\n\n############## ALL STUDENTS ##############");
		studentManager.getAll(students);
		
		System.out.println("\n#########################################\n");
		
		
		System.out.println("\n\n############## TESTS FOR STUDENTS ##############");
		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(instructor1);
		instructorManager.update(instructor1);
		instructorManager.remove(instructor1);
		instructorManager.addMultiple(instructors);
		instructorManager.addHomework(instructor1);
		instructorManager.addCourse(instructor1);
		instructorManager.updateCourse(instructor1);
		instructorManager.updateHomework(instructor1);
		instructorManager.removeHomework(instructor1);
		instructorManager.removeCourse(instructor1);
		
		
		System.out.println("\n\n############## ALL INSTRUCTORS ##############");
		instructorManager.getAll(instructors);
		
		System.out.println("\n#########################################\n");
		
	}

}
