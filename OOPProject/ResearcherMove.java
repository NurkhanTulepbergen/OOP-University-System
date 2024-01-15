package OOPProject;

import java.util.Comparator;
import java.util.Vector;

public interface ResearcherMove {	
	public void addResearchProject(ResearchProject p);
	public void addResearchPaper(ResearchPaper p);	
	public ResearchProject getResearchProject(String top);
	public ResearchPaper getResearchPaper(String title);
	public void viewAllWork();
	public int calculateHIndex();
	public void publishPaper(String title);
}
