//Quinn Olson

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string: ");
		String s = sc.nextLine();
		System.out.println("Vowels in \"" + s + "\": " + vowelCount(s));
	}
	
	public static int vowelCount(String s) {
		int count = 0;
		switch(Character.toLowerCase(s.charAt(0))) {
			case 'a': 
			case 'e':
			case 'i':
			case 'o':
			case 'u': count++;
		}
		if(s.length() > 1) return count + vowelCount(s.substring(1));
		else return count;
	}
}
