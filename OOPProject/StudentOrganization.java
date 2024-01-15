package OOPProject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

public class StudentOrganization implements Serializable{
	public Student head;
	public Organizations nameOrganization;
	static HashMap<Organizations,Student> organizations;
	static {
		if(new File("organizations.ser").exists()) {
			try {
				organizations = readOrganizations();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else organizations = new HashMap<Organizations, Student>();
	}
	public StudentOrganization() {
		
	}
	private static HashMap<Organizations, Student> readOrganizations() throws Exception {
		FileInputStream fis = new FileInputStream("organizations.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		HashMap<Organizations,Student> organizations = (HashMap<Organizations,Student>)ois.readObject();
		fis.close();
		ois.close();
		return organizations;
	}
	static void saveOrganizations() throws Exception {
		FileOutputStream fos = new FileOutputStream("organizations.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(organizations);
		fos.close();
		oos.close();
	}
}
