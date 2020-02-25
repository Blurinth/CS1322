package application;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class Map {
	
	private final int SIZE;
	private Button[][] buttons;
	private boolean[][] space;
	private int[][][] rooms;
	
	public Map(int size, int roomNum) {
		SIZE = size;
		buttons = new Button[SIZE][SIZE];
		rooms = new int[roomNum][2][2];
		space = new boolean[SIZE][SIZE];

		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++) {
				buttons[i][j] = new Button();
				buttons[i][j].setPrefSize(40, 40);
				buttons[i][j].setStyle(".button:hover -fx-background-color: blue");
			}
		generateRooms();
		createRooms();
	}
	
	public void generateRooms() {
		Random r = new Random();
		for(int i = 0; i < rooms.length; i++) {
			int dx = r.nextInt(3) + 3;
			int dy = r.nextInt(3) + 3;
			if(i > 0) switch(r.nextInt(9)) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
			} else 
			rooms[i][0][0] = r.nextInt(SIZE - (dx + 1)) + 1;
			rooms[i][1][0] = r.nextInt(SIZE - (dy + 1)) + 1;
			rooms[i][0][1] = (rooms[0][0][0] + dx > SIZE ? SIZE - 1 : rooms[0][0][0] + dx);
			rooms[i][1][1] = (rooms[0][1][0] + dy > SIZE ? SIZE - 1 : rooms[0][1][0] + dy);
		}
	}
	
	public void createRooms() {
		for(int i = 0; i < rooms.length; i++) {
			int x1 = rooms[i][0][0];
			int x2 = rooms[i][0][1];
			int y1 = rooms[i][1][0];
			int y2 = rooms[i][1][1];
			for(int a = x1; a < x2; a++)
				for(int b = y1; b < y2; b++) {
					space[a][b] = true;
					buttons[a][b].setStyle("-fx-background-color: green");
				}
		}
	}
	
	public Button getButton(int x, int y) {
		return buttons[x][y];
	}
}
