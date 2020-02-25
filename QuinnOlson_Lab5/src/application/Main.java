//Quinn Olson
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3");
		Button button4 = new Button("Button 4");
		Button button5 = new Button("Button 5");
		Text text1 = new Text("Hello");
		GridPane grid = new GridPane();
		
		
		EventHandler<MouseEvent> eventHandlerB1 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				text1.setText(button1.getText());
			}
		};
		
		EventHandler<MouseEvent> eventHandlerB2 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				text1.setText(button2.getText());
			}
		};
		
		EventHandler<MouseEvent> eventHandlerB3 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				text1.setText(button3.getText());
			}
		};
		
		EventHandler<MouseEvent> eventHandlerB4 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				text1.setText(button4.getText());
			}
		};
		
		EventHandler<MouseEvent> eventHandlerB5 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				text1.setText(button5.getText());
			}
		};

		button1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerB1);
		button2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerB2);
		button3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerB3);
		button4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerB4);
		button5.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerB5);
		
		grid.add(button1, 0, 0);
		grid.add(button2, 0, 1);
		grid.add(button3, 0, 2);
		grid.add(button4, 0, 3);
		grid.add(button5, 0, 4);
		grid.add(text1, 0, 5);
		
		Scene scene = new Scene(grid);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
