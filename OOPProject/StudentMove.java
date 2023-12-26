package OOPProject;

import java.util.Vector;

public interface StudentMove {
	boolean registerCourse(Course course);
	void viewCourses(Vector<Course> courses);
	void teacherInfo(Vector<Teacher> teacher);
	void viewMarks(Vector<Mark> marks);
	void viewTranscript(Transcript transcript);
	void rateTeacher(Teacher teacher, double rate);
	boolean doDiplomaProject();
	Transcript getTranscript();
}
