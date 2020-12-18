import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;
import java.lang.String;

public class Scale extends Application
{
    public static void main (String[] args)
    {
        launch(args);
    }

    @Override
    public void start (Stage stage) throws Exception
    {
        View v = new View();
        Scene scene = new Scene (v, 700,700);
        stage.setTitle("Scale JavaFX");
        stage.setScene(scene);
        stage.show();

    }

    public class View extends Group
    {
        //constructor
        public View()
        {
            //shape,setFill
            Rectangle rect = new Rectangle(0 ,0,100,100);
            Random random = new Random();
            int intRandom = random.nextInt(999999);

            rect.setFill(Color.web("#" + String.valueOf(intRandom)));
            //animation
            ScaleTransition animation = new ScaleTransition(Duration.seconds(4), rect);
            TranslateTransition transition = new TranslateTransition(Duration.seconds(4), rect);
            
            //ScaleTransition
            animation.setFromX(0.5);
            animation.setFromY(0.5);
            animation.setToX(2);
            animation.setToY(2);

            //TranscaleTransition
            transition.setFromX(0);
            transition.setFromY(350);
            transition.setToX(700);
            transition.setToY(350);


            //setCycleCount ; repeat
            animation.setCycleCount(Animation.INDEFINITE);
            transition.setCycleCount(Animation.INDEFINITE);
            transition.setAutoReverse(true);
            animation.setAutoReverse(true);
            //play,add
            animation.play();
            transition.play();
            
            
            getChildren().add(rect);
        }
    }
}