package org.teamGame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.teamGame.game.gfx.Assets;
import org.teamGame.save.SaveData;
import org.teamGame.scene.*;
import org.teamGame.sounds.SoundManager;
import org.teamGame.util.HandlerApp;
import org.teamGame.util.Utils;

public class StartApp extends Application {
    //handler
    private HandlerApp handlerApp;

    //stage
    private Stage stage;

    //setting stage
    private Stage settingStage;

    //scene
    private StartScene startScene;
    private Scene scene;

    //save data
    private static SaveData saveData;

    //money to buy st
    public static long gold;

    //sound
    private SoundManager soundManager;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("The Lone Avenger");

        startScene = new StartScene(handlerApp);
        startScene.playSound();

        scene = startScene.getScene();

        //setting stage
        settingStage = new Stage();
        settingStage.setScene(new SettingScene(handlerApp).getScene());
        settingStage.initModality(Modality.APPLICATION_MODAL);

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

        //sound
        soundManager = new SoundManager(handlerApp);

        handlerApp = new HandlerApp(this);
        Assets.init();

        handlerApp.setCreditScene(new CreditScene(handlerApp));
        handlerApp.setVictoryScene(new VictoryScene(handlerApp));
        handlerApp.setGameOverScene(new GameOverScene(handlerApp));
        handlerApp.setDifficultyScene(new DifficultyScene(handlerApp));

        saveData = Utils.loadData();
        gold = saveData.getGold();

        handlerApp.setLoadScene(new LoadScene(handlerApp));


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

    public static SaveData getSaveData() {
        return saveData;
    }

    public static void setSaveData(SaveData saveData) {
        StartApp.saveData = saveData;
    }

    public HandlerApp getHandlerApp() {
        return handlerApp;
    }

    public void setHandlerApp(HandlerApp handlerApp) {
        this.handlerApp = handlerApp;
    }

    public static long getGold() {
        return gold;
    }

    public static void setGold(long gold) {
        StartApp.gold = gold;
    }

    public SoundManager getSoundManager() {
        return soundManager;
    }

    public void setSoundManager(SoundManager soundManager) {
        this.soundManager = soundManager;
    }

    public Stage getSettingStage() {
        return settingStage;
    }

    public void setSettingStage(Stage settingStage) {
        this.settingStage = settingStage;
    }
}
