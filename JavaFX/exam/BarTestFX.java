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

public class BarTestFX extends Application
{
	//data
	private BreakoutThread breakoutthread;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		stage.setTitle("Bar Test FX");

		//pane,scene
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		Key key = new Key();
		scene.setOnKeyPressed(
			new EventHandler<KeyEvent>(){
				public void handle(KeyEvent e){
					key.keyPressed(e);
				}
			});
		scene.setOnKeyReleased(
			new EventHandler<KeyEvent>(){
				public void handle(KeyEvent e){
					key.keyReleased(e);
				}
			});

			Bar bar = new Bar(key);
		//canvas,graphicscontext
		Canvas canvas = new Canvas(640,480);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		pane.getChildren().add(canvas);

		//breakoutthread
		breakoutthread = new BreakoutThread(gc,key,bar);
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

	//method
	public BreakoutThread(GraphicsContext gc,Key key,Bar bar)
	{
		this.gc = gc;
		this.ball = new Ball(bar);
		this.bar = new Bar(key);
	}

	@Override
	public void handle(long time)
	{
		gc.clearRect(0,0,640,480);

		ball.move();
		bar.move();
		ball.collision();
		ball.draw(gc);
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
	private Bar bar;

	public Ball(Bar bar)
	{
		this.x = 100;
		this.y = 20;
		this.x_speed = 5;
		this.y_speed = 5;
		this.bar = bar;
	}

	public void move()
	{
		this.x += x_speed;
		this.y += y_speed;

		if(this.x > 610 || this.y > 450  )
		{
			x_speed *= -1;
			y_speed *= -1;
		}
		if(this.x < 0 || this.y < 0)
		{
			x_speed *= -1;
			y_speed *= -1;
		}
	}

	public void collision()
	{
		if(this.y == bar.getYcorrdinate() && this.y == bar.getBarArea())
		{
			x_speed *= -1;
			y_speed *= -1;
		}
	}

	public void draw(GraphicsContext gc)
	{
		gc.setFill(Color.BLUE);
		gc.fillOval(x,y,20,20);
	}
}

class Key
{
	//data
	private boolean right;
	private boolean left;
	//method
	public Key()
	{
		this.right = false;
		this.left = false;
	}
	public void keyPressed(KeyEvent e)
	{

		switch(e.getCode())
		{
			case LEFT:
			System.out.println(e.getCode() + " pressed");
			left = true;
			break;
			case RIGHT:
			System.out.println(e.getCode() + " pressed");
			right = true;
			break;
			default:
		}
	}
	public void keyReleased(KeyEvent e)
	{

		switch(e.getCode())
		{
			case LEFT:
			System.out.println(e.getCode() + " released");
			left = false;
			break;
			case RIGHT:
			System.out.println(e.getCode() + " released");
			right = false;
			break;
			default:
		}
	}

	public boolean isRightPressed()
	{
		return right;
	}
	public boolean isLeftPressed()
	{
		return left;
	}
	public void setRightPressed(boolean right)
	{
		this.right = right;
	}
}

class Bar
{
	private int x;
	private int y;
	private int width;
	private int height;
	private int x_speed;
	private Key key;
	private int area;

	public Bar(Key key)
	{
		this.x = 300;
		this.y = 450;
		this.width = 80;
		this.height = 20;
		this.x_speed = 5;
		this.key = key;
		this.area = this.x * this.y;
	}
	public int getXcoordinate()
	{
		return this.x;
	}
	public int getYcorrdinate()
	{
		return this.y;
	}
	public int getBarArea()
	{
		return this.area;
	}
	public void move()
	{

		if(key.isRightPressed() == true)
		{
			this.x += this.x_speed;
			if(this.x == 560)
			{
				this.x -= this.x_speed;
			}
		}


		if(key.isLeftPressed() == true)
		{
			this.x -= this.x_speed;
			if(this.x == 0)
			{
				this.x += this.x_speed;
			}
		}

	}
	public void draw(GraphicsContext gc)
	{
		gc.setFill(Color.RED);
		gc.fillRect(x,y,width,height);
	}
}
