package OOPProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Scanner;

public class ConsoleSystem {
	static boolean  exit = true;
	static Scanner in = new Scanner(System.in);
	public static void adminConsole() {
		System.out.println("Welcome owner of system");
		while(exit) {
			System.out.println("1)Add user \n2)Delete user \n3)See users \n0)Exit");
			int number = in.nextInt();
			if(number == 1) {
				System.out.println("1)Teacher, 2)Student");
				int choose = in.nextInt();
				if(choose == 1) {
					System.out.println("Login: ");
					String login1 = in.next();
					System.out.println("Password: ");
					String password1 = in.next();
					System.out.println("Id: ");
					String id = in.next();
					System.out.println("Full Name: ");
					String fullName = in.next();
					System.out.println("Salary: ");
					int salary = in.nextInt();
					System.out.println("Teacher rank: 1)LECTURER, 2)SENIOR_LECTURER, 3)TUTOR, 4)PROFESSOR");
					String rank = in.next();	
			        for(TeacherRank tr: TeacherRank.values()) {
						if(rank.equals(tr)) {
							Teacher t = new Teacher(login1,password1,Language.EN, id, fullName, salary, tr);
							Admin.addTeacher(t);
							System.out.println("Teacher succesfully add in system");
							break;
						}
					}
				}else if(choose == 2) {
					System.out.println("Login: ");
					String login1 = in.next();
					System.out.println("Password: ");
					String password1 = in.next();
					System.out.println("Id: ");
					String id = in.next();
					System.out.println("Full Name: ");
					String fullName = in.next();
					System.out.println("School: 1)SITE, 2)SG, 3)SEOGI, 4)SNSS, 5)BS, 6)ISE, 7)KMA, 8)SCE, 9)SAM, 10)SMSGT");
					String school1 = in.next();
					System.out.println("Course: ");
					int course = in.nextInt();	
			        for(School sch: School.values()) {
						if(school1.equals(sch)) {
							Student f  = new Student(login1, password1, Language.EN, id, fullName, sch, course);
							Admin.addStudent(f);
							System.out.println("Student succesfully add in system");
							break;
						}
					}
				}
			}else if(number == 2) {
				System.out.println("Write id for delete: ");
				String id = in.next();
				for(Student s:DataBase.students) {
					if(s.getId().equals(id)) {
						Admin.removeStudent(s);
						System.out.println("Student is succesfully deleted");
						break;
					}
				}
				for(Teacher t:DataBase.teachers) {
					if(t.getId().equals(id)) {
						Admin.removeTeacher(t);
						System.out.println("Teacher is succesfully deleted");
						break;
					}
				}
			}else if(number == 3) {
				Admin.seeLogs();
			}else if(number == 0) {
				exit = false;
			}
		}
	}
	public static void studentConsole(String login, String password) {
		for(Student s: DataBase.students) {
			if(s.getLogin().equals(login) && s.getPassword().equals(password)) {
				System.out.println("You are succesfully join in system");
				while(exit) {
					System.out.println("1)News \n2)Information about student \n3)Organizations \n4)Course \n5)Mark  \n6)Transcript \n7)Register Course \n8)Rate Teacher \n0)Exit");
					int number = in.nextInt();
					if(number == 1) {
						int j = 1;
						for(News n:DataBase.news) {
							System.out.println(j +")" + n);
							j++;
						}
					}else if(number == 2) {
						System.out.println(s);
					}else if(number == 3) {
						int c = 0;
						if(s.inOrganization!=null) {
							s.printStudentsInOrganization(s.inOrganization);
						}else {
							System.out.println("Choose Organization to join:");
							int i=1;
							for(Organizations o: Organizations.values()) {
								System.out.println(i+ ")"+ o);
								i++;
							}
							int choose = in.nextInt();
							Organizations selectedOrganization = null;
                            switch (choose) {
                                case 1:
                                    selectedOrganization = Organizations.ARTHOUSE;
                                    break;
                                case 2:
                                    selectedOrganization = Organizations.BCL;
                                    break;
                                case 3:
                                    selectedOrganization = Organizations.OSIT;
                                    break;
                                case 4:
                                    selectedOrganization = Organizations.OCTOGRAMMA;
                                    break;
                                // Add other cases if needed
                            }
                            if (selectedOrganization != null) {
                                s.joinToOrganization(s, selectedOrganization);
                            }
						}
					}else if(number == 4) {
						s.viewCourses();
					}else if(number == 5) {
						//String disName = in.next();
						s.viewMarksForCourse(in.next());
					}else if(number == 6) {
						s.viewTranscript();
					}else if(number == 7) {
						String nameCourse = in.next();
						for(Course c: DataBase.courses) {
							if(c.getCourseName().equals(nameCourse)) {
								s.registerCourse(c);
							}
						}
					}else if(number == 8) {
						System.out.println("Write id: ");
						String id = in.next();
						System.out.println("Write mark for teacher: ");
						while (!in.hasNextInt()) {
						    System.out.println("Invalid input. Please enter a valid integer.");
						    in.next(); // Consume the invalid input
						}
						int rankks = in.nextInt();
						for(Teacher t:DataBase.teachers) {
							if(t.getId().equals(id)) {
								s.rateTeacher(t, rankks);
							}
						}
						
					}else if(number == 0) {
						exit = false;
					}
					
				}

			}
		}
	}
	public static void teacherConsole(String login, String password) {
		for(Teacher t: DataBase.teachers) {
			if(t.getLogin().equals(login) && t.getPassword().equals(password)) {
				System.out.println("You are succesfully join in system");
				System.out.println("1)Teacher, 2)Researcher");
				int number1 = in.nextInt();
				if(number1 == 1) {
					while(exit) {
					System.out.println("1)News \n2)Information about teacher  \n3)View courses taught \n4)View students \n5)Send complaint \n6)Put mark  \n0)Exit");
					int number = in.nextInt();
					if(number == 1) {
						int j = 1;
						for(News n:DataBase.news) {
							System.out.println(j +")" + n);
							j++;
						}
					}else if(number == 2) {
						System.out.println(t);
					}else if(number == 3) {
						t.viewCoursesTaught(t);
					}else if(number == 4) {
						for (Map.Entry<Teacher, Course> entry : DataBase.teacherCourses.entrySet()) {
				            Course c3 = entry.getValue();
				            Teacher t3 = entry.getKey();
				            if(t3 == t) {
				            	t.viewEnrolledStudentsForCourse(c3);
				            	break;
				            }
				        }
						
					}else if(number == 5) {
						System.out.println("Write full name of student");
						String fullname = in.next();
						for(Student kl:DataBase.students) {
							if(fullname.equals(kl.getStudentName())) {
								System.out.println("Write context of report:");
								String rep = in.next();
								System.out.println("Choose urgancy level: 1)LOW, 2)MEDIUM, 3)HIGH");
								int urlev = in.nextInt();
								if(urlev == 1) {
									t.sendComplaint(kl, rep, UrgencyLevel.LOW, ManagerType.OR);
								}else if(urlev == 2) {
									t.sendComplaint(kl, rep, UrgencyLevel.MEDIUM, ManagerType.OR);
								}else if(urlev == 3) {
									t.sendComplaint(kl, rep, UrgencyLevel.HIGH, ManagerType.OR);
								}
								
							}
						}
						
						
					}else if(number == 6) {
						System.out.println("Put mark:");
						int markk = in.nextInt();
						Mark mark = new Mark(markk);
						System.out.println("Id:");
						String name = in.next();
						Course currentcourse = null;;
						for (Map.Entry<Teacher, Course> entry : DataBase.teacherCourses.entrySet()) {
				            Course teacherCourse= entry.getValue();
				            Teacher teacher = entry.getKey();
				            if(teacher == teacher) {
				            	currentcourse = teacherCourse;
				            	break;
				            }
				        }
						for (Map.Entry<Course, Student> entry : DataBase.enrolledStudents.entrySet()) {
				            Course enrolledCourse= entry.getKey();
				            Student student = entry.getValue();
				            if(student.getId().equals(name)) {
				            	t.putMark(student, currentcourse, mark);
				            	System.out.println("Mark succesfully added");
				            	break;
				            }
				        }
						
					}else if(number == 0) {
						exit = false;
					}
					}
				}else if(number1 == 2) {
					while(exit) {
						System.out.println("1)News \n2)Information about researhcer \n3)Get Hindex table \n4)Supervisor  \n5)View all work  \n0)Exit");
						int number = in.nextInt();
						Researcher r = new Researcher(t.getTeacherName()); 
						r.makeResearch("OOP Final", "Goodluck", 3);
						r.publishPaper("OOP Final");
						r.makeResearch("Singleton", "Ensure a class has only one instance and provide a global point to that instance.", 3);
						r.makeResearch("Registry","Maintain a central registry of objects and provide a way to access them throughout the system", 3);
						r.makeResearch("Multiton","Ensure a class has only named instances and provide a global point to access those instances.", 3);
						r.makeResearch("Factory","Define an interface for creating an object, but let subclasses alter the type of objects that will be created.", 3);
						r.makeResearch("Service Locator","Provide a centralized way to locate various services by using a single locator.", 3);
						r.makeResearch("Adapter", "Convert the interface of a class into another interface that clients expect.", 3);
						r.publishPaper("Singleton");
						r.publishPaper("Registry");
						r.publishPaper("Multiton");
						r.publishPaper("Factory");
						r.publishPaper("Service Locator");
						r.publishPaper("Adapter");
						if(number == 1) {
							int j = 1;
							for(News n:DataBase.news) {
								System.out.println(j +")" + n);
								j++;
							}
						}else if(number == 2) {
							System.out.println(t);
						}else if(number == 3) {
							r.getHIndexTableScore();
						}else if(number == 4) {
							r.isSupervisor();
						}else if(number == 5) {
							r.viewAllWork();
						}else if(number == 0) {
							exit = false;
						}
					}

				}
			}
		}
	}
	public static void managerSystem(String login, String password) {
		for(Manager m: DataBase.managers) {
			if(m.getLogin().equals(login) && m.getPassword().equals(password)) {
				System.out.println("You are succesfully join in system");
					while(exit) {
						System.out.println("1)News \n2)Enrolled Student \n3)Enrolled teacher to course \n4)Drop teacher of course \n5)View teacher info \n6)View student info \n7)Create academic reports \n0)Exit");
						int number = in.nextInt();
						if(number == 1) {
							int j = 1;
							for(News n:DataBase.news) {
								System.out.println(j +")" + n);
								j++;
							}
						}else if(number == 2) {
							m.enrollStudent(null, null);
						}else if(number == 3) {
							DataBase.teacherCourses.put(null,null);
						}else if(number == 4) {
							DataBase.teacherCourses.remove(null);
						}else if(number == 5) {
							System.out.println(DataBase.teachers);
						}else if(number == 6) {
							System.out.println(DataBase.students);
						}else if(number == 7) {
							m.createAcademicReports();
						}else if(number == 0) {
							exit = false;
						}
					}
			}
		}
	}
}
