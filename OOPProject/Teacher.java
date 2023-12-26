package OOPProject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import Stream.Book;

public class Teacher extends Employee{
	public static Vector<Course> course = new Vector<Course>();
	public static Vector<Teacher> teachers = new Vector<Teacher>();
	public UrgencyLevel urgencyLevel;
	public TeacherRank teacherRank;
	
	public Teacher() {}
	
	public Teacher(String login, String password, Language language, String id, String fullName, int salary, UrgencyLevel urgencylevel, TeacherRank teacherRank) {
		super(login, password, language, id, fullName, salary);
		this.urgencyLevel = urgencyLevel;
		this.teacherRank = teacherRank;
	}
	
    public Vector<Student> viewStudents() {
        Vector<Student> students = new Vector<Student>();
        for (Course cou : course) {
            students.addAll(cou.accessStudent);
        }
        return students;
    }
	public String getId() {
		return id;
	}
    public Vector<Course> viewCourses() {
        return course;
    }
    
    public void sendComplaints(Student student, String complaintText) {
        System.out.println("Complaint sent to " + student.fullName + ": " + complaintText);//complainttext какой то стринг жазуга болатындай ету керек
    }
    
    public String sendMessage(Employee employee, String messageText) {
        return "Message sent to " + employee.fullName + ": " + messageText;//messagetext какой то стринг болу керек
    }
    
    public double putMark(Student student, Course course, Mark mark) {
        // For example, find the student in the course and assign the mark
        if (course.accessStudent.contains(student)) {
            mark.course = course;
            mark.grade = 85;//мында оценканы сразу 85 етип койды а если 90 койгысы келсе ше?
            return mark.grade;
        } else {
            System.out.println("Error: Student or course not found.");
            return -1.0;
        }
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
    
    
}
