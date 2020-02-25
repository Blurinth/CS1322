/* Quinn Olson */

public class Employee extends Person {
	public String office;
	public int salary;
	public short year;
	public short month;
	public short day;
	
	@Override
	public String toString() {
		return  (!(this instanceof Faculty || this instanceof Staff)? "Employee " : "") + super.toString() + "\nOffice= " + office + "\nSalary= $" + salary 
				+ "\nHired on " + month + "/" + day + "/" + year;
	}
	
	public Employee() {
		super();
		this.office = "";
		this.salary = 0;
		this.year = 0;
		this.month = 0;
		this.day = 0;
	}
	
	public Employee(String name, String address, long phoneNumber, String email, 
			String office, int salary, short year, short month, short day) {
		super(name, address, phoneNumber, email);
		this.office = office;
		this.salary = salary;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public short getDay() {
		return day;
	}

	public void setDay(short day) {
		this.day = day;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public short getMonth() {
		return month;
	}

	public void setMonth(short month) {
		this.month = month;
	}
	
}
