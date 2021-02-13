import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class test extends Application
{
  public static void main (String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage)
  {
    GridPane gdpane = new GridPane();
    gdpane.setPadding(new Insets(20));
    gdpane.setHgap(15);
    gdpane.setVgap(15);

    //Label
    Label labelText = new Label("Enter your text : ");

    GridPane.setHalignment(labelText,HPos.LEFT);
    //put on cell(0,1) x,y
    gdpane.add(labelText,0,1);

    //TextField
    TextField fieldText = new TextField();
    fieldText.setPrefWidth(300); //set ukuran lebar
    GridPane.setHalignment(fieldText,HPos.LEFT); //set rata kiri
    //put on cell(1,1) x,y
    gdpane.add(fieldText,1,1);

    //Create MenuItems
    MenuItem itemSHA512 = new MenuItem("SHA-512");
    MenuItem itemSHA384 = new MenuItem("SHA-384");
    MenuItem itemSHA256 = new MenuItem("SHA-256");
    MenuItem itemSHA224 = new MenuItem("SHA-224");
    MenuItem itemSHA1 = new MenuItem("SHA1");
    MenuItem itemMD5 = new MenuItem("MD5");

    //Create a MenuButton
    MenuButton menuButton = new MenuButton("Encryption",null,
    itemSHA512,itemSHA384,itemSHA256,itemSHA224,itemSHA1,itemMD5);
    gdpane.add(menuButton,2,1);

    //Button Process
    Button btnProcess = new Button("Show");
    gdpane.add(btnProcess,3,1);

    Scene scene = new Scene(gdpane,650,100);
    stage.setTitle("Encryption Form");
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();
  }
}
