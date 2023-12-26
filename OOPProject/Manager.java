package projects;

import java.util.Vector;

public class Manager extends Employee{
	public ManagerType managerType;
	public Manager() {
		
	}
	
	public Manager(String login, String password, Language language, String id, String fullName, int salary, ManagerType managerType) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.salary = salary;
		this.managerType = managerType;
	}
	
    public static void enrollStudent(Student student, Course course) {
        DataBase.enrolledStudents.put(student, course);
        System.out.println("Student " + student.getStudentName() + " enrolled in course " + course.getCourseName());

	}
	public void addCourse(Teacher teacher, Course course) {
	        DataBase.teacherCourses.put(teacher, course);
	   }

	public void dropCourse(Teacher teacher, Course course) {
	        DataBase.teacherCourses.remove(teacher, course);
	   }
	
	 public void createAcademicReports() {
		System.out.println("The name of Students, courses, and their marks is: ");
		System.out.println(DataBase.students);
	 }
	
	
	 public void viewInfoTeacher() {
		 for(Teacher teacher : DataBase.teachers) {
			 System.out.println(teacher);
		 }
	 }
	 
	 public void viewInfoStudent() {
		 for(Student student: DataBase.students) {
			 System.out.println(student);
		 }
	 }
		public String sendMessage(Employee employee, String textMessage) {
			return "Message sent to " + employee  + ": " + textMessage;
		}

	 
	
	public String viewRequestsFromEmployees() {
		return null;
	}//	NADO NAPISAT
	
	@Override
	public String report() {
		// TODO Auto-generated method stub
		return null;
	}

}
