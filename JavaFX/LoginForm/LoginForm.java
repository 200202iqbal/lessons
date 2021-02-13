import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.lang.String;

public class LoginForm extends Application
{
  public static void main (String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage)
  {
    Pane pane = new Pane();
    //pane.setStyle("-fx-background-color:black;");
    pane.setMinWidth(240);


    //Username
    Label labelUsername = new Label("Username : ");
    TextField txtfieldUsername = new TextField();
    //posisi x,y
    labelUsername.relocate(20,45);
    //set lebar ukuran field
    txtfieldUsername.setPrefWidth(130);
    txtfieldUsername.relocate(110,45);
    pane.getChildren().add(labelUsername);
    pane.getChildren().add(txtfieldUsername);

    //Password
    Label labelPassword = new Label("Password : ");
    PasswordField passwordField = new PasswordField();
    labelPassword.relocate(20,75);
    passwordField.setPrefWidth(130);
    passwordField.relocate(110,75);
    pane.getChildren().add(passwordField);
    pane.getChildren().add(labelPassword);

    //ProcessButton
    Button btnProcess = new Button("Enter");
    btnProcess.relocate(190,110);
    pane.getChildren().add(btnProcess);

    btnProcess.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event){
        String strUserName = txtfieldUsername.getText();
        String strPassword = passwordField.getText();
        //check password
        checkPassword(strUserName,strPassword);

      }
    });

    Scene scene = new Scene(pane,250,150);
    stage.setScene(scene);
    stage.setTitle("Login Form");
    stage.setResizable(false);
    stage.show();
  }
  public static void checkPassword(String inputUsername, String inputPassword)
  {
    String username = "admin";
    String password = "admin";

    if(inputUsername.isEmpty())
    {
      System.out.println("Fill username");
    }
    else if(inputUsername.matches(username))
    {
        if(inputPassword.isEmpty())
        {
          System.out.println("Fill password");
        }
        else if(inputPassword.matches(password))
        {
          System.out.println("Login Success ! ");
        }else
        {
          System.out.println("Password Wrong ! ");
        }
    }
    else
    {
      System.out.println("Username Wrong ! ");
    }
  }
}
