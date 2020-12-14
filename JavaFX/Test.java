import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;


public class Test extends Application
{
	public static void main (String[] args)
	{
		launch(args);
	}

	@Override 
	public void start (Stage stage)
	{
		stage.setTitle("Test");
		TextField field = new TextField();
		BorderPane pane = new BorderPane();
		pane.setCenter(field);
		pane.setStyle("-fx-background-color :#e6ffcc");
		Scene scene = new Scene(pane, 200,200);
		stage.setScene(scene);
		stage.show();
	}
}
