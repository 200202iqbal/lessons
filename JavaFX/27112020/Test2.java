import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Test2 extends Application
{
	public static void main (String[] args)
	{
		launch(args);
	}
	public void start(Stage stage) throws Exception
	{
		//inisialisasi control
		Label hello = new Label("Hello");
		TextField field = new TextField();
		field.setMaxWidth(200);
		
		//button
		Button button = new Button("OK");
		button.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle (ActionEvent e)
			{
				//String buttonClick = "クリックしました。";
				String data = field.getText();
				System.out.println(data);
				hello.setText(data);
			}
		});


		BorderPane pane = new BorderPane();
		pane.setTop(hello);
		pane.setCenter(field);
		pane.setBottom(button);
		BorderPane.setAlignment(hello, new Insets(12,12,12,12));

		//


		//Scene
		Scene scene = new Scene (pane, 450,450);
		scene.setFill(Color.web("#9fd4c5"));
		//Stage
		stage.setScene(scene);
		stage.setTitle("Welcome");


		stage.show();
	}
}