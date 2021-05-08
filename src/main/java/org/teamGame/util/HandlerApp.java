package org.teamGame.util;

import javafx.stage.Stage;
import org.teamGame.StartApp;
import org.teamGame.controller.GameController;
import org.teamGame.game.GameManager;
import org.teamGame.scene.*;
import org.teamGame.sounds.SoundManager;

public class HandlerApp {
    //app
    StartApp app;

    //scene
    GameScene gameScene;
    StartScene startScene;
    VictoryScene victoryScene;
    GameOverScene gameOverScene;
    CreditScene creditScene;
    LoadScene loadScene;
    DifficultyScene difficultyScene;

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

    public SoundManager getSoundManager(){
        return this.app.getSoundManager();
    }

    public LoadScene getLoadScene() {
        return loadScene;
    }

    public void setLoadScene(LoadScene loadScene) {
        this.loadScene = loadScene;
    }

    public DifficultyScene getDifficultyScene() {
        return difficultyScene;
    }

    public void setDifficultyScene(DifficultyScene difficultyScene) {
        this.difficultyScene = difficultyScene;
    }

    public StartScene getStartScene() {
        return this.app.getStartScene();
    }
}
