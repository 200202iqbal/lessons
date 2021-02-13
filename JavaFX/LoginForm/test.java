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

public class test extends Application
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
    labelUsername.relocate(20,45);
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
        System.out.println(strUserName + " " + strPassword);
      }
    });

    Scene scene = new Scene(pane,250,150);
    stage.setScene(scene);
    stage.setTitle("Login Form");
    stage.setResizable(false);
    stage.show();
  }
}
