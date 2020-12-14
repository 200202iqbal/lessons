import javafx.application.Application;
import javafx.scene.Group;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.ParallelCamera;
import javafx.scene.SubScene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Game1 extends Application
{
	public static void main (String[] args)
	{
		launch(args);
	}
	//グループ作る ->□作る(赤) ->□をグループに入れる ->
	@Override
	public void start (Stage stage) throws Exception
	{
		//表示画面を作る
		Group root = new Group();
		Scene scene = new Scene(root,400,300);

		Rectangle rect01 = new Rectangle(100,125,50,50);
		//rectangle constructor//new Rectangle(setX,setY,setWidth,setHeight)

		//赤色の□を作り、Groupをルートにする
		//blue
		rect01.setFill(Color.web("#6bcfd1"));
		root.getChildren().add(rect01);

		//SubSceneを作り、Groupをルートにする
		//青い□を作る
		Group grp = new Group();
		SubScene sub = new SubScene(grp,400,300);
		//sub.setFill(Color.BLACK);
		//purple
		Rectangle rect02 = new Rectangle(250,125,50,50);

		//青色の□を、SubSceneのグループに追加する
		rect02.setFill(Color.web("#9d71eb"));
		grp.getChildren().add(rect02);

		//SubSceneにカメラを作る
		ParallelCamera cam = new ParallelCamera();
		//cam.setTranslateX(100);
		sub.setCamera(cam);

		//SubSceneを、rootグループに入れて、表示する
		root.getChildren().add(sub);
		stage.setScene(scene);
		stage.setTitle("Game 1");
		stage.show();
	}
}