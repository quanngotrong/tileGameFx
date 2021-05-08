package org.teamGame.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.teamGame.game.GameManager;
import org.teamGame.game.input.KeyManager;
import org.teamGame.scene.GameScene;
import org.teamGame.util.HandlerApp;

import java.util.Map;

public class GameController implements FxController{

    private HandlerApp handlerApp;

    //game manager
    GameManager gameManager;

    //display
    private GraphicsContext gc;

    //game scene
    GameScene gameScene;

    //saved
    private int saved;


    public GameController(HandlerApp handlerApp, GameScene gameScene, int saved){
        this.handlerApp = handlerApp;

        this.gameScene = gameScene;

        this.saved = saved;
    }

    @FXML
    private Canvas canvas;

    @FXML
    private Text attack;

    @FXML
    private Text ap;

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
    private ImageView skill1;

    @FXML
    private ImageView skill2;

    @FXML
    private ImageView skill3;

    @FXML
    private ImageView skill4;

    @FXML
    private Rectangle coverRec1;

    @FXML
    private Rectangle coverRec2;

    @FXML
    private Rectangle coverRec3;

    @FXML
    private Rectangle coverRec4;

    @FXML
    private Text countDown1;

    @FXML
    private Text countDown2;

    @FXML
    private Text countDown3;

    @FXML
    private Text countDown4;

    @FXML
    private GridPane containter13;

    @FXML
    private Button pause;

    @FXML
    public void initialize(){
        // initialize the game
        // them gameScene de xu ly input
        // them this de them duoc canvas

        gameManager = new GameManager(handlerApp, this , saved);
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

    public ProgressBar getHpBar() {
        return hpBar;
    }

    public ProgressBar getExBar() {
        return exBar;
    }

    public Text getExShow() {
        return exShow;
    }

    public Text getHpShow() {
        return hpShow;
    }

    public Text getAp() {
        return ap;
    }

    public ImageView getSkill1() {
        return skill1;
    }

    public ImageView getSkill2() {
        return skill2;
    }

    public ImageView getSkill3() {
        return skill3;
    }

    public ImageView getSkill4() {
        return skill4;
    }

    public Rectangle getCoverRec1() {
        return coverRec1;
    }

    public Rectangle getCoverRec2() {
        return coverRec2;
    }

    public Rectangle getCoverRec3() {
        return coverRec3;
    }

    public Rectangle getCoverRec4() {
        return coverRec4;
    }

    public Text getCountDown1() {
        return countDown1;
    }

    public Text getCountDown2() {
        return countDown2;
    }

    public Text getCountDown3() {
        return countDown3;
    }

    public Text getCountDown4() {
        return countDown4;
    }

    public GridPane getContainter13() {
        return containter13;
    }

    public Button getPause() {
        return pause;
    }
}
