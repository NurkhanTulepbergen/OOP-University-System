package OOPProject;

import java.util.Scanner;
import java.util.Vector;

public class Admin {
	Scanner in = new Scanner(System.in);
	public Admin() {
		
	}
	public static void addStudent(Student u) {
		DataBase.students.add(u);
		DataBase.users.add(u);
	}
	
	public static void addTeacher(Teacher u) {
		DataBase.users.add(u);
		DataBase.teachers.add(u);
	}
	public static boolean removeStudent(Student u) {
		DataBase.users.remove(u);
		return DataBase.students.remove(u);
	}
	public static boolean removeTeacher(User u) {
		DataBase.users.remove(u);
		return DataBase.teachers.remove(u);
	}
	public static void seeLogs() {
		for(User u: DataBase.users) {
			System.out.println(u);
		}
	}
}
