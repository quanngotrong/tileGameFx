package org.teamGame.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.controller.DifficultySceneController;
import org.teamGame.controller.GameController;
import org.teamGame.game.configs.Configs;
import org.teamGame.sounds.Sound;
import org.teamGame.util.HandlerApp;

import java.io.IOException;

public class DifficultyScene extends SceneFx{
    public DifficultyScene(HandlerApp handlerApp) {
        super(handlerApp, "DifficultyScene");

        //music
        sceneSound = Sound.uchiha;
        handlerApp.getSoundManager().addSound(sceneSound);
//        if(!Configs.IS_MUTE)
//            sceneSound.play();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+ fxml+ ".fxml"));
        fxmlLoader.setController(new DifficultySceneController(handlerApp));

        AnchorPane root = null;
        try {
            root = (AnchorPane)fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root ,800, 600);
    }
}
