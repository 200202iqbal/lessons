//latihan untuk menganimasikan image menggunakan Frame Based AnimationTimer
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.lang.System;
import javafx.animation.AnimationTimer;

public class AnimatedImage
{
  public static void main(String [] args)
  {
    launch(args);
  }

  public void start(Stage stage)
  {
    stage.setTitle("Animated Image Example");
    Group root = new Group();
    Scene scene = new Scene(root);
    stage.setScene(scene);

    Canvas canvas = new Canvas(512,512);
    root.getChildren().add(Canvas);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    public Image[] frames;
    public double duration;

    AnimatedImage ufo = new AnimatedImage();
    Image[] imageArray = new Image[4];
    for(int i = 0; i < 4; i++)
    {
      imageArray[i] = new Image("/ship/f" + i + ".png");
    }
    ufo.frames = imageArray;
    ufo.duration = 0.100;

    final long startNanoTime = System.nanoTime();

    new AnimationTimer()
    {
      public void handle(long currentNanoTime)
      {
        double t = (currentNanoTime - startNanoTime) / 1000000000.0;



        //background image clars Canvas
        gc.drawImage(ufo.getFrame(t),450,25);
      }
    }.start();

    public Image getFrame(double time)
    {
      int index = (int)((time % (frames.length * duration)) / duration;
      return frames[index];
    }
    stage.show();
  }
}
