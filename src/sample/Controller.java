package sample;

import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.scene.text.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    String password = "2233";
    int passwordTriesLeft = 3;

    MainPage initMain;

    private EventHandler<ActionEvent> EH;

    public void loginChecker(Stage loginStage, TextField passwordEntry, Text passwordCheck){
        EH = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String inPass = getPass(passwordEntry);
                validatePass(loginStage, inPass, passwordCheck);
            }
        };
    }

    public String getPass(TextField passwordEntry){
        return passwordEntry.getText();
    }

    public void validatePass(Stage loginStage, String inPass, Text passwordCheck){

        initMain = new MainPage();

        if (inPass.equals(password)) {
            System.out.print("\n" + inPass);

            passwordCheck.setFill(Color.GREEN);
            passwordCheck.setText("Login successful. Please wait...");

            initMain.init(loginStage);

            passwordTriesLeft = 3;
        }

        else{
            System.out.print("\n" + inPass);

            passwordCheck.setFill(Color.FIREBRICK);
            passwordCheck.setText("Password incorrect.\nYou have " + passwordTriesLeft + " tries left.");

            passwordTriesLeft--;
        }
    }

    public EventHandler<ActionEvent> getHandler(Stage loginStage, TextField passwordEntry, Text passwordChecker){

        loginChecker(loginStage, passwordEntry, passwordChecker);

        return EH;
    }

}
