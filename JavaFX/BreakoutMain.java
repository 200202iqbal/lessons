import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class BreakoutMain extends Application
{
	//data
	private BreakoutThread breakoutthread;

	public static void main (String[] args)
	{
		launch(args);
	}
	@Override
	public void start (Stage stage)
	{
		stage.setTitle("ブロック崩し");

		//pane,scene,setScene()
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		//Canvas, GraphicsContext, add()
		Canvas canvas = new Canvas(640,480);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		pane.getChildren().add(canvas);

		//thread;スレッドっを実行する
		breakoutthread = new BreakoutThread(gc);
		breakoutthread.start();
		stage.show();
	}
}

class BreakoutThread extends AnimationTimer
{
	//data
	private GraphicsContext gc;
	private int ball_x;		//ボールの場所;x
	private int ball_y;		//ボールの場所;y
	private int x_speed;	//ボールの速さ;x方向
	private int y_speed;	//ボールの速さ;y方向

	//method 
	//constructor;コンストラクタ;newの時,１回だけ実行させる
	BreakoutThread(GraphicsContext gc)
	{
		this.gc = gc;
		ball_x  = 0;
		ball_y = 0;
		x_speed = 1;
		y_speed = 1;
	}

	@Override 
	public void handle(long time)
	{
		//画面表示をする、全部消す(全部白になる)
		gc.clearRect(0,0,640,480);
		gc.setFill(Color.BLACK);
		gc.fillOval(ball_x - 5, ball_y - 5, 10 ,10);

		//ボールを移動させる
		ball_x += x_speed;
		ball_y += y_speed;

		/*//文字を表示する
		gc.fillText("count = " + count, 450,450);
		gc.fillText("time = " + time, 450,500);

		//回数をカウントする；表示する回数
		count++; */
	}
}