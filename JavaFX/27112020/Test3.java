import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Test3 extends Application
{
	public static void main (String[] args)
	{
		launch(args);
	}

	public void start (Stage stage)throws Exception
	{
		
		Label labelLeft = new Label("Tanaka Sensei");
		Label labelRight = new Label("Yamamoto Sensei");
		Button button = new Button("Click me !");

		
		button.setOnAction( new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent e)
				{
					String data= labelLeft.getText();
					labelLeft.setText(labelRight.getText());
					labelRight.setText(data);
				}
			});
		
		
		//BorderPane
		BorderPane pane = new BorderPane();
		pane.setLeft(labelLeft);
		pane.setRight(labelRight);
		pane.setBottom(button);
		pane.setStyle("-fx-background-color : #cbbaf5");

		
		//Scene
		Scene scene = new Scene(pane,400,400);
		scene.setFill(Color.web("#8f72d4"));
		stage.setTitle("Welcome JavaFX 1.3");
		stage.setScene(scene);

		stage.show();
	}
}