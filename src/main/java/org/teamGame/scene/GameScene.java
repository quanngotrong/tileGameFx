package org.teamGame.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.controller.GameController;
import org.teamGame.controller.StartMenuController;
import org.teamGame.util.HandlerApp;

import java.io.IOException;

public class GameScene extends SceneFx{

    private int difficulty;

    public GameScene(HandlerApp handlerApp, int difficulty) {
        super(handlerApp, "GameScene");
        this.difficulty = difficulty;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+ fxml+ ".fxml"));
        fxmlLoader.setController(new GameController(handlerApp, difficulty, this));

        AnchorPane root = null;
        try {
            root = (AnchorPane)fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root, 800, 600);

    }
}
