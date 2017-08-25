package sample;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class MainPage {

    String mainPageTitle;

    Controller ctrl;

    Button settingsButton;

    public void init(Stage loginStage){

        mainPageTitle = "Pharmacy Finance Manager";

        Stage mainStage = new Stage();

        mainStage.setTitle(mainPageTitle);

        loginStage.hide();
        mainStage.show();
    }

    public ListView<String> initSidePanelMenu (){

        ListView<String> menuPanel = new ListView<String>();
        ObservableList<String> menuItems =FXCollections.observableArrayList (
                "Home",
                        "Daily POS Statements",
                        "Insurance Claims",
                        "Square POS Incomes",
                        "PharmaClik Orders",
                        "Business Expenses",
                        "Claim an Expense",
                        "Returns and Voids",
                        "Miscellaneous Funds",
                        "Reports and Summaries"
        );

        menuPanel.setItems(menuItems);
        menuPanel.setOrientation(Orientation.VERTICAL);

        return menuPanel;
    }

    public StackPane setupSidePanel(){

        StackPane sidePane = new StackPane();
        HBox upperBar = new HBox();
        HBox settingsBar = new HBox();

        settingsButton = new Button();
        settingsButton.setText("Settings");
        settingsButton.setFont(Font.font("Helvetica", FontWeight.NORMAL,12));

        ListView<String> menuOfItems = initSidePanelMenu();

        Label menuLabel = new Label();
        menuLabel.setText("Menu");

        Button collapser = new Button();

        upperBar.getChildren().addAll(menuLabel, collapser);

        settingsBar.getChildren().add(settingsButton);

        sidePane.getChildren().add(settingsBar);
        sidePane.getChildren().add(menuOfItems);
        sidePane.getChildren().add(upperBar);

        return sidePane;
    }

}
