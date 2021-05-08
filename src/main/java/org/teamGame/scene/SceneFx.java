package org.teamGame.scene;

import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import org.teamGame.StartApp;
import org.teamGame.game.configs.Configs;
import org.teamGame.util.HandlerApp;

public abstract class SceneFx {
    protected HandlerApp handlerApp;
    protected StartApp app;
    protected Scene scene;
    protected String fxml;

    //music
    protected MediaPlayer sceneSound;

    public SceneFx(HandlerApp handlerApp, String fxml) {
        this.handlerApp = handlerApp;
        this.app = handlerApp.getApp();
        this.fxml = fxml;
    }

    public Scene getScene() {

        return scene;
    }

    public void playSound(){
        if(!Configs.IS_MUTE){
            sceneSound.play();
        }
    }

    public void stopSound(){
        sceneSound.stop();
    }
}
