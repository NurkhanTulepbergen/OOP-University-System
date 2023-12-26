package OOPProject;

import java.util.Vector;

public class TechSupport extends Employee{
	public static Vector<TechSupportOrder> newOrder = new Vector<TechSupportOrder>();
	public static Vector<TechSupportOrder> doneOrder = new Vector<TechSupportOrder>();
	public TechSupport() {
		
	}
	public TechSupport(String login, String password, Language language, String id, String fullName, int salary) {
		super(login, password, language, id, fullName, salary);
	}
	
	public boolean acceptedOrder(TechSupportOrder order) {
		order.setAccepted(true);
		return doneOrder.add(order);
	}
	
	public boolean rejectOrder(TechSupportOrder order) {
		return false;
	}
	
	public Vector<TechSupportOrder> viewNewOrder() {
		return newOrder;
	}
	
	@Override
	public String sendMessage(String s) {
		// TODO Auto-generated method stub
		return s;
	}

	@Override
	public String report(String s) {
		// TODO Auto-generated method stub
		return s;
	}
}
