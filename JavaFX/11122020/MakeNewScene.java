import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MakeNewScene extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
	@Override
	public void start (Stage stage) throws Exception
	{
		stage.setTitle("Hello");
		
		stage.show();
	}
}