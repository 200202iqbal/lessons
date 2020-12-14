import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class TestButton extends Application
{

	public static void main (String[] args)
	{
		launch(args);

	}
	@Override
	public void start(Stage stage) throws Exception
	{
		//Button -> Pane ->Scene -> Stage
		Button btn = new Button("click me!");
		btn.setOnAction (new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				System.out.println("Halllllooooooo");
			}
			
		});
		BorderPane pane = new BorderPane();
		pane.setCenter(btn);

		Scene scene = new Scene(pane, 300,300);

		stage.setScene(scene);
		stage.setTitle("Selamat pagi");
		stage.show();
	}
}