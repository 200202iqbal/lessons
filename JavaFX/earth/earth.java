/*program ini hanya untuk latihan dasar JAVAFX */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;


public class earth extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  public void start(Stage stage)
  {
    stage.setTitle("Canvas Example");
    Group root = new Group();
    Scene scene = new Scene(root);
    stage.setScene(scene);

    Canvas canvas = new Canvas(400,200);
    root.getChildren().add(canvas);

    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setFill(Color.AQUAMARINE);
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(2);
    Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
    gc.setFont(theFont);
    gc.fillText("Hello World !", 60,50);
    gc.strokeText("Hello World !",60,50);

    //contructor (img url,double width, double height, boolean preserveRatio, boolean smooth)
    Image earth = new Image("/earth.png", 100,100,true,true);
    gc.drawImage(earth,150,80); //(Image img, x coordinate, y coordinate )
    stage.show();
  }
}
