/* Quinn Olson */

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String field = "";
		Person p = new Person();
		for(int i = 0; i < 4; i++) {
			switch(i) {
				case 0: field = "Name: "; break;
				case 1: field = "Address: "; break;
				case 2: field = "Phone Number: "; break;
				case 3: field = "Email Address: "; break;
			}
			System.out.print("\nEnter Person's " + field);
			switch(i) {
				case 0: p.setName(sc.nextLine());; break;
				case 1: p.setAddress(sc.nextLine()); break;
				case 2: p.setPhoneNumber(sc.nextLong()); sc.nextLine(); break;
				case 3: p.setEmail(sc.nextLine()); break;
				default: p.setEmail("what");
			}
		}
		Employee e = new Employee();
		for(int i = 0; i < 9; i++) {
			switch(i) {
				case 0: field = "Name: "; break;
				case 1: field = "Address: "; break;
				case 2: field = "Phone Number: "; break;
				case 3: field = "Email Address: "; break;
				case 4: field = "Office: "; break;
				case 5: field = "Salary: "; break;
				case 6: field = "Year Hired: "; break;
				case 7: field = "Month Hired: "; break;
				case 8: field = "Day Hired: "; break;
			}
			System.out.print("\nEnter Employee's " + field);
			switch(i) {
				case 0: e.setName(sc.nextLine());; break;
				case 1: e.setAddress(sc.nextLine()); break;
				case 2: e.setPhoneNumber(sc.nextLong()); sc.nextLine(); break;
				case 3: e.setEmail(sc.nextLine()); break;
				case 4: e.setOffice(sc.nextLine()); break;
				case 5: e.setSalary(sc.nextInt()); sc.nextLine(); break;
				case 6: e.setYear(sc.nextShort()); sc.nextLine(); break;
				case 7: e.setMonth(sc.nextShort()); sc.nextLine(); break;
				case 8: e.setDay(sc.nextShort()); sc.nextLine(); break;
			}
		}
		Student stu = new Student();
		for(int i = 0; i < 5; i++) {
			switch(i) {
				case 0: field = "Name: "; break;
				case 1: field = "Address: "; break;
				case 2: field = "Phone Number: "; break;
				case 3: field = "Email Address: "; break;
				case 4: field = "Class Status: "; break;
			}
			System.out.print("\nEnter Student's " + field);
			switch(i) {
				case 0: stu.setName(sc.nextLine());; break;
				case 1: stu.setAddress(sc.nextLine()); break;
				case 2: stu.setPhoneNumber(sc.nextLong()); sc.nextLine(); break;
				case 3: stu.setEmail(sc.nextLine()); break;
				case 4: stu.setclassStatus(sc.nextLine()); break;
			}
		}
		Faculty f = new Faculty();
		for(int i = 0; i < 11; i++) {
			switch(i) {
				case 0: field = "Name: "; break;
				case 1: field = "Address: "; break;
				case 2: field = "Phone Number: "; break;
				case 3: field = "Email Address: "; break;
				case 4: field = "Office: "; break;
				case 5: field = "Salary: "; break;
				case 6: field = "Year Hired: "; break;
				case 7: field = "Month Hired: "; break;
				case 8: field = "Day Hired: "; break;
				case 9: field = "Office Hours: "; break;
				case 10: field = "Rank: "; break;
			}
			System.out.print("\nEnter Faculty Member's " + field);
			switch(i) {
				case 0: f.setName(sc.nextLine());; break;
				case 1: f.setAddress(sc.nextLine()); break;
				case 2: f.setPhoneNumber(sc.nextLong()); sc.nextLine(); break;
				case 3: f.setEmail(sc.nextLine()); break;
				case 4: f.setOffice(sc.nextLine()); break;
				case 5: f.setSalary(sc.nextInt()); sc.nextLine(); break;
				case 6: f.setYear(sc.nextShort()); sc.nextLine(); break;
				case 7: f.setMonth(sc.nextShort()); sc.nextLine(); break;
				case 8: f.setDay(sc.nextShort()); sc.nextLine(); break;
				case 9: f.setOfficeHours(sc.nextShort()); sc.nextLine(); break;
				case 10: f.setRank(sc.nextLine()); break;
			}
		}
		Staff s = new Staff();
		for(int i = 0; i < 11; i++) {
			switch(i) {
				case 0: field = "Name: "; break;
				case 1: field = "Address: "; break;
				case 2: field = "Phone Number: "; break;
				case 3: field = "Email Address: "; break;
				case 4: field = "Office: "; break;
				case 5: field = "Salary: "; break;
				case 6: field = "Year Hired: "; break;
				case 7: field = "Month Hired: "; break;
				case 8: field = "Day Hired: "; break;
				case 9: field = "Title: "; break;
			}
			System.out.print("\nEnter Staff Member's " + field);
			switch(i) {
				case 0: s.setName(sc.nextLine());; break;
				case 1: s.setAddress(sc.nextLine()); break;
				case 2: s.setPhoneNumber(sc.nextLong()); sc.nextLine(); break;
				case 3: s.setEmail(sc.nextLine()); break;
				case 4: s.setOffice(sc.nextLine()); break;
				case 5: s.setSalary(sc.nextInt()); sc.nextLine(); break;
				case 6: s.setYear(sc.nextShort()); sc.nextLine(); break;
				case 7: s.setMonth(sc.nextShort()); sc.nextLine(); break;
				case 8: s.setDay(sc.nextShort()); sc.nextLine(); break;
				case 9: s.setTitle(sc.nextLine()); break;
			}
		}
		System.out.println("\n\n" + p);
		System.out.println("\n\n" + e);
		System.out.println("\n\n" + stu);
		System.out.println("\n\n" + f);
		System.out.println("\n\n" + s);
	}
	
}
