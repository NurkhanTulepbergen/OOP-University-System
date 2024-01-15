package OOPProject;

import java.util.Date;
import java.util.Vector;

public class News {
	public String topic;
	public String text;
	public Date date;
	public News(String topic, String text) {
		this.topic=topic;
		this.text=text;
	}
	public String toString() {
		return "Topic: " + topic + "\n" +
				"Text: " + text + "\n"; 
	}
}
