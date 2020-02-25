package application;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.Optional;
import java.util.Random;

public class Bombs {
	
	private Tile[][] tiles;
	private boolean[][] hasBomb;
	private boolean[][] revealed;
	private boolean[][] flagged;
	private final int SIZE;
	private final int BOMBCOUNT;
	private final int TILESIZE = 40;
	private int totalFlagged = 0;
	private int totalRevealed = 0;
	private String[] bombColors = {"grey", "blue", "green", "red", "orange", "darkviolet", "yellow", "saddlebrown", "violet", "black"};
	private Text display = new Text();
	
	public Bombs(int size, int bombCount) {
		SIZE = size / TILESIZE;
		BOMBCOUNT = bombCount;
		tiles = new Tile[SIZE][SIZE];
		hasBomb = new boolean[SIZE][SIZE];
		revealed = new boolean[SIZE][SIZE];
		flagged = new boolean[SIZE][SIZE];
		
		display.setText("Bombs Remaining: " + bombCount + "\t Revealed Cells: " + totalRevealed + "/" + (SIZE * SIZE));
		display.setFont(Font.font("Verdana", 30));
		
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++) {
				tiles[i][j] = new Tile(i, j);
				tiles[i][j].setPrefSize(TILESIZE, TILESIZE);;
				tiles[i][j].setFont(Font.font("Verdana", 15));
			}
		
		EventHandler<MouseEvent> tileClicked = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				int x = ((Tile) e.getSource()).getX();
				int y = ((Tile) e.getSource()).getY();
				if(e.getButton() == MouseButton.PRIMARY) {
					clickTile(x, y);
				} else if(e.getButton() == MouseButton.SECONDARY) {
					flagTile(x, y);
				}
			}
		};
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++) {
				tiles[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, tileClicked);
				revealed[i][j] = false;
			}
		
		genBombs();
	}
	
	private void loseGame() {
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++) {
				if(flagged[i][j] && !hasBomb[i][j]) tiles[i][j].setStyle("-fx-background-color: red");
			}
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("You have lost! Would you like to play again?");
		
		ButtonType yes = new ButtonType("Yes");
		ButtonType no = new ButtonType("No");
		
		alert.getButtonTypes().setAll(yes, no);
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if (result.get() == yes) reset();
		else System.exit(1);
	}
	
	private boolean checkWin() {
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++) if(!revealed[i][j] && !hasBomb[i][j]) return false;
		return true;
	}
	
	private void winGame() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("You have Won! Would you like to play again?");
		
		ButtonType yes = new ButtonType("Yes");
		ButtonType no = new ButtonType("No");
		
		alert.getButtonTypes().setAll(yes, no);
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if (result.get() == yes) reset();
		else System.exit(1);
	}
	
	public void clickTile(int x, int y) {
		if(flagged[x][y]) return;
		int bombs = surroundingBombs(x, y);
		if(hasBomb[x][y]) {
			tiles[x][y].setText("X");
			tiles[x][y].setStyle("-fx-text-fill: black");
			tiles[x][y].setStyle("-fx-background-color: red");
			loseGame();
		}
		else if(bombs > 0) {
				if(!revealed[x][y]) {
					tiles[x][y].setText(Integer.toString(bombs)); 
					tiles[x][y].setStyle("-fx-text-fill: " + bombColors[bombs]);
					revealed[x][y] = true;
					totalRevealed++;
					if(totalRevealed == SIZE * SIZE - BOMBCOUNT) 
						if(checkWin()) winGame();
				} else if(isFullyFlagged(x, y, bombs)) {
					for(int i = (x == 0 ? 0 : x - 1); i <= (x == SIZE - 1 ? SIZE - 1 : x + 1); i++)
						for(int j = (y == 0 ? 0 : y - 1); j <= (y == SIZE - 1 ? SIZE - 1 : y + 1); j++) {
							if(!revealed[i][j]) clickTile(i, j);
						}
				}
		} else {
			tiles[x][y].setStyle("-fx-text-fill: " + bombColors[bombs]);
			tiles[x][y].setStyle("-fx-background-color: gainsboro");
			revealed[x][y] = true;
			totalRevealed++;
			for(int i = (x == 0 ? 0 : x - 1); i <= (x == SIZE - 1 ? SIZE - 1 : x + 1); i++)
				for(int j = (y == 0 ? 0 : y - 1); j <= (y == SIZE - 1 ? SIZE - 1 : y + 1); j++) {
					if(!revealed[i][j]) clickTile(i, j);
				}
		}
		display.setText("Bombs Remaining: " + (BOMBCOUNT - totalFlagged) + "\t Revealed Cells: " + totalRevealed + "/" + (SIZE * SIZE));
	}
	
	public void flagTile(int x, int y) {
		if(!revealed[x][y] && !flagged[x][y]) {
			tiles[x][y].setText("F");
			tiles[x][y].setStyle("-fx-text-fill: goldenrod");
			flagged[x][y] = true;
			totalFlagged++;
		} else if(flagged[x][y]) {
			tiles[x][y].setText("");
			flagged[x][y] = false;
			totalFlagged--;
		}
		display.setText("Bombs Remaining: " + (BOMBCOUNT - totalFlagged) + "\t Revealed Cells: " + totalRevealed + "/" + (SIZE * SIZE));
	}
	
	private boolean isFullyFlagged(int x, int y, int bombs) {
		int count = 0;
		for(int i = (x == 0 ? 0 : x - 1); i <= (x == SIZE - 1 ? SIZE - 1 : x + 1); i++)
			for(int j = (y == 0 ? 0 : y - 1); j <= (y == SIZE - 1 ? SIZE - 1 : y + 1); j++) {
				if(flagged[i][j]) {
					count++;
				}
			}
		if(count >= bombs) return true;
		return false;
	}
	
	private int surroundingBombs(int x, int y) {
		int count = 0;
		for(int i = (x == 0 ? 0 : x - 1); i <= (x == SIZE - 1 ? SIZE - 1 : x + 1); i++)
			for(int j = (y == 0 ? 0 : y - 1); j <= (y == SIZE - 1 ? SIZE - 1 : y + 1); j++) {
				if(hasBomb[i][j]) {
					count++;
				}
			}
		return count;
	}
	
	private void reset() {
		totalFlagged = 0;
		totalRevealed = 0;
		display.setText("Bombs Remaining: " + (BOMBCOUNT - totalFlagged) + "\t Revealed Cells: " + totalRevealed + "/" + (SIZE * SIZE));
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++) {
				tiles[i][j].setText("");
				hasBomb[i][j] = false;
				revealed[i][j] = false;
				flagged[i][j] = false;
				tiles[i][j].setStyle(null);
			}
		genBombs();
	}
	
	private void genBombs() {
		Random rand = new Random();
		int generated = 0;
		while(generated < BOMBCOUNT) {
			int a = rand.nextInt(SIZE);
			int b = rand.nextInt(SIZE);
			if(!hasBomb[a][b]) { 
				hasBomb[a][b] = true;
				generated++;
			}
		}
	}
	
	public int getSize() {
		return SIZE;
	}
	
	public Button getTile(int x, int y) {
		return tiles[x][y];
	}
	
	public Text getDisplay() {
		return display;
	}
}
