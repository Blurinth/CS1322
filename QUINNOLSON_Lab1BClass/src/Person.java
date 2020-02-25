/* Quinn Olson */

import java.util.Scanner;

public class Person {
	public String firstName;
	public String lastName;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person personA = new Person();
		System.out.print("Enter your first name: ");
		String firstName = sc.nextLine();
		System.out.print("Enter your last name: ");
		String lastName = sc.nextLine();
		Person personB = new Person(firstName, lastName);
		System.out.println("Person A: " + personA 
				+ "\nPerson B: " + personB);
		personA.firstName = "Aly";
		personB.lastName = "Sanchez";
		System.out.println("Person A: " + personA 
				+ "\nPerson B: " + personB);
	}
	
	public Person() {
		firstName = "Bob";
		lastName = "Smith";
	}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}