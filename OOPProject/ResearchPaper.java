package OOPProject;

import java.util.Date;

public class ResearchPaper {
	public String title;
	public String author;
	public int pages;
	public Date date;
	public String citation;
	public ResearchPaper() {
		
	}
	public ResearchPaper(String title, String author,int pages, Date date, String citation) {
		this.title=title;
		this.author=author;
		this.pages=pages;
		this.date=date;
		this.citation=citation;
	}
	
	public String getCitation(Format f2){
		if(f2.equals(Format.BIBTEX)) {
			return citation;
		}else {
			return citation;
		}
	}//NADO DORABOTAT
	
    public Date getDate() {
        return date;
    }

}
