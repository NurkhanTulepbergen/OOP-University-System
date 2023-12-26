package OOPProject;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment {
	public String author;
	public LocalDateTime dateWritten;
	public String text;
	public Comment() {
		
	}
	public Comment(String author, String text) {
		this.author=author;
		this.dateWritten=LocalDateTime.now();
		this.text=text;
	}
	public String toString() {
		return "Author: " + author + "\n"
				+ text + "\n" + 
				"Date: " + dateWritten;
	}
}
