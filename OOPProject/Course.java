package projects;
import java.io.Serializable;
import java.util.Vector;

public class Course implements Serializable {
	public String disciplineName;
	public int credit;
	public int ect;
	public String idCourse;
	public TypeOfCourse typeCourse;
	private String preRequisite;
	public Period period;
	public String teacher;
    private static final int MAX_ENROLLMENT = 30;
    
    public Course() {}
    
    public Course(String disciplineName, int credit, int ect, String idCourse, TypeOfCourse typeCourse, String preRequisite, Period period, String teacher) {
    	this.disciplineName = disciplineName;
    	this.credit = credit;
    	this.ect = ect;
    	this.idCourse = idCourse;
    	this.typeCourse = typeCourse;
    	this.preRequisite = preRequisite;
    	this.period = period;
    	this.teacher = teacher;
    }
    
    public Course(String disciplineName, int credit, int ect, String idCourse, TypeOfCourse typeCourse, Period period, String teacher) {
    	this.disciplineName = disciplineName;
    	this.credit = credit;
    	this.ect = ect;
    	this.idCourse = idCourse;
    	this.typeCourse = typeCourse;
    	this.preRequisite = null;
    	this.period = period;
    	this.teacher = teacher;
    }
 

	public String getCourseName() {
    	return disciplineName;
    }
	
    public String getPreRequisite() {
        return preRequisite;
    }

    public void setPreRequisite(String preRequisite) {
        this.preRequisite = preRequisite;
    }
 
    public String getTeacher() {
    	return teacher;
    }

    public boolean isFull() {
        return Database.enrolledStudents.size() >= MAX_ENROLLMENT;
    }
    
    public void enrollStudent(Student studentId) {
        if (!isFull()) {
            Database.enrolledStudents.add(studentId);
            System.out.println("Student " + studentId + " enrolled in course " + idCourse);
        } else {
            System.out.println("Course " + idCourse + " is full. Cannot enroll more students.");
        }
    }
    
    public Vector<Student> getEnrolledStudents() {
        return Database.enrolledStudents;
    }

    
    public String toString() {
    		return "Course: name: " + disciplineName + ", code: " + idCourse + 
    				", credits: " + credit + ", prerequisites: " + preRequisite + 
    				", ects: " + ect + ", elective type: " + typeCourse + " ";
    }
        
}
