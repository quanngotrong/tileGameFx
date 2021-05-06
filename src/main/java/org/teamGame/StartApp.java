package org.teamGame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.teamGame.game.gfx.Assets;
import org.teamGame.scene.*;
import org.teamGame.util.HandlerApp;

public class StartApp extends Application {
    //handler
    private HandlerApp handlerApp;

    //stage
    private Stage stage;

    //scene
    private StartScene startScene;
    private Scene scene;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("game");

        startScene = new StartScene(handlerApp);
        scene = startScene.getScene();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    @Override
    public void init() throws Exception {
        super.init();
        handlerApp = new HandlerApp(this);
        Assets.init();

        handlerApp.setCreditScene(new CreditScene(handlerApp));
        handlerApp.setVictoryScene(new VictoryScene(handlerApp));
        handlerApp.setGameOverScene(new GameOverScene(handlerApp));
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public void launchGame(String[] args) {
        launch(args);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public StartScene getStartScene() {
        return startScene;
    }

    public void setStartScene(StartScene startScene) {
        this.startScene = startScene;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
