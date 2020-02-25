package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	private final int SIZE = 20;
	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid);
		Map m = new Map(SIZE, 1);
		for(int i = 0; i < SIZE; i++)
			for( int j = 0; j < SIZE; j++) {
				grid.add(m.getButton(i,  j), i, j);
			};
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
