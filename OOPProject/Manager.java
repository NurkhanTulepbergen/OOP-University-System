package OOPProject;

import java.util.Vector;

public class Manager extends Employee{
	public ManagerType managerType;
	public Manager() {
		
	}
	public Manager(ManagerType managerType) {
		this.managerType = managerType;
	}
	
	public boolean approveStudentRegistration(Student s, Course c) {
		return s.registerCourse(c);
		
	}
	 public boolean addCoursesForRegistration(Course c) {
		return c.courses.add(c);
	 }
	
	 public boolean assignCoursesToTeachers(Course c, Tecaher t) {
		return c.coursesForTeacher(c,t);
	 }
	
	 public void createAcademicReports() {
		System.out.println("The name of Students, courses, and their marks is: ");
		System.out.println(Course.coursesForStudent);
	 }
	
	
	 public void viewInfoTeacher() {
		 for(Teacher teacher : Teacher.teachers) {
			 System.out.println(teacher);
		 }
	 }
	
	public String viewRequestsFromEmployees() {
		return null;
	}//	NADO NAPISAT
	
	@Override
	public String report() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 public Vector<Student> viewInfoStudent() {
	 
	 }
	 */
	@Override
	public String sendMessage(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
