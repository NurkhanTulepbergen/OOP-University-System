package projects;
import java.io.Serializable;
import java.util.Vector;

public abstract class Student extends User implements StudentMove, Serializable  {
	private String id;
	public String fullName;
	public School school;
	public int yearOfStudy;
	public Transcript transcript;
    private int totalCredits = 0;
    private int totalFailures = 0;
    public String educationalLevel = "Bachelor";
	
	public Student() {}
	
    public Student(String login, String password, Language language, String id, String fullName, School school, int yearOfStudy) {
    	super(login, password, language);
        this.id = id;
        this.fullName = fullName;
        this.school = school;
        this.yearOfStudy = yearOfStudy;
        }
    
    public String getStudentName() {
    	return fullName;
    }
	

    @Override
    public boolean registerCourse(Course course) {
        if (totalCredits + course.credit <= 21) {
            Database.courses.add(course);
            totalCredits += course.credit;
            System.out.println("Succefull registered course " + course.disciplineName);
            return true;
        } else {
            System.out.println("Error: Student can't register in more than 21 credits.");
            return false;
        }
    }
    
    public boolean dropCourse(Course course) {
        if (Database.courses.contains(course)) {
            Database.courses.remove(course);
            totalCredits -= course.credit;
            return true;
        } else {
            System.out.println("Error: Course not found.");
            return false;
        }
    }
    

    public void viewCourses() {
        System.out.println("Available Courses:");
        for (Course course : Database.courses) {
            System.out.println(course.toString());
        }
    }

    public void teacherInfo() {
        System.out.println("Teacher Information: ");
        for(Teacher teacher : Database.teachers) {
        	System.out.println(teacher.toString());
        }
    }

    public void viewMarks(String disciplineName) {
        System.out.println("Marks for Student " + id + " " + fullName + " on discipline " + disciplineName + ":");

        for (Mark mark : Database.marks) {
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
        for (Mark mark : Database.marks) {
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
        // Check if the teacher is in the database
        if (Database.teachers.contains(teacher)) {
            // Perform rating logic
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
        // Assuming that a rating is between 0 and 10
        return rating >= 0 && rating <= 10;
    }
	
}
