package OOPProject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


public class Teacher extends Employee implements Serializable {
	public TeacherRank teacherRank;
	private Vector<Integer> ratings = new Vector<>();
	
	public Teacher() {}
	
	
	public Teacher(String login, String password, Language language, String id, String fullName, int salary, TeacherRank teacherRank) {
	super(login, password, language, id, fullName, salary);
	this.teacherRank = teacherRank;
	}
	
	public String getTeacherName() {
		return fullName;
	}

    public List<Course> viewCourses() {
        List<Course> coursesTaught = new ArrayList<>();
        for (Map.Entry<Teacher, Course> entry : DataBase.teacherCourses.entrySet()) {
            if (entry.getKey().equals(this)) {
                coursesTaught.add(entry.getValue());
            }
        }
        return coursesTaught;
    }
    
    public  void viewCoursesTaught(Teacher teacher) {
        System.out.println("Courses taught by " + teacher.getTeacherName() + ":");
        List<Course> teacherCourses = teacher.viewCourses();
        for (Course course : teacherCourses) {
            System.out.println(course.toString());
        }
        System.out.println();
    }
    
    public void viewEnrolledStudentsForCourse(Course course) {
        System.out.println("Enrolled students in course " + course.getCourseName() + ":");
        for (Map.Entry<Course, Student> entry : DataBase.enrolledStudents.entrySet()) {
            Course enrolledCourse= entry.getKey();
            Student student = entry.getValue();

            if (enrolledCourse.equals(course)) {
                System.out.println("Student ID: " + student.id +
                        ", Name: " + student.fullName +
                        ", Year of Study: " + student.yearOfStudy +
                        ", School: " + student.school +
                        ", Course: " + course.getCourseName());
            }
        }
    }
	
    public void sendComplaint(Student student, String complaintText, UrgencyLevel urgencyLevel, ManagerType managerType) {
        Complaint complaint = new Complaint(complaintText, urgencyLevel);
        Manager.receiveComplaint(this, student, complaint);
    }

    
    public String sendMessage(Employee employee, String messageText) {
        return "Message sent to " + employee  + ": " + messageText;
    }
    
    public void putMark(Student student, Course course, Mark mark) {
        if (!DataBase.studentMarks.containsKey(student)) {
            DataBase.studentMarks.put(student, new HashMap<>());
        }

        DataBase.studentMarks.get(student).put(course, mark);
        /*System.out.println("Mark added successfully for Student " + student.getStudentName() +
                " in course " + course.getCourseName() +
                " - Grade: " + mark.getMark());
                */
    }

    public void addRating(int rating) {
        if (isValidRating(rating)) {
            ratings.add(rating);
            System.out.println("Rating added successfully!");
        } else {
            System.out.println("Invalid rating. Please provide a rating between 0 and 10.");
        }
    }
    
    private boolean isValidRating(int rating) {
        return rating >= 0 && rating <= 10;
    }
    
    public String toString() {
    	return " Teacher: " + super.toString() + " Teacher Rank: " + teacherRank;
    }



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


	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
    
}