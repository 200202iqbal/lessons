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
    stage.show();
  }
}
