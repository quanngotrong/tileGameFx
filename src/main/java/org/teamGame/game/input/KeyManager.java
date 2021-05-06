package org.teamGame.game.input;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.teamGame.game.Handler;

import java.util.HashMap;

public class KeyManager {
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();

    //game scene
    Scene scene;
    Handler handler;

    public KeyManager(Scene scene, Handler handler){
        this.scene = scene;
        this.handler = handler;

    }

    public void addListener(){
        this.scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        this.scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
    }

    private EventHandler<KeyEvent> keyPressedEventHandler = e -> keys.put(e.getCode(), true);

    private EventHandler<KeyEvent> keyReleasedEventHandler = e -> {
//        if(handler.isInGame()) {
            keys.put(e.getCode(), false);
            if (e.getCode() == KeyCode.F) {
                handler.getWorld().getEntityManager().getPlayer().getInventory().changeActive();
            } else if (e.getCode() == KeyCode.DOWN) {
                if (handler.getWorld().getEntityManager().getPlayer().getInventory().isActive()) {
                    handler.getWorld().getEntityManager().getPlayer().getInventory().scrollDown();
                }

            } else if (e.getCode() == KeyCode.UP) {
                if (handler.getWorld().getEntityManager().getPlayer().getInventory().isActive()) {
                    handler.getWorld().getEntityManager().getPlayer().getInventory().scrollUp();
                }
            } else if (e.getCode() == KeyCode.ENTER) {
                if (handler.getWorld().getEntityManager().getPlayer().getInventory().isActive()) {
                    handler.getWorld().getEntityManager().getPlayer().getInventory().useItem();
                }
            }
//        }
    };

    public boolean isMoveUp(){
        return keys.getOrDefault(KeyCode.W, false) || keys.getOrDefault(KeyCode.UP, false);
    }
    public boolean isMoveDown(){
        return keys.getOrDefault(KeyCode.S, false) || keys.getOrDefault(KeyCode.DOWN, false);
    }
    public boolean isMoveLeft(){
        return keys.getOrDefault(KeyCode.A, false) || keys.getOrDefault(KeyCode.LEFT, false);
    }
    public boolean isMoveRight(){
        return keys.getOrDefault(KeyCode.D, false) || keys.getOrDefault(KeyCode.RIGHT, false);
    }
    public boolean isSpace(){
        return keys.getOrDefault(KeyCode.SPACE, false);
    }
    public boolean isPause(){
        return keys.getOrDefault(KeyCode.P, false);
    }
    public boolean isSpell(){
        return keys.getOrDefault(KeyCode.Q, false);
    }

    public boolean isDestroyThemAll(){
        return keys.getOrDefault(KeyCode.CONTROL, false) && keys.getOrDefault(KeyCode.TAB, false);
    }

    public boolean isSkill1(){return keys.getOrDefault(KeyCode.Q, false);}
    public boolean isSkill2(){return keys.getOrDefault(KeyCode.E, false);}
    public boolean isSkill3(){return keys.getOrDefault(KeyCode.R, false);}
    public boolean isSkill4(){return keys.getOrDefault(KeyCode.SPACE, false);}

    public boolean isEnter() {
        return keys.getOrDefault(KeyCode.ENTER, false);
    }
}
