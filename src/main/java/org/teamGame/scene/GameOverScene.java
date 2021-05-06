package org.teamGame.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.controller.CreditController;
import org.teamGame.controller.GameOverController;
import org.teamGame.util.HandlerApp;

import java.io.IOException;

public class GameOverScene extends SceneFx{
    public GameOverScene(HandlerApp handlerApp) {
        super(handlerApp, "GameOverScene");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+ fxml+ ".fxml"));
        fxmlLoader.setController(new GameOverController(handlerApp));

        AnchorPane root = null;
        try {
            root = (AnchorPane)fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root ,800, 600);
    }
}
