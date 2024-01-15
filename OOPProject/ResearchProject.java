package OOPProject;

import java.io.Serializable;
import java.util.Vector;

public class ResearchProject implements Serializable{
	public String topic;
	public Vector<ResearchPaper> publishedPapers = new Vector<ResearchPaper>();
	public Vector<Researcher> participants = new Vector<Researcher>();
	public ResearchProject(String topic) {
		this.topic=topic;
	}
	
	public ResearchProject(String topic, ResearchPaper paper) {
		this.topic=topic;
		this.addPublishedPapers(paper);
	}
	
	public void addParticipants(Researcher r) {
		this.participants.add(r);
	}
	public void addPublishedPapers(ResearchPaper paper) {
		
		this.publishedPapers.add(paper);
	}
	
	public String toString() {
		for(ResearchPaper p: publishedPapers) {
			return "Topic: " + topic + ", citation: " + p.getCitation();
		}
		return topic;
		
	}
	
	public String getTopic() {
		return this.topic;
	}
}
