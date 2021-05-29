package org.teamGame.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.controller.GameController;
import org.teamGame.controller.StartMenuController;
import org.teamGame.game.configs.Configs;
import org.teamGame.sounds.Sound;
import org.teamGame.util.HandlerApp;

import java.io.IOException;

public class GameScene extends SceneFx{

    private int saved;
    public GameScene(HandlerApp handlerApp, int saved) {
        super(handlerApp, "GameScene");

        this.saved = saved;
        //music
        sceneSound = Sound.main;
        handlerApp.getSoundManager().addSound(sceneSound);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+ fxml+ ".fxml"));
        fxmlLoader.setController(new GameController(handlerApp, this, this.saved));

        AnchorPane root = null;
        try {
            root = (AnchorPane)fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root, 800, 600);

    }
}
