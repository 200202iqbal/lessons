import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Test extends Application
{
    public static void main (String[] args)
    {
        launch(args);
    }

    @Override
public void start(Stage stage) throws Exception
{
    View v = new View();
    Scene scene = new Scene( v ,500,400);
    stage.setScene(scene);
    stage.setTitle("ブレックファースト");
    stage.show();
}
}

class View extends Group
{
    public View()
    {
        //shape
        Circle circle = new Circle(50,50,30);
        circle.setFill(Color.BLUE);
        Circle circle_suihei = new Circle(50,50,30);
        circle_suihei.setFill(Color.RED);

        //animation,duration
        TranslateTransition animation = new TranslateTransition(Duration.seconds(2), circle);
        TranslateTransition animation2 = new TranslateTransition(Duration.seconds(2), circle_suihei);
        //animation-from to
        animation.setFromX(200);
        animation.setFromY(300);
        animation.setToX(200);
        animation.setToY(10);

        animation2.setFromX(0);
        animation2.setFromY(200);
        animation2.setToX(400);
        animation2.setToY(200);
        //repeat
        animation.setCycleCount(Animation.INDEFINITE);
        animation2.setCycleCount(Animation.INDEFINITE);

        //play,add
        animation.play();
        animation2.play();
        getChildren().add(circle);
        getChildren().add(circle_suihei);
    }
}