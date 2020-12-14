import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.Group;


public class JavaFXHBox extends Application
{
	public static void main(String [] args)
	{
		launch(args);
	}
	@Override
	public void start (Stage stage) throws Exception
	{
		Group group = new Group();
		Button btn1 = new Button("Button 1");
		Button btn2 = new Button("Button 2");
		HBox hbox = new HBox();
		Scene scene = new Scene(hbox,300,300);
		
		hbox.getChildren().addAll(btn1,btn2);
		hbox.setSpacing(20);
		stage.setScene(scene);
		stage.setTitle("JavaFXHBox");
		stage.show();
	}
}