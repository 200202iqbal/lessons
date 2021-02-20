//membuat animasi earth dan sun
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.lang.System;
import javafx.animation.AnimationTimer;


public class TimelineEx extends Application
{
  public static void main(String [] args)
  {
    launch(args);
  }

  public void start(Stage  stage)
  {
    stage.setTitle("Timeline Example");
    Group root = new Group();
    Scene scene = new Scene(root);
    stage.setScene(scene);

    Canvas canvas = new Canvas(512,512);
    root.getChildren().add(canvas);

    GraphicsContext gc = canvas.getGraphicsContext2D();
    Image earth = new Image("/earth.png",50,50,true,true);
    Image sun = new Image("/sun.png",100,100,true,true);
    Image space = new Image("/space.jpg",1024,1024,true,true);

    final long startNanoTime = System.nanoTime();

    new AnimationTimer()
    {
      public void handle(long currentNanoTime)
      {
        double t = (currentNanoTime - startNanoTime) / 1000000000.0;

        double x = 232 + 128 * Math.cos(t);
        double y = 232 + 128 * Math.sin(t);
        double x_pos = 0; //position image space
        double x_space = (x_pos + t) * -10; //image space move 
        //background image clars Canvas
        gc.drawImage(space,x_space,0);
        gc.drawImage(earth,x,y);
        gc.drawImage(sun,196,196);
      }
    }.start();
    stage.show();
  }
}
