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
	public Teacher teacher;
    
    public Course() {}
    
    public Course(String disciplineName, int credit, int ect, String idCourse, TypeOfCourse typeCourse, String preRequisite, Period period, Teacher teacher) {
    	this.disciplineName = disciplineName;
    	this.credit = credit;
    	this.ect = ect;
    	this.idCourse = idCourse;
    	this.typeCourse = typeCourse;
    	this.preRequisite = preRequisite;
    	this.period = period;
    	this.teacher = teacher;
    }
    
    public Course(String disciplineName, int credit, int ect, String idCourse, TypeOfCourse typeCourse, Period period, Teacher teacher) {
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
 
    public Teacher getTeacher() {
    	return teacher;
    }
    
    public String toString() {
    		return "Course: name: " + disciplineName + ", code: " + idCourse + 
    				", credits: " + credit + ", prerequisites: " + preRequisite + 
    				", ects: " + ect + ", elective type: " + typeCourse + " ";
    }
        
}
