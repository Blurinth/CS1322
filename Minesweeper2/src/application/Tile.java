package application;

import javafx.scene.control.Button;

public class Tile extends Button {
	private int x;
	private int y;
	
	public Tile(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
