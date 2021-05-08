package org.teamGame.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.controller.ResumeSceneController;
import org.teamGame.controller.SettingSceneController;
import org.teamGame.game.Handler;
import org.teamGame.sounds.Sound;
import org.teamGame.util.HandlerApp;

import java.io.IOException;

public class ResumeScene extends SceneFx{

    //do đây là cửa sổ mở trong lúc chơi game nên phải thêm handler
    private Handler handler;

    public ResumeScene(HandlerApp handlerApp, Handler handler) {
        super(handlerApp, "ResumeScene");
        this.handler = handler;
        //music
        sceneSound = Sound.uchiha;
        handlerApp.getSoundManager().addSound(sceneSound);
//        if(!Configs.IS_MUTE)
//            sceneSound.play();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+ fxml+ ".fxml"));
        fxmlLoader.setController(new ResumeSceneController(handlerApp, handler));

        AnchorPane root = null;
        try {
            root = (AnchorPane)fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root ,600, 400);
    }

}
