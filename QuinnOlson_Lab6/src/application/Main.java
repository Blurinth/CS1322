//Quinn Olson

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		Text answer = new Text("Answer");
		Text plus = new Text(" + ");
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		Button calc = new Button(" = ");
		
		EventHandler<ActionEvent> calcEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
				answer.setText(Integer.toString(Integer.parseInt(t1.getText()) + Integer.parseInt(t2.getText())));
				} catch(Exception x) {
					answer.setText("Invalid Input");
				}
			}
		};
		
		calc.addEventFilter(ActionEvent.ACTION, calcEvent);
		
		grid.add(t1, 0, 0);
		grid.add(plus, 1, 0);
		grid.add(t2, 2, 0);
		grid.add(calc, 0, 1);
		grid.add(answer, 1, 1);
		
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.setVgap(20);
		grid.setHgap(20);
		
		plus.setWrappingWidth(60);
		plus.setTextAlignment(TextAlignment.CENTER);
		
		answer.setWrappingWidth(60);
		answer.setTextAlignment(TextAlignment.CENTER);
		
		t1.setAlignment(Pos.CENTER);
		t1.setMinWidth(50);
		t1.setMaxWidth(50);
		
		t2.setAlignment(Pos.CENTER);
		t2.setMinWidth(50);
		t2.setMaxWidth(50);
		
		Scene scene = new Scene(grid);
		primaryStage.setTitle("Lab 6 - Quinn Olson");
		primaryStage.setScene(scene);;
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
