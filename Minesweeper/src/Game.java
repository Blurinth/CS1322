
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean play = true;
		int width = 0;
		int height = 0;
		int bombcount = 0;
		
		System.out.println("Quinn's Minesweeper\n-------------------\nChoose Difficulty: \n1) Easy (8 x 8, 12 bombs)\n2) Medium (16 x 16, 50 bombs)\n3) Hard (24 x 24, 100 bombs)\n4) Custom");
		
		while(true) {
			System.out.print("\nCommand: ");
			String choice = sc.nextLine();
			if(choice.equals("1")) {
				width = 8;
				height = 8;
				bombcount = 12;
				break;
			} else if(choice.equals("2")) {
				width = 16;
				height = 16;
				bombcount = 50;
				break;
			} else if(choice.equals("3")) {
				width = 24;
				height = 24;
				bombcount = 100;
				break;
			} else if(choice.equals("4")) {
				System.out.println("Larger values take significantly longer to load. Max recommended size: 150 x 150.");
				System.out.print("width (max 999): ");
				width = sc.nextInt();
				System.out.print("height (max 999): ");
				height = sc.nextInt();
				System.out.print("bomb count: ");
				bombcount = sc.nextInt();
				break;
			} else {
				System.out.println("Invlaid command...");
			}
		}
		Grid g = new Grid(width, height, bombcount);
		g.draw();
		
		main: while(play) {
			g.getPlayerInput();
			play = g.getRun();
			if(!play)
				break;
			g.draw();
			if(!g.getAlive()) {
				g.showMines();
				g.draw();
				System.out.println("BOOM\nWould you like to play again? (y/n)\nCommand: ");
				while(true) { 
					String choice = sc.nextLine();
					if(choice.equals("n"))
						break main;
					else if(choice.equals("y")) {
						g = new Grid(width, height, bombcount);
						g.draw();
						break;
					} else 
						System.out.println("Invalid command...\nCommand: ");
				}
			}
			if(g.hasWon()) {
				sc = new Scanner(System.in);
				System.out.println("You Won!\nWould you like to play again? (y/n)\nCommand: ");
				while(true) {
					String choice = sc.nextLine();
					if(choice.equals("n"))
						break main;
					else if(choice.equals("y")) {
						g = new Grid(width, height, bombcount);
						g.draw();
						break;
					} else 
						System.out.println("Invalid command...\nCommand: ");
				}
			}
		}
	}
}
