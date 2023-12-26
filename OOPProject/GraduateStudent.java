package OOPProject;

import java.util.Vector;

public class GraduateStudent implements StudentMove {
	private String id;
	public String fullName;
	public School school;
	public static Vector<Course> courses = new Vector<Course>();
	public Transcript transcript;
	public Period period;
	public TypeGraduateStudent type;
	public static Vector<DiplomProjects> diplomProject = new Vector<DiplomProjects>();
	
	public GraduateStudent() {}
	
	public GraduateStudent(String id, String fullName, School school, Vector<Course> courses, Period period, Transcript transcript,  TypeGraduateStudent type, Vector<DiplomProjects> diplomaProject) {
		this.id = id;
        this.fullName = fullName;
        this.school = school;
        this.courses = courses;
        this.transcript = transcript;
        this.period = period;
        this.type = type;
        this.diplomProject = diplomProject;
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
        // Check if the course is not already in the list of courses
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("Course registered: " + course.disciplineName);
            return true;
        } else {
            System.out.println("Registration failed. Course is already registered.");
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
        // Simulate generating the transcript for the student
        Transcript transcript = new Transcript();
        // Populate the transcript with relevant information
        return transcript;
    }
}
