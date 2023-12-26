package OOPProject;

import java.util.Vector;

public class ResearchProject {
	public String topic;
	public static Vector<ResearchPaper> publishedPapers = new Vector<ResearchPaper>();
	public Vector<Researcher> participants = new Vector<Researcher>();
	
	public ResearchProject() {
		
	}
	
	public ResearchProject(String topic) {
		this.topic=topic;
	}
	
	public void addParticipants(Researcher r) {
		this.participants.add(r);
	}
	public void addPublishedPapers(ResearchPaper paper) {
		this.publishedPapers.add(paper);
		
	}public String toString() {
		return "Topic: " + topic;
	}
}
