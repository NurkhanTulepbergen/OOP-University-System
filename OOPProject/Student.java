package OOPProject;
import java.io.Serializable;
import java.util.Map;
import java.util.Vector;

public class Student extends User implements StudentMove, Serializable  {
	String id;
	public String fullName;
	public School school;
	public int yearOfStudy;
	public Transcript transcript;
    private int totalCredits = 0;
    private int totalFailures = 0;
    public String educationalLevel = "Bachelor";
	Organizations inOrganization;
	
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
    public void registerCourse(Course course) {
        if (totalCredits + course.credit <= 21) {
            DataBase.registercourses.add(course);
            totalCredits += course.credit;
            System.out.println("Succefull registered course " + course.disciplineName);
        } else {
            System.out.println("Error: Student can't register in more than 21 credits.");
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

    public void viewMarksForCourse(String disciplineName) {
        System.out.println("Marks for Student " + id + " " + fullName + " on course " + disciplineName + ":");

        for (Map.Entry<Student, Map<Course, Mark>> entry : DataBase.studentMarks.entrySet()) {
            Student student = entry.getKey();
            Map<Course, Mark> marks = entry.getValue();

                for (Map.Entry<Course, Mark> markEntry : marks.entrySet()) {
                    Course course = markEntry.getKey();
                    Mark mark = markEntry.getValue();

                    if (course.getCourseName().equals(disciplineName)) {
                        System.out.println("Course: " + course.getCourseName() +
                                ", Grade: " + mark.getMark() +
                                ", Grade Converted: " + Mark.convertGrade(mark.getMark()) +
                                ", Grade GPA: " + Mark.convertGradeGPA(mark.getMark()));
          
                }
            }
        }
    }

    public void viewTranscript() {
        System.out.println("Transcript for Student " + id + " - " + fullName + ":");
        for (Map.Entry<Course, Mark> entry : DataBase.studentMarks.get(this).entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();

            Transcript transcript = new Transcript();
            transcript.idCourse = course.idCourse;
            transcript.course = course;
            transcript.credit = course.credit;
            transcript.ect = course.ect;
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
        if (DataBase.teachers.contains(teacher)) {
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
    public void joinToOrganization(Student s, Organizations o) {
		DataBase.organizations.put(s, o);		
		this.inOrganization = o;
		DataBase.serialize();
	}

	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
	static void printStudentsInOrganization(Organizations organization) {
        System.out.println("Students in " + organization + ":");
        for (Map.Entry<Student, Organizations> entry : DataBase.organizations.entrySet()) {
            if (entry.getValue() == organization) {
                Student student = entry.getKey();
                System.out.println("Student Name: " + student.getStudentName());
            }
        }
    }
	public String toString() {
		return super.toString() + ", id: " + id + ", Full Name: " + fullName + ", School: " + school + ", Year of study: " + yearOfStudy + "\n";
	}

	
}
