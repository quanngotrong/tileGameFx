package org.teamGame.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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

    public Text getAp() {
        return ap;
    }

    public void setAp(Text ap) {
        this.ap = ap;
    }

    public ImageView getSkill1() {
        return skill1;
    }

    public void setSkill1(ImageView skill1) {
        this.skill1 = skill1;
    }

    public ImageView getSkill2() {
        return skill2;
    }

    public void setSkill2(ImageView skill2) {
        this.skill2 = skill2;
    }

    public ImageView getSkill3() {
        return skill3;
    }

    public void setSkill3(ImageView skill3) {
        this.skill3 = skill3;
    }

    public ImageView getSkill4() {
        return skill4;
    }

    public void setSkill4(ImageView skill4) {
        this.skill4 = skill4;
    }

    public Rectangle getCoverRec1() {
        return coverRec1;
    }

    public void setCoverRec1(Rectangle coverRec1) {
        this.coverRec1 = coverRec1;
    }

    public Rectangle getCoverRec2() {
        return coverRec2;
    }

    public void setCoverRec2(Rectangle coverRec2) {
        this.coverRec2 = coverRec2;
    }

    public Rectangle getCoverRec3() {
        return coverRec3;
    }

    public void setCoverRec3(Rectangle coverRec3) {
        this.coverRec3 = coverRec3;
    }

    public Rectangle getCoverRec4() {
        return coverRec4;
    }

    public void setCoverRec4(Rectangle coverRec4) {
        this.coverRec4 = coverRec4;
    }

    public Text getCountDown1() {
        return countDown1;
    }

    public void setCountDown1(Text countDown1) {
        this.countDown1 = countDown1;
    }

    public Text getCountDown2() {
        return countDown2;
    }

    public void setCountDown2(Text countDown2) {
        this.countDown2 = countDown2;
    }

    public Text getCountDown3() {
        return countDown3;
    }

    public void setCountDown3(Text countDown3) {
        this.countDown3 = countDown3;
    }

    public Text getCountDown4() {
        return countDown4;
    }

    public void setCountDown4(Text countDown4) {
        this.countDown4 = countDown4;
    }
}
