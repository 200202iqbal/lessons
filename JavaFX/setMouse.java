import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;


public class setMouse extends Application
{
    public static void main (String[] args) 
    {
        launch(args);
    }
    @Override
    public void start (Stage stage ) throws Exception
    {
        View v = new View();
        Scene scene = new Scene(v,500,500 );

        //Mouse Control
        scene.setOnMousePressed(e -> v.changeColor());
        scene.setOnMouseClicked(e -> v.changeAnimation());
        stage.setScene(scene);
        stage.setTitle("Hello");
        stage.show();
    }

    class View extends Group
    {
        Rectangle rect;
        int flagColor = 0;
        int flagAnimation = 0;
        ScaleTransition animation;
        public View()
        {

            rect = new Rectangle(100,100,100,100);
            rect.setFill(Color.web("#232356"));

            animation =  new ScaleTransition(Duration.seconds(2),rect);
            animation.setFromX(0);
            animation.setFromY(0);
            animation.setToX(2);
            animation.setToY(2);

            animation.setCycleCount(Animation.INDEFINITE);
            animation.setAutoReverse(true);
            animation.play();
            getChildren().add(rect);


        }
        public void changeColor()
        {
            
            if ( flagColor == 0 ){
            rect.setFill(Color.web("#111111"));
            flagColor = 1;
        }
            else
            {
                rect.setFill(Color.web("#232356"));
                flagColor = 0;
            }
        }
        public void changeAnimation()
        {
            if ( flagAnimation == 0 )
            {
                animation.pause();
                flagAnimation = 1;
            }
            else
            {
                animation.play();
                flagAnimation = 0;
            }
        }
    }
}