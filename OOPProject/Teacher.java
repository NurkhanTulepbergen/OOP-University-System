package projects;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	
    public void sendComplaint(Student student, String complaintText, UrgencyLevel urgencyLevel, Dean dean) {
        Complaint complaint = new Complaint(complaintText, urgencyLevel);
        dean.receiveComplaint(this, student, complaint);
    }

    
    public String sendMessage(Employee employee, String messageText) {
        return "Message sent to " + employee  + ": " + messageText;
    }
    
    public void putMark(Student student, Course course, Mark mark) {
        if (DataBase.teacherCourses.containsKey(this)) {
            if (DataBase.courses.contains(course)) {
                if (DataBase.enrolledStudents.containsKey(student)) {
                    DataBase.marks.add(mark);
                    System.out.println("Mark added successfully for student " + student.id + " in course " + course.getCourseName());
                } else {
                    System.out.println("Error: Student is not enrolled in the specified course.");
                }
            } else {
                System.out.println("Error: Course not found in the database.");
            }
        } else {
            System.out.println("Error: Teacher is not assigned to the specified course.");
        }
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
	public String report() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
