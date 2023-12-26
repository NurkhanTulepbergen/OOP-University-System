package projects;

import java.io.Serializable;
import java.util.Vector;

public class GraduateStudent implements StudentMove, Serializable {
	private String id;
	public String fullName;
	public School school;
	public static Vector<Course> courses = new Vector<Course>();
	public Transcript transcript;
	public Period period;
	public TypeGraduateStudent type;
	 private int totalCredits = 0;
	
	public GraduateStudent() {}
	
	public GraduateStudent(String login, String password, Language language, String id, String fullName, School school, TypeGraduateStudent type) {
		super();
		this.id = id;
        this.fullName = fullName;
        this.school = school;
        this.type = type;
	}
	
    
    public String getStudentName() {
    	return fullName;
    }
	
	public String getDegreeType() {
        if (type == TypeGraduateStudent.MASTER) {
            return "Master's Degree";
        } else if (type == TypeGraduateStudent.PHD) {
            return "Ph.D.";
        } else {
            return "Unknown Degree Type";
        }
    }
	

    @Override
    public boolean registerCourse(Course course) {
		if (totalCredits  + course.credit <= 21) {
            DataBase.courses.add(course);
            totalCredits += course.credit;
            System.out.println("Succefull registered course " + course.disciplineName);
            return true;
        } else {
            System.out.println("Error: Student can't register in more than 21 credits.");
            return false;
        }
    }
    
    public boolean dropCourse(Course course) {
        if (DataBase.courses.contains(course)) {
            DataBase.courses.remove(course);
            totalCredits -= course.credit;
            return true;
        } else {
            System.out.println("Error: Course not found.");
            return false;
        }
    }
    

    public void viewCourses() {
        System.out.println("Available Courses:");
        for (Course course : DataBase.courses) {
            System.out.println(course.toString());
        }
    }

    public void teacherInfo() {
        System.out.println("Teacher Information: ");
        for(Teacher teacher : DataBase.teachers) {
        	System.out.println(teacher.toString());
        }
    }

    public void viewMarks(String disciplineName) {
        System.out.println("Marks for Student " + id + " " + fullName + " on discipline " + disciplineName + ":");

        for (Mark mark : DataBase.marks) {
            Course course = mark.getCourse();

            if (course.getCourseName().equals(disciplineName)) {
                System.out.println("Course: " + course.getCourseName() +
                        ", Grade: " + mark.getMark() +
                        ", Grade Converted: " + Mark.convertGrade(mark.getMark()) +
                        ", Grade GPA: " + Mark.convertGradeGPA(mark.getMark()));
            }
        }
    }

    public void viewTranscript() {
        System.out.println("Transcript for Student " + id + " - " + fullName + ":");
        for (Mark mark : DataBase.marks) {
                Transcript transcript = new Transcript();
                transcript.idCourse = mark.getCourse().idCourse;
                transcript.course = mark.getCourse();
                transcript.credit = mark.getCourse().credit;
                transcript.ect = mark.getCourse().ect;
                transcript.mark = mark;
                transcript.GPA = Mark.convertGradeGPA(mark.getMark());

                System.out.println("Course: " + transcript.course.getCourseName() +
                        ", Grade: " + transcript.mark.getMark() +
                        ", GPA: " + transcript.GPA +
                        ", Credits: " + transcript.credit +
                        ", ECT: " + transcript.ect);
        }
    }
    
    public void rateTeacher(Teacher teacher, int rating) {
        if (DataBase.teachers.contains(teacher)) {
            if (isValidRating(rating)) {
                teacher.addRating(rating);
                System.out.println("Teacher rated successfully!");
            } else {
                System.out.println("Invalid rating. Please provide a rating between 0 and 10.");
            }
        } else {
            System.out.println("Teacher not found in the database. Cannot rate.");
        }
    }

    private boolean isValidRating(int rating) {
        return rating >= 0 && rating <= 10;
    }
    
    public String toString() {
        return " Student: " + fullName + " ID: "  + id + " School: " + school + " Degree Type: " + type;
    }
    
}
