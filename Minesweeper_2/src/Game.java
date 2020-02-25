
import java.util.Scanner;

public class Game {
	
	public static int[][] mines;
	public static int[][] opened;
	public static int[][] flagged;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	public static final int bombCount = 15;
	
	public static void main(String[] args) {
		
		mines = new int[WIDTH][HEIGHT];
		opened = new int[WIDTH][HEIGHT];
		flagged = new int[WIDTH][HEIGHT];
		generateBombs(0);
		draw();
		
	}
	
	public static void draw() {
		
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				System.out.print(
						(opened[i][j] == 1 ? 
								(mines[i][j] == 1 ? "[X]" : ("[" + getAdjacentMines(i, j) + "]")) : 
								flagged[i][j] == 1 ? "[F]" : "[ ]") + "  ");
			}
			System.out.println("\n");
		}
		
	}
	
	public static void generateBombs(int count) {
		
		int area = WIDTH * HEIGHT;
		if(count == 0) {
			for(int i = 0; i < HEIGHT; i++) {
				if(count == bombCount)
					break;
				for(int j = 0; j < WIDTH; j++) {
					if(count == bombCount)
						break;
					if((Math.random() * area) > bombCount && count < bombCount) {
						mines[i][j] = 1;
						count++;
					}
				}
			}
		} else {
			for(int i = (int) (Math.random() * HEIGHT); i < HEIGHT; i++) {
				if(count == bombCount)
					break;
				for(int j = (int) (Math.random() * WIDTH); j < WIDTH; j++) {
					if(count == bombCount)
						break;
					if((Math.random() * area) > bombCount && count < bombCount) {
						mines[i][j] = 1;
						count++;
					}
					
				}
			}
		}
		if(count < bombCount)
			generateBombs(count);
	}
	
	public static int getAdjacentMines(int width, int height) {
		
		int count = 0;
		for(int i = (height))
		return count;
		
	}
	
}
