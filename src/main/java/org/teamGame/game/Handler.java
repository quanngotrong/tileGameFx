package org.teamGame.game;

import javafx.scene.canvas.GraphicsContext;
import org.teamGame.controller.GameController;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.game.gfx.GameCamera;
import org.teamGame.game.input.KeyManager;
import org.teamGame.game.input.MouseManager;
import org.teamGame.game.items.ItemManager;
import org.teamGame.sounds.SoundManager;
import org.teamGame.game.worlds.World;

public class Handler {

    //difficulty of game
    private int difficulty;

    // game manager
    GameManager gameManager;

    private World world;
    private boolean tele = true;
    private boolean win = false;

    private Player player;

    private ItemManager itemManager;

    public Handler(GameManager gameManager){
        this.gameManager = gameManager;
    }


    public void setWorld(World world, boolean tele) {
        this.tele = tele;
        this.world = world;

    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public GameController getGameController(){
        return this.gameManager.getGameController();
    }

    public GraphicsContext getGraphicsContext(){
        return gameManager.getG();
    }

    public KeyManager getKeyManager(){
        return gameManager.getKeyManager();
    }

    public MouseManager getMouseManager() {
        return gameManager.getMouseManager();
    }

    public GameCamera getGameCamera(){
        return gameManager.getGameCamera();
    }

    public World getWorld() {
        return world;
    }

    public boolean isTele() {
        return tele;
    }

    public void setTele(boolean tele) {
        this.tele = tele;
    }

    public int getWidth(){
        return gameManager.getWidth();
    }

    public int getHeight(){
        return gameManager.getHeight();
    }

    public SoundManager getSoundManager(){
        return gameManager.getSoundManager();
    }


    //getter and setter
    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }
}
