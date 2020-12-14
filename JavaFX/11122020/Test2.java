import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Test2 extends Application
{
	public static void main (String[] args)
	{
		launch(args);
	}
	@Override
	public void start (Stage primeStage)throws Exception
	{
		Group group = new Group();
		Label label1 = new Label("Hex's Code Color : ");
		Scene scene = new Scene(group, 300,300);
		Rectangle rect1 = new Rectangle(50,100,50,50);
		Rectangle rect2 = new Rectangle(200,100,50,50);
		TextField tf1 = new TextField();
		tf1.setTranslateX(110);
		tf1.setTranslateY(250);
		tf1.setMaxWidth(65);
		Button button1 = new Button("Submit");
		button1.setTranslateX(tf1.getMaxWidth()+130);
		button1.setTranslateY(250);

		label1.setTranslateX(tf1.getTranslateX()-100);
		label1.setTranslateY(tf1.getTranslateY());
		rect1.setFill(Color.web("#ffff00"));
		rect2.setFill(Color.web("#00ffff"));

		group.getChildren().addAll(rect1,rect2,label1,tf1,button1);
		primeStage.setScene(scene);
		primeStage.setTitle("Test");
		primeStage.show();
	}
}