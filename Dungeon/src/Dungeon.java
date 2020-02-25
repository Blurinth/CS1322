
public class Dungeon {
	
	public Object[][] grid;
	public int width;
	public int height;
	
	public Dungeon(int width, int height) {
		this.width = width;
		this.height = height;
		grid = new Object[width][height];
	}
}
