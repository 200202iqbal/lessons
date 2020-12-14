/*membuat dua objek animasi*/
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Test extends Application
{
	public static void main (String[] args)
	{
		launch(args);
	}

	@Override
	public void start (Stage primaryStage)
	{
		View v = new View();
		Scene scene = new Scene (v,500,500);
		primaryStage.setScene(scene);
		scene.setFill(Color.web("#ecf0f1"));
		primaryStage.setTitle("Animation Test");
		primaryStage.show();
	}
}
class View extends Group
	{
		public View()
		{
			Rectangle rect1 = new Rectangle(0,0,50,50);
			Rectangle rect2 = new Rectangle(0,0,50,50);
			rect1.setFill(Color.web("#2ecc71"));
			rect2.setFill(Color.web("#f1c40f"));
			TranslateTransition animation = new TranslateTransition(Duration.seconds(1),rect1);
			TranslateTransition animation2 = new TranslateTransition(
				Duration.seconds(1),rect2);
			
			animation.setFromX(0);
			animation.setFromY(200);
			animation.setToX(500);
			animation.setToY(200);
			animation.setCycleCount(Animation.INDEFINITE);

			animation2.setFromX(500);
			animation2.setFromY(200);
			animation2.setToX(0);
			animation2.setToY(200);
			animation2.setCycleCount(Animation.INDEFINITE);

			animation2.play();
			animation.play();
			getChildren().addAll(rect1,rect2);
		}
	}