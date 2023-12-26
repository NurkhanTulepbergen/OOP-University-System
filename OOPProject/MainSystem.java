package OOPProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import Stream.Book;

public class MainSystem {

	public static void main(String[] args){
		Admin admin = new Admin();
		Scanner in = new Scanner(System.in);
		Student s1 = new Student("n_tulepbergen", "Nurkhan05", Language.EN, "22B030455", "Tulepbergen Nurkhan", School.SITE, 2, Period.FALL);
		Student s2 = new Student("a_taubaev", "Taubaev03", Language.EN, "22B030450", "Taubaev Azamat", School.SITE, 2, Period.FALL);
		Student s3 = new Student("zh_suleimenova", "Suleimenova04", Language.EN, "22B030444", "Suleimenova Zhasmin", School.SITE, 2, Period.FALL);
		Student s4 = new Student("a_taimas", "Taimas04", Language.RU, "22B030449", "Taimas Ayazhan", School.SITE, 2, Period.FALL);
		Student s5 = new Student("a_turzhanova", "Turzhanova05", Language.KZ, "22B030456", "Turzhanova Altynai", School.SITE, 2, Period.FALL);
		admin.addStudent(s5);
		admin.addStudent(s4);
		admin.addStudent(s3);
		admin.addStudent(s2);
		admin.addStudent(s1);
		System.out.println("Login: " );
		String login = in.next();
		System.out.println("Password: ");
		String password = in.next();
		boolean exit = true;
		if(login.equals("admin") && password.equals("admin12345")) {
			admin.adminConsole();
		}
		for(Student s: DataBase.students) {
			if(s.getLogin().equals(login) && s.getPassword().equals(password)) {
				System.out.println("You are succesfully join in system");
				while(exit) {
					System.out.println("1)News \n2)Information about student \n3)Organizations \n0)Exit");
					int number = in.nextInt();
					if(number == 1) {
						
					}else if(number == 2) {
						System.out.println(s);
					}else if(number == 3) {
						if(s.inOrganization!=null) {
							System.out.println(DataBase.organizations);
						}else {
							System.out.println("Choose Organization to join:");
							int i=1;
							for(Organizations o: Organizations.values()) {
								System.out.println(i+ ")"+ o);
								i++;
							}
							int choose = in.nextInt();
							if(choose == 1) {
								s.joinToOrganization(Organizations.ARTHOUSE, s);
							}else if(choose == 2) {
								s.joinToOrganization(Organizations.BCL, s);
							}else if(choose == 3) {
								s.joinToOrganization(Organizations.OSIT, s);
							}else if(choose == 4) {
								s.joinToOrganization(Organizations.OCTOGRAMMA, s);
							}
						}
					}else if(number == 4) {
						
					}else if(number == 5) {
						
					}else if(number == 0) {
						exit = false;
					}
					
				}

			}
		}
		for(Teacher t: DataBase.teachers) {
			if(t.getLogin().equals(login) && t.getPassword().equals(password)) {
				System.out.println("You are succesfully join in system");
				while(exit) {
					System.out.println("1)News \n2)Information about student \n3)Organizations \n0)Exit");
					int number = in.nextInt();
					if(number == 1) {
						
					}else if(number == 2) {
						
					}else if(number == 3) {
						
					}else if(number == 4) {
						
					}else if(number == 5) {
						
					}else if(number == 0) {
						exit = false;
					}
					
				}

			}
		}
	}
}
