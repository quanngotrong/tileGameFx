package org.teamGame.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.controller.StartMenuController;
import org.teamGame.util.HandlerApp;

import java.io.IOException;

public class StartScene extends SceneFx{

    public StartScene(HandlerApp handlerApp) {
        super(handlerApp, "StartMenu");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+ fxml+ ".fxml"));
        fxmlLoader.setController(new StartMenuController(handlerApp));

        AnchorPane root = null;
        try {
            root = (AnchorPane)fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/css/StartMenu.css").toExternalForm());
    }


}
