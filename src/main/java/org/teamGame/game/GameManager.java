package org.teamGame.game;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.teamGame.controller.GameController;
import org.teamGame.game.configs.Configs;
import org.teamGame.game.gfx.Assets;
import org.teamGame.game.gfx.GameCamera;
import org.teamGame.game.input.KeyManager;
import org.teamGame.game.input.MouseManager;
import org.teamGame.game.maps.Tile;
import org.teamGame.sounds.SoundManager;
import org.teamGame.game.state.GameState;
import org.teamGame.scene.GameScene;
import org.teamGame.util.HandlerApp;

public class GameManager {
    //handler app
    HandlerApp handlerApp;

    //handler game
    Handler handler;

    //container and display
    private GameController gameController;
    private Canvas canvas;
    private GraphicsContext g;

    //width and height of screen
    private int width = Configs.STAGE_WIDTH, height = Configs.STAGE_HEIGHT;

    //scene
    private Scene scene;
    private GameScene gameScene;

    //input
    KeyManager keyManager;
    MouseManager mouseManager;

    //sounds
    SoundManager soundManager;

    //game camera
    GameCamera gameCamera;

    //loop
    long timePerUpDate;
    long start;

    //game state
    GameState gameState;

    //timer
    AnimationTimer myTimer;

    /*
    tao game voi do kho cho san
     */
    public GameManager(HandlerApp handlerApp, int difficulty, GameController gameController){
        this.handlerApp = handlerApp;
        handlerApp.setGameManager(this);

        //create handler and set difficulty
        this.handler = new Handler(this);
        handler.setDifficulty(difficulty);

        //create container: canvas
        this.gameController = gameController;
        this.canvas = gameController.getCanvas();

    }

    //initialize assets
    public void init(){

        Tile.init();
    }

    public void start(){
        init();
        this.scene = handlerApp.getStage().getScene();

        //graphic
        g = canvas.getGraphicsContext2D();

        System.out.println(handlerApp.getStage().getScene());
        //input
        keyManager = new KeyManager(scene, handler);
        keyManager.addListener();
        mouseManager = new MouseManager(scene);
        mouseManager.addListener();

        //sound
        soundManager = new SoundManager(handler);

        //camera
        gameCamera = new GameCamera(handler, 0, 0);

        //game state
        gameState = new GameState(handler);

        //start game loop
        start = System.nanoTime();
        timePerUpDate = 1000000000/Configs.FPS;

//        AnimationTimer gameLoop = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//
//                if(l - start > timePerUpDate) {
//                    start = l;
//                    tick();
//                    render(g);
//                }
//            }
//        };
//        gameLoop.start();

        myTimer = new MyTimer();
    }

    private class MyTimer extends AnimationTimer{

        @Override
        public void handle(long now) {
            doHandle(now);
        }

        private void doHandle(long now) {
            if(now - start > timePerUpDate) {
                start = now;
                tick();
                render(g);
            }
        }

    }

    public void tick(){
        gameState.tick();

    }

    public void render(GraphicsContext g){
        g.clearRect(0, 0, width, height);
        gameState.render(g);


    }

    //getter and setter
    public HandlerApp getHandlerApp() {
        return handlerApp;
    }

    public void setHandlerApp(HandlerApp handlerApp) {
        this.handlerApp = handlerApp;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public GraphicsContext getG() {
        return g;
    }

    public void setG(GraphicsContext g) {
        this.g = g;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public GameScene getGameScene() {
        return gameScene;
    }

    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public void setKeyManager(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public SoundManager getSoundManager() {
        return soundManager;
    }

    public void setSoundManager(SoundManager soundManager) {
        this.soundManager = soundManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public void setGameCamera(GameCamera gameCamera) {
        this.gameCamera = gameCamera;
    }

    public long getTimePerUpDate() {
        return timePerUpDate;
    }

    public void setTimePerUpDate(long timePerUpDate) {
        this.timePerUpDate = timePerUpDate;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public void setMouseManager(MouseManager mouseManager) {
        this.mouseManager = mouseManager;
    }

    public AnimationTimer getMyTimer() {
        return myTimer;
    }

    public void setMyTimer(AnimationTimer myTimer) {
        this.myTimer = myTimer;
    }
}