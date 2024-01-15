package OOPProject;

import java.io.Serializable;

public class Transcript implements Serializable{
	public String idCourse;
	public Course course;
	public int credit;
	public int ect;
	public Mark mark;
	public double GPA;
	
	public String showTranscript() {
		return " Course name: " + course + " Mark: " + mark + " GPA: " + GPA;
	}
}