package OOPProject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class Course {
	public String disciplineName;
	public int credit;
	public int ect;
	public String idCourse;
	public static  Vector<Student> accessStudent = new Vector<Student>();
	public static HashMap<Student, Course> coursesForStudent = new HashMap<Student, Course>();
	public static HashMap<Teacher, Course> coursesForTeacher = new HashMap<Teacher, Course>();
	public static HashSet<Course> courses = new HashSet<Course>();
	public TypeOfCourse typeCourse;
	private String preRequisite;
	
	 // Assuming max enrollment capacity for simplicity
    private static final int MAX_ENROLLMENT = 30;
	
	public boolean enrollStudent(Student s) {
        // Check if the course has reached its maximum enrollment capacity
        if (accessStudent.size() >= MAX_ENROLLMENT) {
            System.out.println("Enrollment failed. The course is full.");
            return false;
        }

        // Check if the student meets prerequisites
        if (!checkPrerequisite(s)) {
            System.out.println("Enrollment failed. Prerequisite not satisfied.");
            return false;
        }

        // Check if the student is not already enrolled
        if (!accessStudent.contains(s)) {
            accessStudent.add(s);
            System.out.println("Enrolled student: " + s.fullName + " in course: " + disciplineName);
            return true;
        } else {
            System.out.println("Enrollment failed. Student is already enrolled in the course.");
            return false;
        }
    }

    public boolean dropStudent(Student s) {
        // Check if the student is enrolled in the course
        if (accessStudent.contains(s)) {
            accessStudent.remove(s);
            System.out.println("Dropped student: " + s.fullName + " from course: " + disciplineName);
            return true;
        } else {
            System.out.println("Drop failed. Student is not enrolled in the course.");
            return false;
        }
    }
	
    public boolean checkPrerequisite(Student s) {
        // Check if there is no prerequisite or if the student meets the prerequisite
        if (preRequisite == null) {
            return true;
        } else 
            return false;
        
}
}
