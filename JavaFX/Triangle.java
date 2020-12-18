import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Triangle extends Application
{
    public static void main (String[] args)
    {
        launch(args);
    }
    @Override 
    public void start (Stage stage) throws Exception
    {
        View v = new View();
        
        //Group, scene
        //Group root = new Group();
        Scene scene = new Scene(v,500,500, Color.web("#111111"));

        
        
        
        
        stage.setScene(scene);

        stage.setTitle("Triangle");
        stage.show();
    }

    public class View extends Group
    {
        public View()
        {
            //shape, color
             Polygon triangle = new Polygon(100,250,250,50,400,250);
            triangle.setFill(Color.web("#444444"));

            //animation,setCycleCount, setAutoReverse
            TranslateTransition animation = new TranslateTransition(Duration.seconds(2), triangle);
            animation.setCycleCount(Animation.INDEFINITE);
            animation.setAutoReverse(true);
            animation.setFromX(0);
            animation.setFromY(0);
            animation.setToX(500);
            animation.setToY(250);
            animation.play();
            getChildren().add(triangle);
        }
    }
}