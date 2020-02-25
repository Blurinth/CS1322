/* Quinn Olson */

public class Person {
	public String name;
	public String address;
	public long phoneNumber;
	public String email;
	
	@Override
	public String toString() {
		return (!(this instanceof Employee || this instanceof Student) ? "Person " : "") + name + "\nAddress= " + address + "\nPhone Number= " 
				+ phoneNumber + "\nEmail= " + email;
	}
	
	public Person() {
		this.name = "";
		this.address = "";
		this.phoneNumber = 0;
		this.email = "";
	}

	public Person(String name, String address, long phoneNumber, String email) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
