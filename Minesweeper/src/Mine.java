
public class Mine extends Spot {
	private boolean exploded = false;
	
	public Mine(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		switch(state) {
		case "flagged":
			return "F ";
		case "exploded":
			return "X ";
		default:
			return ". ";
		}
	}
	
	public void dig() {
		state = "exploded";
		exploded = true;
	}
	
	public boolean isExploded() {
		return exploded;
	}
	

	public String getState() {
		return state;
	}

}
