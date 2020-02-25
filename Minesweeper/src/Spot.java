
public class Spot {
	public int x;
	public int y;
	public String state = "hidden";
	
	public Spot() {}
	
	public Spot(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//change state to flagged if not currently flagged or to hidden if already flagged
	public void flag() {
		if(state == "flagged")
			state = "hidden";
		else
			state = "flagged";
	}
	
}
