/* Quinn Olson */

public class Faculty extends Employee {
	public short officeHours;
	public String rank;
	
	@Override
	public String toString() {
		return "Faculty Member " + super.toString() + "\nOfficeHours= " + officeHours + "\nRank= " + rank;
	}
	
	public Faculty() {
		super();
		this.officeHours = 0;
		this.rank = "";
	}
	
	public Faculty(String name, String address, long phoneNumber, String email,
			String office, int salary, short year, short month, short day, short officeHours, String rank) {
		super(name, address, phoneNumber, email, office, salary, year, month, day);
		this.officeHours = officeHours;
		this.rank = rank;
	}

	public short getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(short officeHours) {
		this.officeHours = officeHours;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
