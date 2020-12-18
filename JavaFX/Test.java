import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Test extends Application 
{
	public static void main(String[]args)
	{
		launch(args);
	}

	@Override
	public void start (Stage stage) throws Exception 
	{
		
		stage.setTitle("Halloo");
		stage.show();
	}
}