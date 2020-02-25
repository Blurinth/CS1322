/* Quinn Olson */

public class Staff extends Employee {
	public String title;

	@Override
	public String toString() {
		return "Staff Member " + super.toString() + "\nTitle= " + title;
	}
	
	public Staff() {
		super();
		this.title = "";
	}
	
	public Staff(String name, String address, long phoneNumber, String email, 
			String office, int salary, short year, short month, short day, String title) {
		super(name, address, phoneNumber, email, office, salary, year, month, day);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
