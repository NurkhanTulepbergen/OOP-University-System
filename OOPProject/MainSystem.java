package OOPProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class MainSystem {

	public static void main(String[] args){
		Admin admin = new Admin();
		Scanner in = new Scanner(System.in);
		Student s1 = new Student("sh_pakita", "Pakita05", Language.EN, "22B030455", "Pakita Shamoi", School.SITE, 2);
		Student s2 = new Student("a_taubaev", "Taubaev03", Language.EN, "22B030450", "Taubaev Azamat", School.SITE, 3);
		Student s3 = new Student("zh_suleimenova", "Suleimenova04", Language.EN, "22B030444", "Suleimenova Zhasmin", School.SITE, 4);
		Student s4 = new Student("a_taimas", "Taimas04", Language.RU, "22B030449", "Taimas Ayazhan", School.SITE,1);
		Student s5 = new Student("a_turzhanova", "Turzhanova05", Language.KZ, "22B030456", "Turzhanova Altynai", School.SITE, 2);
		Student s6 = new Student("e_bekbolat", "Bekbolat03", Language.EN, "20B030456", "Ernar Bekbolat", School.SITE, 3);
		
		Teacher bota = new Teacher("b_Dzhankieva", "Dzhankieva98", Language.EN, "18T010101", "Botagoz Dzhankieva", 5000000, TeacherRank.SENIOR_LECTURER);
		Teacher alya = new Teacher("a_borsykbaeva", "Borsykbaeva99", Language.EN, "18T010102", "Alya Borsykbaeva", 4500000, TeacherRank.SENIOR_LECTURER);
		Teacher arnur = new Teacher("a_kelgenbaev", "Kelgenbaev97", Language.EN, "18T010103", "Arnur Kelgenbaev", 3000000, TeacherRank.LECTURER);
		Teacher nurlan = new Teacher("n_manabaev", "Manabaev70", Language.EN, "18T010104", "Nurlan Manabaev", 2000000, TeacherRank.PROFESSOR);
		Teacher atsuchi = new Teacher("k_atsushi", "Atsushi03", Language.EN, "18T010105", "Kawai Atsuchi", 8000000, TeacherRank.PROFESSOR);
		
		Manager m = new Manager("s_undirbek", "Undirbek03", Language.EN, "18T010108", "Saken Undirbek", 10000000, ManagerType.OR);
		
		News n = new News("Final", "Final is finished");
		News n1 = new News("Retake OOP", "0.1% of students is has retake in OOP which teacher is Pakita Shamoi");
		News n2 = new News("Best teacher of year", "In the statistic of year the best teacher of the year is Pakita Shamoi");
		
		DataBase b = new DataBase();
		
		Course math = new Course("Mathematics", 4, 6, "MATH101", TypeOfCourse.MAJOR, "None", Period.FALL, bota);
        Course researchMethods = new Course("ResearchMethod ", 3, 5, "CS101", TypeOfCourse.ELECTIVE, Period.SPRING, atsuchi);
        Course phys = new Course("Physics", 4, 6, "PHYS101", TypeOfCourse.MAJOR, "Mathematics", Period.FALL, nurlan);
        Course hist = new Course("History", 3, 4, "HIST101", TypeOfCourse.MAJOR, Period.FALL, arnur);
        Course chem = new Course("Chemistry", 4, 6, "CHEM101", TypeOfCourse.ELECTIVE, "None", Period.SPRING, alya);
        Course eng = new Course("English", 3, 5, "ENGL101", TypeOfCourse.MAJOR, Period.SPRING, bota);
        Course bio = new Course("Biology", 4, 6, "BIO101", TypeOfCourse.MAJOR, "Chemistry", Period.FALL, nurlan);
        Course econ = new Course("Economics", 3, 5, "ECON101", TypeOfCourse.ELECTIVE, Period.FALL, arnur);
        Course psy = new Course("Psychology", 4, 6, "PSYCH101", TypeOfCourse.MAJOR, "None", Period.SPRING, alya);
        Course soc = new Course("Sociology", 3, 5, "SOC101", TypeOfCourse.MAJOR, Period.SPRING, atsuchi);
		
        
       
        Mark mark = new Mark(80);
        Mark mark1 = new Mark(85);
        Mark mark2 = new Mark(90);
        Mark mark3 = new Mark(95);
        Mark mark4 = new Mark(100);



       
        
        m.addCourse(bota, math);
        m.addCourse(atsuchi, researchMethods);
        m.addCourse(nurlan, phys);
        m.addCourse(alya, chem);
        m.addCourse(arnur, hist);
        
        DataBase.courses.add(math);
        DataBase.courses.add(researchMethods);
        DataBase.courses.add(phys);
        DataBase.courses.add(chem);
        DataBase.courses.add(hist);
        DataBase.courses.add(eng);
        DataBase.courses.add(bio);
        DataBase.courses.add(econ);
        DataBase.courses.add(psy);
        DataBase.courses.add(soc);

        DataBase.teacherCourses.put(bota, math);
        DataBase.teacherCourses.put(atsuchi, researchMethods);
        DataBase.teacherCourses.put(nurlan, phys);
        DataBase.teacherCourses.put(alya, chem);
        DataBase.teacherCourses.put(arnur, hist);

        // Enroll students in the courses
        DataBase.enrolledStudents.put(math, s1);
        DataBase.enrolledStudents.put(researchMethods, s1);
        DataBase.enrolledStudents.put(phys, s1);
        DataBase.enrolledStudents.put(chem, s1);
        DataBase.enrolledStudents.put(hist, s1);
        /*DataBase.enrolledStudents.put(s2, math);
        DataBase.enrolledStudents.put(s3, math);
        DataBase.enrolledStudents.put(s4, researchMethods);
        DataBase.enrolledStudents.put(s5, phys);
        */
        /*// View enrolled students for the courses
        pakita.viewEnrolledStudentsForCourse(comsci);
        bota.viewEnrolledStudentsForCourse(math);
        pakita.viewCoursesTaught(pakita);
        bota.viewCoursesTaught(bota);
*/
        // Put marks for students
        atsuchi.putMark(s1, researchMethods, mark1);
        bota.putMark(s1, math, mark);
        nurlan.putMark(s1, phys, mark2);
        arnur.putMark(s1, hist, mark3);
        alya.putMark(s1, chem, mark4);

        /*// View marks for students
        s1.viewMarksForCourse("Computer Science");
        s1.viewMarksForCourse("Mathematics");
        */
        //s1.viewTranscript();
        
        
        
        
		admin.addStudent(s6);
		admin.addStudent(s5);
		admin.addStudent(s4);
		admin.addStudent(s3);
		admin.addStudent(s2);
		admin.addStudent(s1);
		admin.addTeacher(bota);
		admin.addTeacher(nurlan);
		admin.addTeacher(alya);
		admin.addTeacher(arnur);
		admin.addTeacher(atsuchi);
		
		s2.joinToOrganization(s6, Organizations.BCL);
		s2.joinToOrganization(s5, Organizations.OCTOGRAMMA);
		s2.joinToOrganization(s4, Organizations.OSIT);
		s2.joinToOrganization(s3, Organizations.ARTHOUSE);
		s2.joinToOrganization(s2, Organizations.BCL);
		s2.joinToOrganization(s6, Organizations.OSIT);
		
		b.news.add(n);
		b.news.add(n2);
		b.news.add(n1);
		
		
		System.out.println("Login: " );
		String login = in.next();
		System.out.println("Password: ");
		String password = in.next();
		boolean exit = true;
		if(login.equals("admin") && password.equals("admin12345")) {
			ConsoleSystem.adminConsole();
		}
		ConsoleSystem.studentConsole(login, password);
		ConsoleSystem.teacherConsole(login, password);
		ConsoleSystem.managerSystem(login, password);
		
	}
}
