import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;

public class Test extends Application
{
    //data
    private BreakoutThread breaktoutthread;

    //method
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Aloha");
        //pane,scene

        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        stage.setScene(scene);

        //canvas
        Canvas canvas = new Canvas(640,480);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        pane.getChildren().add(canvas);

        //breakoutthread(animationtimer)
       BreakoutThread  breakoutthread  = new BreakoutThread(gc);
        breakoutthread.start();
        stage.show();
    }

}

class BreakoutThread extends AnimationTimer
{
    //data
    private GraphicsContext gc;
    private int count;

    //method
    public BreakoutThread (GraphicsContext gc)
    {
        this.gc = gc;
        this.count = 0;
    }

    @Override
    public void handle(long time)
    {
        //clear

        gc.clearRect(0,0,640,480);

        //draw
        gc.setStroke(Color.BLACK);
        gc.fillText("Aloha", 200,200);
        gc.fillText("count: "+this.count,450,450);
        gc.fillText("time: "+time,450,470);
    }
}