package OOPProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

import Stream.Book;

public class DataBase implements Serializable{
	static Vector<User> users = new Vector<User>();
	static Vector<Student> students = new Vector<Student>();
	static Vector<Teacher> teachers = new Vector<Teacher>();
	static HashMap<Organizations,Student> organizations = new HashMap<Organizations, Student>();
	static Vector<Course> registerCourses = new Vector<Course>();
	static HashMap<Student, Course> enrolledStudents = new HashMap<>();
	static Vector<Mark> marks = new Vector<Mark>();
	static Vector<Course> courses = new Vector<Course>();
	static HashMap<Teacher, Course> teacherCourses = new HashMap<>();
}
