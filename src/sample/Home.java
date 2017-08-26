package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Home {

    public Scene initHome (Stage mainStage) {

        Scene homeScene = new Scene(setupHome(), mainStage.getX(), mainStage.getY());

        return homeScene;
    }

    public GridPane setupHome(){

        MainPage mainPage = new MainPage();

        GridPane layout = new GridPane();
        GridPane homeLayout = new GridPane();

        layout.add(mainPage.setupSidePanel(),1,1);

        return layout;
    }

}
