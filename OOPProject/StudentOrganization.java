package OOPProject;
import java.util.Vector;

public class StudentOrganization {
	public String name;
	public Student head;
	public static Vector<Student> members = new Vector<Student>();
	public Organizations nameOrganization;
	
	public StudentOrganization() {
		
	}
	public StudentOrganization(String name, Student head, Organizations nameOrganization) {
		this.name= name;
		this.head = head;
		this.nameOrganization = nameOrganization;
		members.add(head);
	}
}
