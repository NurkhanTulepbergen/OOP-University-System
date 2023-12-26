package OOPProject;

import java.util.Comparator;
import java.util.Vector;

public interface ResearcherMove {
	
	public void printPaper(Comparator<ResearchPaper> c);
	public void addResearchProject(ResearchProject p);
	public void addResearchPaper(ResearchPaper p);	
	public void getResearchProject(ResearchProject p);
	public void getResearchPaper(Vector<ResearchProject> researchProject);
	public void viewAllWork();
	public int calculateHIndex(int LowHIndexException);
}
