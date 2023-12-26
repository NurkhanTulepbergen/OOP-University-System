package OOPProject;

import java.util.Vector;


public class DiplomProjects {
    private String title;

    public DiplomProjects(String title) {
        this.title = title;
    }

    public void addResearchPaper(ResearchPaper paper) {
        ResearchProject.publishedPapers.add(paper);
    }

    public void viewResearchPapers() {
        System.out.println("Research Papers for Diploma Project: " + title);
        for (ResearchPaper paper : ResearchProject.publishedPapers) {
            System.out.println("Title: " + paper.title);
            System.out.println("Authors: " + paper.author);
            System.out.println("Pages: " + paper.pages);
        }
    }
}
