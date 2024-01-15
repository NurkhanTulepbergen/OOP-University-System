package OOPProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.Vector;


public class DataBase implements Serializable{
	private static final long serialVersionUID = 1L;
    static Vector<User> users = new Vector<User>();
    static Vector<Student> students = new Vector<Student>();
    static Vector<Teacher> teachers = new Vector<Teacher>();
    static HashMap<Student, Organizations> organizations = new HashMap<Student, Organizations>();
    static Vector<Course> registercourses = new Vector<Course>();
    static HashMap<Course, Student> enrolledStudents = new HashMap<>();
    static Vector<Mark> marks = new Vector<Mark>();
    static Vector<Course> courses = new Vector<Course>();
	static HashMap<Teacher, Course> teacherCourses = new HashMap<>();
    static Vector<News> news = new Vector<News>();
    static Vector<Manager> managers = new Vector<Manager>();
    static Map<Student, Map<Course, Mark>> studentMarks = new HashMap<>();
    public DataBase() {
    }

    public static void serialize() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("database.ser"))) {
            oos.writeObject(DataBase.getInstance());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database.ser"))) {
            DataBase instance = (DataBase) ois.readObject();
            updateInstance(instance);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void updateInstance(DataBase newInstance) {
        users = newInstance.users;
        students = newInstance.students;
        teachers = newInstance.teachers;
        organizations = newInstance.organizations;
        courses = newInstance.courses;
        enrolledStudents = newInstance.enrolledStudents;
        marks = newInstance.marks;
        news = newInstance.news;
    }

    private static DataBase instance;

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }
}
