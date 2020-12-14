import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.CheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TestCheckBox extends Application
{
	public static void main (String[] args)
	{
		launch (args);
	}

	@Override
	public void start (Stage stage) throws Exception
	{
		CheckBox check = new CheckBox("チェックボックス");
		check.setOnAction (new EventHandler<ActionEvent>()
		{
			@Override 
			public void handle(ActionEvent e)
			{
				boolean checkIsSelected = check.isSelected();
				if(checkIsSelected) System.out.println("選択");
				else System.out.println("選択されていない");
				//System.out.println("Aloha");
			}
		});

		BorderPane pane = new BorderPane();
		pane.setCenter(check);
		Scene scene = new Scene(pane,300,300);
		stage.setTitle("Test CheckBox");
		stage.setScene(scene);
		stage.show();
	}
}