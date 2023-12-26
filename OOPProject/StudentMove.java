package projects;

import java.util.Vector;

public interface StudentMove {
	boolean registerCourse(Course course);
	void viewCourses();
	void teacherInfo();
	void viewMarks(String disciplineName);
	void viewTranscript();
	void rateTeacher(Teacher teacher, int rating);
}
