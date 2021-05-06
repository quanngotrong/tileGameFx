package org.teamGame.util;

import javafx.stage.Stage;
import org.teamGame.StartApp;
import org.teamGame.controller.GameController;
import org.teamGame.game.GameManager;
import org.teamGame.scene.CreditScene;
import org.teamGame.scene.GameOverScene;
import org.teamGame.scene.GameScene;
import org.teamGame.scene.VictoryScene;

public class HandlerApp {
    //app
    StartApp app;

    //scene
    GameScene gameScene;
    VictoryScene victoryScene;
    GameOverScene gameOverScene;
    CreditScene creditScene;

    //Game manager
    GameManager gameManager;

    public GameController getGameController(){
        return gameManager.getGameController();
    }

    //Stage
    private Stage stage;

    public HandlerApp(StartApp app){
        this.app = app;
    }

    //getter and setter
    public StartApp getApp() {
        return app;
    }

    public void setApp(StartApp app) {
        this.app = app;
    }

    public Stage getStage() {
        return app.getStage();
    }

    public GameScene getGameScene() {
        return gameScene;
    }

    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public VictoryScene getVictoryScene() {
        return victoryScene;
    }

    public void setVictoryScene(VictoryScene victoryScene) {
        this.victoryScene = victoryScene;
    }

    public GameOverScene getGameOverScene() {
        return gameOverScene;
    }

    public void setGameOverScene(GameOverScene gameOverScene) {
        this.gameOverScene = gameOverScene;
    }

    public CreditScene getCreditScene() {
        return creditScene;
    }

    public void setCreditScene(CreditScene creditScene) {
        this.creditScene = creditScene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
