
import java.util.Scanner;

public class Grid {
	private int width = 10;
	private int height = 10;
	private int bombcount = 15;
	private int flaggedSpots = 0;
	private Object[][] map;
	public boolean run = true;
	
	public Grid() {
		this(10, 10, 25);
	}
	
	public Grid(int width, int height, int bombcount) {
		this.width = width;
		this.height = height;
		this.bombcount = bombcount;
		
		map = new Object[height][width];
		//generate grid, evenly distributing bombs across it
		int count = 0;
		int area = width * height;
		while(count < bombcount) {
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					if((int) (Math.random() * area) > (bombcount) && map[i][j] == null) {
						map[i][j] = new Empty(j, i, new Object[height][width]);
					} else if(count < bombcount) {
						map[i][j] = new Mine(j, i);
						count++;
					} else if(map[i][j] == null){
						map[i][j] = new Empty(j, i, new Object[height][width]);
					}
				}
			}
		}
		//initialize empty spaces
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++) {
				if(map[i][j] instanceof Empty)
					((Empty) map[i][j]).changeMap(map);
			}
	}
	
	//check if the board is won
	//all bombs must be flagged and all empty tiles opened.
	public boolean hasWon() {
		int count = bombcount;
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(map[i][j] instanceof Mine) {
					if(((Mine) map[i][j]).state != "flagged")
						return false;
					if(((Mine) map[i][j]).state == "flagged")
						count--;
				}
			}
		}
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(map[i][j] instanceof Empty) {
					if(((Empty)map[i][j]).state.equals("hidden"))
						return false;
				}
			}
		}	
		
		if(count == 0)
			return true;
		return false;
	}
	
	//draw the board
	public void draw() {
		for(int i = 0; i < height; i++)
			System.out.println("\n\n");
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++)
				System.out.print(map[i][j] + "  ");
			System.out.print("|" + i +"\n\n");
		}
		for(int i = 0; i < width; i++)
			System.out.print("__  ");
		System.out.println();
		for(int i = 0; i < width; i++) {
			if(i - 9 <= 0) {
				System.out.print(i + "   ");
			} else if(i - 99 <= 0) {
				System.out.print(i + "  ");
			} else {
				System.out.print(i + " ");
			}
		}
		System.out.println("\nBombs left: " + (bombcount - flaggedSpots));
	}
	
	//get player commands
	public void getPlayerInput() {
		Scanner sc = new Scanner(System.in);
		int[] coords = new int[2];
		while(true) {
			System.out.print("Enter game command, for controls, type \"c\", to quit, type \"q\"\nCommand: ");
			String command = sc.nextLine();
			if(command.equals("c")) {
				System.out.println("To dig up a tile, enter \"x y\", to flag a tile, enter \"f x y\",\nif you dig an already dug tile, all non-flagged tiles around it will be dug\n\n");
				continue;
			} else if(command.equals("q")) {
				run = false;
				break;
			} else {
				if(isFlag(command) && isValid(command)) {
					coords = parseCommand(command);
					System.out.println("FLAG " + coords[0] + ", " + coords[1]);
					flag(coords[0], coords[1]);
					break;
				} else if(isValid(command)) {
					coords = parseCommand(command);
					System.out.println("DIG " + coords[0] + ", " + coords[1]);
					dig(coords[0], coords[1]);
					break;
				}
			}
			System.out.println("Invalid command...");
		}
	}
	
	//turn input into usable data
	public int[] parseCommand(String s) {
		int[] result = new int[2];
		char spot = '-';
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			if(a == 'f')
				continue;
			if(a >= 48 && a <= 57 && i == s.length() - 1) {
				count *= 10;
				count += (a - 48);
				result[1] = (count > height - 1 ? height - 1 : count);
			}
			if(a >= 48 && a <= 57) {
				if(spot == '-') {
					spot = 'x';
					if(count == 0)
						count += (a - 48);
					else {
						count *= 10;
						count += (a - 48);
					}
				} else if(spot == 'x') {
					count *= 10;
					count += (a - 48);
				} else if(spot == 'y') {
					if(count == 0)
						count += (a - 48);
					else {
						count *= 10;
						count += (a - 48);
					}
				}
			}
			if(a == ' ' && spot == 'x') {
				result[0] = (count > width - 1 ? width - 1 : count);;
				count = 0;
				spot = 'y';
			}
			if(a == ' ')
				continue;
		}
		
		return result;
	}
	
	//check if any bombs are exploded
	public boolean getAlive() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(map[i][j] instanceof Mine) {
					if(((Mine) map[i][j]).isExploded()) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void showMines() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(map[i][j] instanceof Mine) {
					((Mine)map[i][j]).dig();
				}
			}
		}
	}
	
	//check if a command is valid
	public boolean isValid(String s) {
		char a;
		for(int i = 0; i < s.length(); i++) {
			a = s.charAt(i);
			if(a == 'f' || (a >= 48 && a <= 57) || a == ' ') {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	//check if a command is a flag command
	public boolean isFlag(String s) {
		if(s.length() == 0)
			return false;
		if(s.charAt(0) == 'f')
			return true;
		return false;
	}
	
	//put down / take up a flag on x, y
	public void flag(int x, int y) {
		if(map[y][x] instanceof Empty) {
			if(((Empty) map[y][x]).state != "flagged" && ((Empty) map[y][x]).state != "opened") {
				((Empty) map[y][x]).flag();
				flaggedSpots++;
			} else if(((Empty) map[y][x]).state != "opened"){
				((Empty) map[y][x]).flag();
				flaggedSpots--;
			} else if(((Empty) map[y][x]).state.equals("opened")) {
				System.out.println("You cannot do that.");
			}
		} else {
			if(((Mine) map[y][x]).state != "flagged") {
				((Mine) map[y][x]).flag();
				flaggedSpots++;
			} else {
				((Mine) map[y][x]).flag();
				flaggedSpots--;
			}
		}
	}
	
	//dig on x, y. if dug area has no bombs around it, area around tile is revealed, if digging on an already dug tile, digs all the non flagged tiles around it.
	public void dig(int x, int y) {
		//if the tile on is empty and has hidden state
		if(map[y][x] instanceof Empty && ((Empty)map[y][x]).getState() == "hidden") {
			((Empty) map[y][x]).dig();
			if(((Empty) map[y][x]).getMineCount() == 0) {
				//determine if coordinates around map[y][x] are reachable. If not, limit the search to within map's boundaries
				int xmin = (x < 2 ? 0 : x - 1);
				int xmax = (x > map[0].length - 3 ? map[0].length - 1 : x + 1);
				int ymin = (y < 2 ? 0 : y - 1);
				int ymax = (y > map.length - 3 ? map.length - 1 : y + 1);
				for(int i = ymin; i <= ymax; i++) {
					for(int j = xmin; j <= xmax; j++) {
						if(!(j == x && i == y))
							if(((Empty) map[i][j]).getState() != "opened")
								dig(j, i);
					}
				}
			}
		// if tile is empty and has opened state, open all non flagged tiles around it
		} else if(map[y][x] instanceof Empty && ((Empty)map[y][x]).getState() == "opened") {
			int xmin = (x < 2 ? 0 : x - 1);
			int xmax = (x > map[0].length - 3 ? map[0].length - 1 : x + 1);
			int ymin = (y < 2 ? 0 : y - 1);
			int ymax = (y > map.length - 3 ? map.length - 1 : y + 1);
			for(int i = ymin; i <= ymax; i++) {
				for(int j = xmin; j <= xmax; j++) {
					if(!(j == x && i == y)) {
						if(map[i][j] instanceof Empty) {
							if(((Empty) map[i][j]).getState() != "opened") {
								dig(j, i);
							}
						} else if(map[i][j] instanceof Mine && ((Mine)map[i][j]).getState() == "hidden") {
							dig(j, i);
						}
					}
				}
			}
		//if the tile is a mine you blow up
		} else {
			((Mine) map[y][x]).dig();
		}
		
	}
	
	//return whether the game is to be continued
	public boolean getRun() {
		return run;
	}
	
	//get actual amount of bombs on the board (debugging)
	public int checkMineCount() {
		int count = 0;
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(map[i][j] instanceof Mine)
					count++;
			}
		}
		return count;
	}
}