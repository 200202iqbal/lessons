import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.CheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TestCheckBox2 extends Application
{
	public static void main (String[] args)
	{
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception
	{
		BorderPane pane = new BorderPane();
		CheckBox check = new CheckBox("Select");
		check.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle (ActionEvent e)
			{
				System.out.println(check.isSelected());
			}
		});


		Scene scene = new Scene(pane,300,300);
		pane.setCenter(check);
		stage.setScene(scene);
		stage.setTitle("Test CheckBox 2");
		stage.show();
	}
}