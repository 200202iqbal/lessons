import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;

public class javafx01 extends Application
{
	public static void main (String[] args)
	{
		launch(args);
	}

	public void start (Stage stage) throws Exception
	{
		stage.setTitle("Welcome to JavaFX !");
		Label hello = new Label("Hello, JavaFX");
		Label name = new Label("Muhammad Iqbal Tawakal");
		Label classroom = new Label("IG12");

		BorderPane pane = new BorderPane();
		pane.setTop(hello);
		pane.setCenter(name);
		pane.setBottom(classroom);
		pane.setStyle("-fx-background-color: #ccffee;");

		Scene scene = new Scene (pane,300,300);
		stage.setScene(scene);
		stage.show();

	}
}