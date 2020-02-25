/* Quinn Olson */

public class Student extends Person {
	public String classStatus;

	@Override
	public String toString() {
		return "Student " + super.toString() + "\nclassStatus= " + classStatus;
	}
	
	public Student() {
		super();
		this.classStatus = "";
	}
	
	public Student(String name, String address, long phoneNumber, String email, 
			String classStatus) {
		super(name, address, phoneNumber, email);
		this.classStatus = classStatus;
	}

	public String getclassStatus() {
		return classStatus;
	}

	public void setclassStatus(String classStatus) {
		this.classStatus = classStatus;
	}
	
}
