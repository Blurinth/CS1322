
public class Empty extends Spot {
	private Object[][] map;
	private String openedState = ". ";
	private boolean hasMinesInArea;
	
	public Empty(int x, int y, Object[][] map) {
		this.x = x;
		this.y = y;
		this.map = map;
	}
	
	public String toString() {
		switch(state) {
		case "flagged":
			return "F ";
		case "opened":
			return openedState;
		default:
			return ". ";
		}
	}
	
	public String getState() {
		return state;
	}
	
	public boolean hasMines() {
		return hasMinesInArea;
	}
	
	public int getMineCount() {
		int count = 0;
		int xmin = (x < 2 ? 0 : x - 1);
		int xmax = (x > map[0].length - 3 ? map[0].length - 1 : x + 1);
		int ymin = (y < 2 ? 0 : y - 1);
		int ymax = (y > map.length - 3 ? map.length - 1 : y + 1);
		for(int i = ymin; i <= ymax; i++) {
			for(int j = xmin; j <= xmax; j++) {
				if(map[i][j] instanceof Mine) {
					count++;
				}
			}
		}
		return count;
	}
	
	public void changeMap(Object[][] m) {
		map = m;
	}
	
	public void dig() {
		state = "opened";
		int count = getMineCount();
		if(count > 0)
			openedState = Integer.toString(getMineCount()) + " ";
		else if(count == 0)
			openedState = "- ";
	}
	
}
