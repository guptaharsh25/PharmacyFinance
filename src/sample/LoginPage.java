package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage {

    String programName;
    String loginSceneText;
    String loginPromptText;
    String buttonText;
    String passwordLabelText;

    Text loginSceneTitle;
    Text loginPrompt;
    Label passwordLabel;
    PasswordField passwordEntry;
    Button button;

    public void loginPageSetup(Stage primaryStage){

        Controller ctrl = new Controller();

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(25,25,25,25));

        programName = "Pharmacy Finance Manager";
        loginSceneText = "Welcome";
        loginPromptText = "Please enter the password below.";
        passwordLabelText = "Password:";
        buttonText = "Enter";

        primaryStage.setTitle(programName);

        loginSceneTitle = new Text();
        loginSceneTitle.setText(loginSceneText);
        loginSceneTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        layout.add(loginSceneTitle, 0, 0, 2, 1);

        loginPrompt = new Text();
        loginPrompt.setText(loginPromptText);
        loginPrompt.setFont(Font.font("Helvetica", FontWeight.NORMAL,14));
        layout.add(loginPrompt, 0, 1, 2,1);

        passwordLabel = new Label();
        passwordLabel.setText(passwordLabelText);
        passwordLabel.setFont(Font.font("Helvetica", FontWeight.NORMAL, 14));
        layout.add(passwordLabel, 0, 2);

        passwordEntry = new PasswordField();
        layout.add(passwordEntry,1,2);

        final Text passwordCheck = new Text();
        layout.add(passwordCheck,0,3, 2,1);

        button = new Button();
        button.setText(buttonText);
        button.setFont(Font.font("Helvetica", FontWeight.NORMAL,12));
        button.setOnAction(ctrl.getHandler(primaryStage, passwordEntry, passwordCheck));

        HBox buttonHBox = new HBox();
        buttonHBox.setSpacing(10);
        buttonHBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonHBox.getChildren().add(button);
        layout.add(buttonHBox,1,3);

        Scene scene = new Scene(layout, 300,275);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
