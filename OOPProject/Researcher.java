package OOPProject;
import java.io.Serializable;
import java.util.Vector;



public class Researcher implements ResearcherMove, Serializable{
	public Vector<ResearchPaper> researchPaper = new Vector<ResearchPaper>();
	public Vector<ResearchProject> researchProject = new Vector<ResearchProject>();
	public int hindex;
	public String name;
	int hIndexLimit=5;
	public Researcher(String name) {
		this.name=name;
		this.hindex = 0;
	}
	public Researcher(String name,Vector<ResearchPaper> researchPaper, Vector<ResearchProject> researchProject) {
		this.name=name;
		this.researchPaper = researchPaper;
		this.researchProject = researchProject;
		this.hindex = this.calculateHIndex();
	}
	public Researcher(Vector<ResearchPaper> researchPaper, Vector<ResearchProject> researchProject) {
		this.researchPaper = researchPaper;
		this.researchProject = researchProject;
		this.hindex = this.calculateHIndex();
	}	
	public void makeResearch(String title, String Citation, int pages) {
		ResearchPaper r = new ResearchPaper(title, this.name, pages, Citation);
		researchPaper.add(r);
	}
	public void sortResearchPaper() {
		
	}
	@Override
	public void publishPaper(String title) {
		ResearchPaper rp = getResearchPaper(title);
		//System.out.println("Выпущено исследование:"+rp.title);
		//System.out.println(rp.getCitation());
		ResearchProject t = new ResearchProject(rp.title, rp);
		this.researchProject.add(t);
		this.researchPaper.remove(rp);
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
	public ResearchProject getResearchProject(String top) {

		ResearchProject rp = null;
		for(ResearchProject pi: researchProject) {
			if (pi.getTopic().equals(top)) {
				rp = pi;
				break;
			}
		}
		return rp;
	}
	@Override
	public ResearchPaper getResearchPaper(String title) {
		ResearchPaper rp = null;
		for(ResearchPaper pi: researchPaper) {
			if (pi.getTitle().equals(title)) {
				rp = pi;
				break;
			}
		}
		return rp;		
	}

	@Override
	public void viewAllWork() {
		for (ResearchProject proj:researchProject) {
			System.out.println(proj);
		}
	}
	
	@Override
	public int calculateHIndex() {
		Vector<Integer> intVector = new Vector<>();
		int t=0;
		intVector.add(1);
        for (int i=1;i<hIndexLimit;i++) {
        	t=t+i*2;
        	intVector.add(t);
        }
        int projNumb = this.researchProject.size(); 
        int hindex=0;
        for(int i=0;i<intVector.size();i++) {
        	if (projNumb<intVector.get(i)){
        		hindex=i;
        		break;
        	}
        }
        return hindex;
	}

	public boolean isSupervisor() {
		this.hindex=calculateHIndex();
		if (this.hindex>=3) {
			System.out.println("You supervisor");
			return true;
		}
		else {
			System.out.println("Sorry your index is not Enough");
			return false;
			
		}
	}
	
	public void getHIndexTableScore() {
		Vector<Integer> intVector = new Vector<>();
		int t=0;
		intVector.add(1);
        for (int i=1;i<hIndexLimit;i++) {
        	t=t+i*2;
        	intVector.add(t);
        }
        System.out.println("___________________________");
        System.out.println("|Hindex|number of Projects|");
        System.out.println("+------+------------------+");
        for (int i=0;i<5;i++) {
        	if (intVector.get(i)>9) {
        		System.out.println("|"+(i+1)+"     |"+intVector.get(i)+"                |");
            	System.out.println("+------+------------------+");
        	}
        	else {
        		System.out.println("|"+(i+1)+"     |"+intVector.get(i)+"                 |");
        		System.out.println("+------+------------------+");
        	}
        	
        }
	}

	public void setHIndexLimit(int numberOfLevels) {
		this.hindex=numberOfLevels;
	}
}
