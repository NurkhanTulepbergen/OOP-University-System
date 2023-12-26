package OOPProject;

public class Transcript {
	public Course course;
	public Mark mark;
	public double GPA;
	
	public Transcript() {
		
	}
	public Transcript(Course course, Mark mark, double GPA) {
		this.course = course;
		this.mark = mark;
		this.GPA = GPA;
	}
	public String showTranscript() {
		return " Course name: " + course + " Mark: " + mark + " GPA: " + GPA;
	}
}
