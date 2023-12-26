package OOPProject;

import java.util.Scanner;
import java.util.Vector;

public class Admin {
	Scanner in = new Scanner(System.in);
	public Admin() {
		
	}
	public void addStudent(Student u) {
		DataBase.students.add(u);
		DataBase.users.add(u);
	}
	
	public void addTeacher(Teacher u) {
		DataBase.users.add(u);
		DataBase.teachers.add(u);
	}
	public boolean removeStudent(Student u) {
		DataBase.users.remove(u);
		return DataBase.students.remove(u);
	}
	public boolean removeTeacher(User u) {
		DataBase.users.remove(u);
		return DataBase.teachers.remove(u);
	}
	/*
	public boolean update(User u) {
		return User.users.size() != 0;
	}*/
	public void seeLogs() {
		for(User u: DataBase.users) {
			System.out.println(u);
		}
	}
	public void adminConsole() {
		System.out.println("Welcome owner of system");
		boolean exit = true;
		while(exit) {
			System.out.println("1)Add student \n2)Add teacher \n3)Delete user \n4)Update system \n0)Exit");
			int number = in.nextInt();
			if(number == 1) {
				System.out.println("Login: ");
				String login1 = in.next();
				System.out.println("Password: ");
				String password1 = in.next();
				System.out.println("Id: ");
				String id = in.next();
				System.out.println("Full Name: ");
				String fullName = in.next();
				System.out.println("School: 1)SITE, 2)SG, 3)SEOGI, 4)SNSS, 5)BS, 6)ISE, 7)KMA, 8)SCE, 9)SAM, 10)SMSGT");
				String school = in.next();
				System.out.println("Course: ");
				int course = in.nextInt();
				System.out.println("Period: 1)FALL ,2)SPRING, 3)SUMMER");
				String period = in.next();
				//Student f  = new Student(login1, password1, Language.EN, id, fullName, school)
			}else if(number == 2) {
				
			}else if(number == 3) {
				System.out.println("Write id for delete: ");
				String id = in.next();
				for(Student s:DataBase.students) {
					if(s.getId().equals(id)) {
						removeStudent(s);
						System.out.println("Student is succesfully deleted");
						break;
					}
				}
				for(Teacher t:DataBase.teachers) {
					if(t.getId().equals(id)) {
						removeTeacher(t);
						System.out.println("Teacher is succesfully deleted");
						break;
					}
				}
			}else if(number == 4) {
				
				
			}else if(number == 0) {
				exit = false;
			}
		}
	}
}
