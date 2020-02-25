//Quinn Olson

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		AllInclusiveVacation allInc = new AllInclusiveVacation();
		PiecemealVacation piecemeal = new PiecemealVacation();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter All-Inclusive's budget: ");
		allInc.setBudget(sc.nextInt());
		sc.nextLine();
		System.out.print("Enter All-Inclusive's destination: ");
		allInc.setDestination(sc.nextLine());
		System.out.print("Enter All-Inclusive's brand: ");
		allInc.setBrand(sc.nextLine());
		System.out.print("Enter All-Inclusive's rating: ");
		allInc.setRating(sc.nextShort());
		sc.nextLine();
		System.out.print("Enter All-Inclusive's price: ");
		allInc.setPrice(sc.nextInt());
		sc.nextLine();
		
		ArrayList<String> items = new ArrayList<String>();
		ArrayList<Integer> costs = new ArrayList<Integer>();
		
		System.out.print("Enter Piecemeal's budget: ");
		piecemeal.setBudget(sc.nextInt());
		sc.nextLine();
		System.out.print("Enter Piecemeal's destination: ");
		piecemeal.setDestination(sc.nextLine());
		boolean cont = true;
		int itemCount = 0;
		String choice = "y";
		while(choice.toLowerCase().equals("y")) {
			itemCount++;
			System.out.print("Enter piecemeal's item #" + itemCount +": ");
			items.add(sc.nextLine());
			System.out.print("Enter cost for " + items.get(itemCount - 1) + ": ");
			costs.add(sc.nextInt());
			sc.nextLine();;
			System.out.print("Enter more items? (y/n): ");
			choice = sc.nextLine();
		}
		String[] itemArr = new String[items.size()];
		int count = 0;
		for(String s : items) itemArr[count++] = s;
		piecemeal.setItems(itemArr);
		int[] costArr = new int[costs.size()];
		count = 0;
		for(int n : costs) costArr[count++] = n;
		piecemeal.setCosts(costArr);
		System.out.println(allInc + "\n" + piecemeal);
	}
	
}
