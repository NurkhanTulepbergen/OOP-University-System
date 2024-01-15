package OOPProject;

import java.util.Vector;

public interface StudentMove {
	void registerCourse(Course course);
	void viewCourses();
	void teacherInfo();
	void viewMarksForCourse(String disciplineName);
	void viewTranscript();
	void rateTeacher(Teacher teacher, int rating);
}
