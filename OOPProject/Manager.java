package OOPProject;

import java.io.Serializable;
import java.util.Vector;

public class Manager extends Employee implements Serializable{
	public ManagerType managerType;
	public Manager() {
		
	}
	
	public Manager(String login, String password, Language language, String id, String fullName, int salary, ManagerType managerType) {
		super(login, password, language, id, fullName, salary);
		this.managerType = managerType;
		DataBase.managers.add(this);
	}
	
    public static void enrollStudent(Student student, Course course) {
        DataBase.enrolledStudents.put(course, student);
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
		
	    public static void receiveComplaint(Teacher teacher, Student student, Complaint complaint) {
	        switch (complaint.getUrgencyLevel()) {
	            case LOW:
	                System.out.println("Dean received a LOW urgency complaint from " + teacher.getTeacherName() +
	                        " regarding student " + student.getStudentName() + ": " + complaint.getComplaintText());
	                break;
	            case MEDIUM:
	                System.out.println("Dean received a MEDIUM urgency complaint from " + teacher.getTeacherName() +
	                        " regarding student " + student.getStudentName() + ": " + complaint.getComplaintText());
	                break;
	            case HIGH:
	                System.out.println("Dean received a HIGH urgency complaint from " + teacher.getTeacherName() +
	                        " regarding student " + student.getStudentName() + ": " + complaint.getComplaintText());
	                break;
	            default:
	                System.out.println("Invalid urgency level");
	        }
	    }

	 
	
	public String viewRequestsFromEmployees() {
		return null;
	}//	NADO NAPISAT
	
	@Override
	public String report(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendMessage(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}