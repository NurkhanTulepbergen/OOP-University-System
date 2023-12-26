package OOPProject;

import java.util.Date;
import java.util.Vector;

public class News {
	public String topic;
	public String text;
	public Date date;
	public Vector<Comment> comments = new Vector<Comment>();
	public News(String topic, String text) {
		this.topic=topic;
		this.text=text;
	}
	public void writeCommentInNews(Comment e) {
		comments.add(e);
	}
}
