import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Test27 extends Application
{
	public static void main (String [] args)
	{
		launch(args);
	}

	@Override
	public void start (Stage stage) throws Exception
	{
		TextField txtField = new TextField();
		Label lHello = new Label("Helloo");
		BorderPane pane = new BorderPane();
		Scene scene = new Scene (pane, 450,450);
		scene.setFill(Color.web("#89a9e0"));
		pane.setTop(lHello);
		pane.setCenter(txtField);
		txtField.setMaxWidth(150);
		stage.setScene(scene);
		stage.setTitle("Welcome");
		stage.sizeToScene();
		stage.show();
	}
}