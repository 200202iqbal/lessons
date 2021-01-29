import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

public class BreakoutMain extends Application
{
	//data
	private BreakoutThread breakoutthread;

	//method
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		//title
		stage.setTitle("Breakout");

		//pane,scene
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		//canvas
		Canvas canvas = new Canvas (640,480);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		pane.getChildren().add(canvas);

		//animationtimer(breakoutthread)
		breakoutthread = new BreakoutThread(gc);
		breakoutthread.start();

		//show
		stage.show();
	}
}

class BreakoutThread extends AnimationTimer
{
	//data
	private GraphicsContext gc;
	private Ball ball;
	private Bar bar;
	private Key key;

	//method 
	public BreakoutThread (GraphicsContext gc)
	{
		this.gc = gc;
		ball = new Ball();
		this.bar = new Bar();
		this.key = new Key();
	}

	@Override
	public void handle(long time)
	{
		//clear
		gc.clearRect(0,0,640,480);

		//draw; ball を表示;radius,x,y
		ball.draw(gc);
		ball.move();

		bar.draw(gc);
	}
}

class Ball
{
	//data
	private int x;
	private int y;
	private int x_speed;
	private int y_speed;
	private int size;

	//method
	public Ball()
	{
		this.x = 0;
		this.y = 0;
		this.x_speed = 3;
		this.y_speed = 3;
		this.size = 20;
	}
	//ballを表示する
	public void draw ( GraphicsContext gc) 
	{
		gc.setFill(Color.BLACK);
		gc.fillOval(x,y,size,size);
	}
	//ballを移動させる
	public void move ()
	{
		x += x_speed;
		y += y_speed;
		if (x > (640 -size))
		{
			x_speed *= -1;
		}
		if (y > (480-size))
		{
			y_speed *= -1;
		}
		if(x < 0)
		{
			x_speed *= -1;
		}
		if(y < 0)
		{
			y_speed *= -1;
		}
	}
}

class Bar
{
	//data
	private int x;
	private int y;
	private int w;
	private int h;
	private int x_speed;
	private int y_speed;

	//method
	public Bar()
	{
		this.x = 50;
		this.y = 450;
		this.w = 100;
		this.h = 20;
	}

	public void draw(GraphicsContext gc)
	{
		gc.setFill(Color.BLUE);
		gc.fillRect(x,y,w,h);

	}
}

class Key
{
	//data
	private boolean right;

	//method
	public Key()
	{
		this.right = false;
	}

	public void keyPressed (KeyEvent e)
	{
		if(e.getCode() == KeyCode.RIGHT)
		{
			System.out.println("Tekan Tombol Kanan");	
		}
	}
}