package OOPProject;

public class TechSupportOrder {
	public String description;
	public boolean accepted;
	public TechSupportOrder() {
		
	}
	public TechSupportOrder(String description) {
		this.description = description;
	}
	
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public boolean getaccepted() {
		return accepted;
	}
}
