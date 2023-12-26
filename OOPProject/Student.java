package OOPProject;
import java.io.Serializable;
import java.util.Vector;

public class Student extends User implements StudentMove, Serializable  {
	private String id;
	public String fullName;
	public School school;
	public int yearOfStudy;
	public Transcript transcript;
	public Period period;
    private int totalCredits = 0;
    private int totalFailures = 0;
    public Organizations inOrganization;
	public Student() {}
	
    public Student(String login, String password, Language language, String id, String fullName, School school, int yearOfStudy, Period period) {
    	super(login, password, language);
        this.id = id;
        this.fullName = fullName;
        this.school = school;
        this.yearOfStudy = yearOfStudy;
        this.period = period;
        inOrganization = null;
    }
	
	public void joinToOrganization(Organizations o, Student s) {
		DataBase.organizations.put(o, s);
		this.inOrganization = o;
	}
	public Organizations getInOrganization() {
		return inOrganization;
	}
	public String getFullName() {
		return fullName;
	}
	public String getId() {
		return id;
	}
    @Override
    public boolean registerCourse(Course course) {
        if (totalCredits + course.credit <= 21) {
            Course.coursesForStudent.put(this, course);
            totalCredits += course.credit;
            System.out.println("Course registered: " + course.disciplineName);
            return true;
        } else {
            System.out.println("Error: Student can't register in more than 21 credits.");
            return false;
        }
    }
    
    public boolean dropCourse(Course course) {
        if (Course.coursesForStudent.containsValue(course)) {
            Course.coursesForStudent.remove(course);
            totalCredits -= course.credit;
            return true;
        } else {
            System.out.println("Error: Course not found.");
            return false;
        }
    }
    
    public boolean takeExam(Course course, Mark mark) {
        if (Course.courses.contains(course)) {
            int grade = mark.getMark();
            if (grade < 50) {
                totalFailures++;
                if (totalFailures > 3) {
                    System.out.println("Error: Student can't fail more than 3 times.");
                    totalFailures--; // Revert the count since the failure limit is exceeded
                    return false;
                }
            }
            return true;
        } else {
            System.out.println("Error: Course not found.");
            return false;
        }
    }

    @Override
    public void viewCourses(Vector<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("Courses:");
            for (Course course : courses) {
                System.out.println(course.disciplineName);
            }
        }
    }
    /*
    @Override
    public void teacherInfo(Vector<Teacher> teachers) {
        if (teachers.isEmpty()) {
            System.out.println("No teachers available.");
        } else {
            System.out.println("Teachers:");
            for (Teacher teacher : teachers) {
                System.out.println("Name: " + teacher.fullName + ", Course: " + teacher.course);
            }
        }
    }
    */
    @Override
    public void viewMarks(Vector<Mark> marks) {
        if (marks.isEmpty()) {
            System.out.println("No marks available.");
        } else {
            System.out.println("Marks:");
            for (Mark mark : marks) {
                System.out.println("Course: " + mark.course.disciplineName + ", Mark: " + mark.getMark());
            }
        }
    }

    @Override
    public void viewTranscript(Transcript transcript) {
        if (transcript != null) {
            System.out.println("Transcript:");
            System.out.println(transcript.showTranscript());
        } else {
            System.out.println("Transcript not available.");
        }
    }

    @Override
    public void rateTeacher(Teacher teacher, double rate) {
        if (teacher != null) {
            System.out.println("Rating Teacher " + teacher.fullName + ": " + rate);
        } else {
            System.out.println("Rating failed. Invalid teacher.");
        }
    }

    @Override
    public boolean doDiplomaProject() {
        System.out.println("Diploma project initiated.");
        return true;
    }

    @Override
    public Transcript getTranscript() {
        // getTranscriptka birdene zhazu kerek
        // Populate the transcript with relevant information
        return transcript;
    }
    
    public String toString() {
    	return super.toString() + ", Id: " + id + ", FullName: " + fullName + ", School: " + school + ", Period: " + period;
    }

	@Override
	public void teacherInfo(Vector<Teacher> teacher) {
		// TODO Auto-generated method stub
		
	}
	
}
