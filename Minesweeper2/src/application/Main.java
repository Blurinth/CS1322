package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	
	private final int SIZE = 800;
	private final int BOMBCOUNT = 40;
	
	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid);
		Bombs bombs = new Bombs(SIZE, BOMBCOUNT);
		
		for(int i = 0; i < bombs.getSize(); i++)
			for(int j = 0; j < bombs.getSize() ; j++) {
				grid.add(bombs.getTile(i, j), i, j + 1);
			}
		grid.add(bombs.getDisplay(), 0, 0, bombs.getSize(), 1);
		
		grid.setPrefSize(SIZE, SIZE);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

