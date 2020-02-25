/* Quinn Olson */

import java.util.Scanner;

public class Lab1bArray {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 25 digits...");
		int[][] data = new int[5][5];
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				System.out.print("Enter number " + i + ", " + j + ": ");
				data[i][j] = sc.nextInt();
			}
		}
		System.out.println("data:\n" + printIntArray(data) 
			+ "\nLongest Positive Series: " + longestPositiveSeries(data));
	}
	
	public static int longestPositiveSeries(int[][] data) {
		int streak = 0;
		int largestStreak = 0;
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				if(data[i][j] > 0) {
					streak++;
					if(streak > largestStreak) largestStreak = streak;
				}
				else streak = 0;
			}
		}
		return largestStreak;
	}
	
	public static String printIntArray(int[][] data) {
		String s = "";
		for(int i = 0; i < data.length; i++) {
			s += "[";
			for(int j = 0; j < data[0].length - 1; j++) {
				s += data[i][j] + ", ";
			}
			s += data[i][data.length - 1] + "]\n";
		}
		return s;
	}
}
