package sample;

import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.scene.text.*;
import javafx.scene.control.TextField;

public class Controller {

    String password = "2233";
    int passwordTriesLeft = 3;

    MainPage initMain;

    private EventHandler<ActionEvent> EH;

    public void loginChecker(TextField passwordEntry, Text passwordCheck){
        EH = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String inPass = getPass(passwordEntry);
                validatePass(inPass, passwordCheck);
            }
        };
    }

    public String getPass(TextField passwordEntry){
        return passwordEntry.getText();
    }

    public void validatePass(String inPass, Text passwordCheck){

        if (inPass.equals(password)) {
            System.out.print("\n" + inPass);

            passwordCheck.setFill(Color.GREEN);
            passwordCheck.setText("Login successful. Please wait...");

            initMain.init();

            passwordTriesLeft = 3;
        }

        else{
            System.out.print("\n" + inPass);

            passwordCheck.setFill(Color.FIREBRICK);
            passwordCheck.setText("Password incorrect.\nYou have " + passwordTriesLeft + " tries left.");

            passwordTriesLeft--;
        }
    }

    public EventHandler<ActionEvent> getHandler(TextField passwordEntry, Text passwordChecker){

        loginChecker(passwordEntry, passwordChecker);

        return EH;
    }

}
