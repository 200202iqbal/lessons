import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class  SimpleCalculator extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
	@Override
	public void start (Stage stage)
	{
		GridPane gdPane = new GridPane();
		gdPane.setPadding(new Insets(15));
		gdPane.setHgap(10);
		gdPane.setVgap(10);

		Scene scene = new Scene(gdPane,350,350);
		stage.setScene(scene);
		stage.setTitle("Simple Calculator");
		stage.setResizable(false);
		stage.show();

	}
}