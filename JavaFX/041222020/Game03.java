import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Game03 extends Application
{
	public static void main (String[] args)
	{
		launch(args);
	}
	@Override
	public void start (Stage stage) throws Exception
	{
		Group group = new Group();
		Scene scene = new Scene(group, 500, 500 );
		Rectangle rect01 = new Rectangle(125,125,100,100);
		rect01.setFill(Color.web("#e67e22"));//color : yellow
		Rectangle rect02 = new Rectangle(275,125,100,100);
		rect02.setFill(Color.web("#2ecc71"));//color : green
		Rectangle rect03 = new Rectangle(125,275,100,100);
		rect03.setFill(Color.web("#3498db"));//color : yellow
		Rectangle rect04 = new Rectangle(275,275,100,100);
		rect04.setFill(Color.web("#f1c40f"));//color : green
		group.getChildren().add(rect01);
		group.getChildren().add(rect02);
		group.getChildren().add(rect03);
		group.getChildren().add(rect04);

		Button btn01 = new Button ("Click me !");
		btn01.setTranslateX(220);
		btn01.setTranslateY(450);;
		group.getChildren().add(btn01);

		btn01.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				rect01.setFill(Color.web("#8e44ad"));
				rect02.setFill(Color.web("#f39c12"));
				rect03.setFill(Color.web("#c0392b"));
				rect04.setFill(Color.web("#2980b9"));
			}

		});



		stage.setScene(scene);
		stage.setTitle("Game 2");
		stage.show();
	}
}