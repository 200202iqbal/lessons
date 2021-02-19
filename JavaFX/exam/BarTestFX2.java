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

public class BarTestFX2 extends Application
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
		stage.setTitle("Bar Test FX 2");

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

		//canvas,graphicscontext
		Canvas canvas = new Canvas(640,480);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		pane.getChildren().add(canvas);

		//breakoutthread
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
	public BreakoutThread(GraphicsContext gc)
	{
		this.gc = gc;
		this.ball = new Ball();
		this.bar = new Bar();
		this.key = new Key();
	}

	@Override
	public void handle(long time)
	{
		gc.clearRect(0,0,640,480);

		ball.move();
		bar.move(key);
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

	public Ball()
	{
		this.x = 20;
		this.y = 20;
		this.x_speed = 5;
		this.y_speed = 5;
	}

	public void move()
	{
		this.x += x_speed;
		this.y += y_speed;
		if(this.x == 620)
		{
			this.x -= this.x_speed;
		}
		if(this.y == 460)
		{
			this.y -= this.y_speed; 
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
	private static boolean right;
	private static boolean left;
	//method
	public Key()
	{
		this.right = right;
		this.left = left;
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

	public static boolean isRightPressed()
	{
		return right;
	}
	public static boolean isLeftPressed()
	{
		return left;
	}
}

class Bar
{
	private int x;
	private int y;
	private int width;
	private int height;
	private int x_speed;

	public Bar()
	{
		this.x = 300;
		this.y = 450;
		this.width = 80;
		this.height = 20;
		this.x_speed = 5;
	}

	public void move(Key key)
	{
	
		if(key.isRightPressed() == true)
		{
			this.x += this.x_speed;
			
		}
		if(key.isLeftPressed() == true)
		{
			this.x -= this.x_speed;
		}

	}
	public void draw(GraphicsContext gc)
	{
		gc.setFill(Color.RED);
		gc.fillRect(x,y,width,height);
	}
}