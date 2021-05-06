package org.teamGame.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import org.teamGame.game.GameManager;
import org.teamGame.game.input.KeyManager;
import org.teamGame.scene.GameScene;
import org.teamGame.util.HandlerApp;

import java.util.Map;

public class GameController implements FxController{

    private HandlerApp handlerApp;

    //difficulty of game
    private int difficulty;

    //game manager
    GameManager gameManager;

    //display
    private GraphicsContext gc;

    //game scene
    GameScene gameScene;


    public GameController(HandlerApp handlerApp, int difficulty, GameScene gameScene){
        this.handlerApp = handlerApp;
        this.difficulty = difficulty;
        this.gameScene = gameScene;

    }

    @FXML
    private Canvas canvas;

    @FXML
    private Text attack;

    @FXML
    private Text speed;

    @FXML
    private Text defence;

    @FXML
    private ProgressBar hpBar;

    @FXML
    private ProgressBar exBar;

    @FXML
    private Text exShow;

    @FXML
    private Text hpShow;

    @FXML
    public void initialize(){
        // initialize the game
        // them gameScene de xu ly input
        // them this de them duoc canvas

        gameManager = new GameManager(handlerApp, difficulty, this);


    }


    //getter and setter
    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Text getAttack() {
        return attack;
    }

    public void setAttack(Text attack) {
        this.attack = attack;
    }

    public Text getSpeed() {
        return speed;
    }

    public void setSpeed(Text speed) {
        this.speed = speed;
    }

    public Text getDefence() {
        return defence;
    }

    public void setDefence(Text defence) {
        this.defence = defence;
    }

    public ProgressBar getHpBar() {
        return hpBar;
    }

    public void setHpBar(ProgressBar hpBar) {
        this.hpBar = hpBar;
    }

    public ProgressBar getExBar() {
        return exBar;
    }

    public void setExBar(ProgressBar exBar) {
        this.exBar = exBar;
    }

    public Text getExShow() {
        return exShow;
    }

    public void setExShow(Text exShow) {
        this.exShow = exShow;
    }

    public Text getHpShow() {
        return hpShow;
    }

    public void setHpShow(Text hpShow) {
        this.hpShow = hpShow;
    }
}
