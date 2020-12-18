import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.shape.Circle;

import javafx.stage.StageStyle;

public class Moving extends Application 
{
    public static void  main(String [] args)
    {
        launch(args);
    }

    @Override 
    public void start (Stage stage) throws Exception
    {
        View v = new View();
        Scene scene = new Scene(v, 400,300);
        scene.setFill(Color.web("#111111"));
        stage.setScene(scene);
        stage.setTitle("Hallo");
        
        stage.show();
    }

    class View extends Group
    {
        //コンストラクタ
        public View()
        {
            //形をつくる,色をつける
            Rectangle rect = new Rectangle(0,0,50,50);
            Circle circ = new Circle(200,150,10);
            rect.setFill(Color.web("#ffaa00"));
            circ.setFill(Color.web("#ffbb00"));
            //アニメーションをつくる；時間どれを動かすか
            TranslateTransition animation = new TranslateTransition(Duration.seconds(2),rect);
            //アニメーションについて；最初の状態
            animation.setFromX(-50);
            animation.setFromY(50);

            //アニメーションについて:最後の状態
            animation.setToX(400);
            animation.setToY(150);

            //アニメーションについて；繰り返し
            animation.setCycleCount(Animation.INDEFINITE);

            //play, add
            
            animation.play();
            getChildren().addAll(rect,circ);
        
        }    
    }
}