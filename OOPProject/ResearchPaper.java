package OOPProject;

import java.io.Serializable;
import java.util.Date;

public class ResearchPaper implements Serializable{
	public String title;
	public String author;
	public int pages;
	public Date date;
	public String citation;

	public ResearchPaper(String title, String author,int pages, String citation) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.date = new Date();
		this.citation = citation;
	}
	
	public String getCitation(){
		return "" + this.citation+", said by:" + this.author;
	}
	
    public Date getDate() {
        return date;
    }
    
    public String getTitle() {
    	return this.title;
    }

}
