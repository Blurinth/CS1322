//Quinn Olson

package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class Main extends Application{
	private Text display = new Text();
	private Text display2 = new Text();
	@Override
	public void start(Stage primaryStage) {
			//create objects
			GridPane grid = new GridPane();
			Scene scene = new Scene(grid);
			Button bClear = new Button("C");
			Button bPlus = new Button("+");
			Button bMinus = new Button("-");
			Button bDivide = new Button("/");
			Button bMultiply = new Button("*");
			Button bCalc = new Button("=");
			Button bDecimal = new Button(".");
			Button b1 = new Button("1");
			Button b2 = new Button("2");
			Button b3 = new Button("3");
			Button b4 = new Button("4");
			Button b5 = new Button("5");
			Button b6 = new Button("6");
			Button b7 = new Button("7");
			Button b8 = new Button("8");
			Button b9 = new Button("9");
			Button b0 = new Button("0");
			//create event handlers
			EventHandler<ActionEvent> b1Event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + 1);
				}
			};
			EventHandler<ActionEvent> b2Event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + 2);
				}
			};
			EventHandler<ActionEvent> b3Event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + 3);
				}
			};
			EventHandler<ActionEvent> b4Event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + 4);
				}
			};
			EventHandler<ActionEvent> b5Event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + 5);
				}
			};
			EventHandler<ActionEvent> b6Event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + 6);
				}
			};
			EventHandler<ActionEvent> b7Event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + 7);
				}
			};
			EventHandler<ActionEvent> b8Event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + 8);
				}
			};
			EventHandler<ActionEvent> b9Event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + 9);
				}
			};
			EventHandler<ActionEvent> b0Event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + 0);
				}
			};
			EventHandler<ActionEvent> bDecimalEvent = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + ".");
				}
			};
			EventHandler<ActionEvent> bPlusEvent = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + " + ");
				}
			};
			EventHandler<ActionEvent> bMinusEvent = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + " - ");
				}
			};
			EventHandler<ActionEvent> bDivideEvent = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + " / ");
				}
			};
			EventHandler<ActionEvent> bMultiplyEvent = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText(display.getText() + " * ");
				}
			};
			EventHandler<ActionEvent> bClearEvent = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					display.setText("");
					display2.setText("");
				}
			};
			EventHandler<ActionEvent> bCalcEvent = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					try {
						display2.setText(display.getText() + " = ");
						display.setText(Double.toString(calculate(display.getText().replaceAll("\\s+", ""), 1)));
					} catch(Exception a) {
						display.setText("Invalid Input");
						display2.setText("");
					}
				}
			};
			//Attach event handlers to grid elements
			b1.addEventFilter(ActionEvent.ACTION, b1Event);
			b2.addEventFilter(ActionEvent.ACTION, b2Event);
			b3.addEventFilter(ActionEvent.ACTION, b3Event);
			b4.addEventFilter(ActionEvent.ACTION, b4Event);
			b5.addEventFilter(ActionEvent.ACTION, b5Event);
			b6.addEventFilter(ActionEvent.ACTION, b6Event);
			b7.addEventFilter(ActionEvent.ACTION, b7Event);
			b8.addEventFilter(ActionEvent.ACTION, b8Event);
			b9.addEventFilter(ActionEvent.ACTION, b9Event);
			b0.addEventFilter(ActionEvent.ACTION, b0Event);
			bDecimal.addEventFilter(ActionEvent.ACTION, bDecimalEvent);
			bPlus.addEventFilter(ActionEvent.ACTION, bPlusEvent);
			bMinus.addEventFilter(ActionEvent.ACTION, bMinusEvent);
			bDivide.addEventFilter(ActionEvent.ACTION, bDivideEvent);
			bMultiply.addEventFilter(ActionEvent.ACTION, bMultiplyEvent);
			bClear.addEventFilter(ActionEvent.ACTION, bClearEvent);
			bCalc.addEventFilter(ActionEvent.ACTION, bCalcEvent);
			//add grid elements
			grid.add(display2, 0, 0, 5, 1);
			grid.add(display, 0, 1, 5, 1);
			grid.add(b1, 0, 2);
			grid.add(b2, 1, 2);
			grid.add(b3, 2, 2);
			grid.add(bPlus, 3, 2);
			grid.add(bCalc, 4, 2, 1, 4);
			grid.add(b4, 0, 3);
			grid.add(b5, 1, 3);
			grid.add(b6, 2, 3);
			grid.add(bMinus, 3, 3);
			grid.add(b7, 0, 4);
			grid.add(b8, 1, 4);
			grid.add(b9, 2, 4);
			grid.add(bDivide, 3, 4);
			grid.add(bClear, 0, 5);
			grid.add(b0, 1, 5);
			grid.add(bDecimal, 2, 5);
			grid.add(bMultiply, 3, 5);
			//format grid
			grid.setPadding(new Insets(10, 10, 10, 10));
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setGridLinesVisible(false);
			//format grid elements
			display.setFont(Font.font("Verdana", 30));
			display2.setFont(Font.font("Verdana", 20));
			display.prefHeight(60);
			b1.setPrefSize(100, 100);
			b1.setFont(Font.font("Verdana", 40));
			b2.setPrefSize(100, 100);
			b2.setFont(Font.font("Verdana", 40));
			b3.setPrefSize(100, 100);
			b3.setFont(Font.font("Verdana", 40));
			b4.setPrefSize(100, 100);
			b4.setFont(Font.font("Verdana", 40));
			b5.setPrefSize(100, 100);
			b5.setFont(Font.font("Verdana", 40));
			b6.setPrefSize(100, 100);
			b6.setFont(Font.font("Verdana", 40));
			b7.setPrefSize(100, 100);
			b7.setFont(Font.font("Verdana", 40));
			b8.setPrefSize(100, 100);
			b8.setFont(Font.font("Verdana", 40));
			b9.setPrefSize(100, 100);
			b9.setFont(Font.font("Verdana", 40));
			b0.setPrefSize(100, 100);
			b0.setFont(Font.font("Verdana", 40));
			bClear.setPrefSize(100, 100);
			bClear.setFont(Font.font("Verdana", 40));
			bPlus.setPrefSize(100, 100);
			bPlus.setFont(Font.font("Verdana", 40));
			bMinus.setPrefSize(100, 100);
			bMinus.setFont(Font.font("Verdana", 40));
			bDivide.setPrefSize(100, 100);
			bDivide.setFont(Font.font("Verdana", 40));
			bMultiply.setPrefSize(100, 100);
			bMultiply.setFont(Font.font("Verdana", 40));
			bCalc.setPrefSize(100, 430);
			bCalc.setFont(Font.font("Verdana", 40));
			bDecimal.setPrefSize(100, 100);
			bDecimal.setFont(Font.font("Verdana", 40));

			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public double calculate(String s, int a) {
		for(int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
			case '+': return calculate(s.substring(0, i), 1) + calculate(s.substring(i + 1), 1) * a;
			case '-': return calculate(s.substring(0, i), 1) - calculate(s.substring(i + 1), -1) * a;
			}
		}
		for(int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
			case '*': return calculate(s.substring(0, i), 1) * calculate(s.substring(i + 1), 1);
			case '/': return calculate(s.substring(0, i), 1) / calculate(s.substring(i + 1), 1);
			}
		}
		return Double.parseDouble(s);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
