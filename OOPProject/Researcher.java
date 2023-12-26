package OOPProject;
import java.util.Comparator;
import java.util.Vector;



public class Researcher  implements ResearcherMove{
	public Vector<ResearchPaper> researchPaper = new Vector<ResearchPaper>();
	public Vector<ResearchProject> researchProject = new Vector<ResearchProject>();
	public int hindex;
	public Researcher(Vector<ResearchPaper> researchPaper,Vector<ResearchProject> researchProject,int hindex) {
		this.researchPaper = researchPaper;
		this.researchProject = researchProject;
		this.hindex = hindex;
	}
	public void sortResearchPaper() {
		
	}
	@Override
	public void printPaper(Comparator<ResearchPaper> c) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addResearchProject(ResearchProject p) {
		// TODO Auto-generated method stub
		this.researchProject.add(p);
	}
	@Override
	public void addResearchPaper(ResearchPaper p) {
		// TODO Auto-generated method stub
		this.researchPaper.add(p);
	}
	@Override
	public void getResearchProject(ResearchProject p) {
		// TODO Auto-generated method stub
		for(ResearchProject pi: researchProject) {
			System.out.println(pi);
		}
		
	}
	@Override
	public void getResearchPaper(Vector<ResearchProject> researchProject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void viewAllWork() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int calculateHIndex(int LowHIndexException) {
		// TODO Auto-generated method stub
		return 0;
	}
}
