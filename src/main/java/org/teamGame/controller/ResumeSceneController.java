package org.teamGame.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.teamGame.StartApp;
import org.teamGame.game.Handler;
import org.teamGame.game.configs.Configs;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.save.SaveDataGame;
import org.teamGame.util.HandlerApp;
import org.teamGame.util.Utils;

public class ResumeSceneController implements FxController{

    HandlerApp handlerApp;
    Handler handler;

    public ResumeSceneController(HandlerApp handlerApp, Handler handler){
        this.handler = handler;
        this.handlerApp = handlerApp;
    }

    @FXML
    private Button back;

    @FXML
    private Button soundOn;

    @FXML
    private Button soundOff;

    @FXML
    private Button save;

    @FXML
    private Button menu;

    @FXML
    public void initialize(){
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handler.getGameManager().getResumeStage().close();
            }
        });

        soundOn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(Configs.IS_MUTE) {
                    handlerApp.getSoundManager().unMuteAll();
                    Configs.IS_MUTE = false;
                }
            }
        });

        soundOff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!Configs.IS_MUTE){
                    handlerApp.getSoundManager().muteAll();
                    Configs.IS_MUTE = true;
                }
            }
        });

        menu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handler.getSoundManager().soundOff();
                handler.getGameManager().getMyTimer().stop();
                handler.getGameManager().getResumeStage().close();

                handlerApp.getApp().getStartScene().playSound();
                handlerApp.getStage().setScene(handlerApp.getApp().getStartScene().getScene());
            }
        });

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(StartApp.getSaveData().savedGame.size() == 10){
                    return;
                }
                int saved = handler.getGameManager().getSaved();
                if(saved == 0){

                    Player player = handler.getWorld().getEntityManager().getPlayer();

                    SaveDataGame saveDataGame= new SaveDataGame(1, player.getHealth(), player.getMaxHealth(),
                            (int)player.getEx(),(int) player.getMaxEx(), StartApp.getSaveData().savedGame.get(saved).getCharacter(),
                            player.getDamage(),player.getDefence(), player.getSpeed(), player.getSkillManager().getCount(), player.getSkillManager().getSkills(),
                            StartApp.getSaveData().savedGame.get(saved).getDifficulty(), player.getLevel());
                    StartApp.getSaveData().savedGame.add(saveDataGame);
                    handler.getGameManager().setSaved(StartApp.getSaveData().savedGame.indexOf(saveDataGame)) ;
                }
                else{

                    Player player = handler.getWorld().getEntityManager().getPlayer();
                    SaveDataGame saveDataGame = StartApp.getSaveData().savedGame.get(saved);
                    saveDataGame.setHealth(player.getHealth());
                    saveDataGame.setMaxHealth(player.getMaxHealth());
                    saveDataGame.setEx((int)player.getEx());
                    saveDataGame.setMaxEx((int)player.getMaxEx());
                    saveDataGame.setDamage(player.getDamage());
                    saveDataGame.setDefence(player.getDefence());
                    saveDataGame.setSpeed(player.getSpeed());
                    saveDataGame.setCount(player.getSkillManager().getCount());
                    saveDataGame.setSkills(player.getSkillManager().getSkills());
                    saveDataGame.setLevel(player.getLevel());
                }

                Utils.saveData(StartApp.getSaveData());
            }
        });
    }
}
