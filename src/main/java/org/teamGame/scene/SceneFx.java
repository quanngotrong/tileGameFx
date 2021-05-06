package org.teamGame.scene;

import javafx.scene.Scene;
import org.teamGame.StartApp;
import org.teamGame.util.HandlerApp;

public abstract class SceneFx {
    protected HandlerApp handlerApp;
    protected StartApp app;
    protected Scene scene;
    protected String fxml;

    public SceneFx(HandlerApp handlerApp, String fxml) {
        this.handlerApp = handlerApp;
        this.app = handlerApp.getApp();
        this.fxml = fxml;
    }

    public Scene getScene() {

        return scene;
    }
}
