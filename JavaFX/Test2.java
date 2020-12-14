import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Window;

public class Test2 extends Application 
{
	public static void main (String[] args)
	{
		launch(args);
	}

	@Override
	public void start (Stage stage)
	{
		stage.setTitle("Test2 - JavaFX");
		Label label = new Label("Hello");
		TextField field = new TextField();
		Button button = new Button("Click Me !");
		

		button.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				String msg = field.getText();
				label.setText(msg);

			}
		});

		BorderPane pane = new BorderPane();
		pane.setTop(label);

		//field.setPrefWidth(80);
		field.setMaxWidth(100);
		pane.setCenter(field);
		pane.setBottom(button);

		pane.setStyle("-fx-background-color :#e6ffcc ");

		Scene scene = new Scene(pane,200,120);
		stage.setScene(scene);

		stage.show();
	}
}