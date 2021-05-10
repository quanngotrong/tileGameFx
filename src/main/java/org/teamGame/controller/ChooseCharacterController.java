package org.teamGame.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.teamGame.StartApp;
import org.teamGame.game.Handler;
import org.teamGame.setting.Setting;
import org.teamGame.util.HandlerApp;
import org.teamGame.util.Utils;

public class ChooseCharacterController {

    private int characterIndex;

    private HandlerApp handlerApp;

    public ChooseCharacterController(HandlerApp handlerApp){
        this.handlerApp = handlerApp;
        this.characterIndex = 0;
    }

    @FXML
    private ImageView characterShow;

    @FXML
    private Button buy;

    @FXML
    private Button nextCharacter;

    @FXML
    private Button next;

    @FXML
    private Button back;

    @FXML
    private Button preCharacter;

    @FXML
    private Text gold;

    @FXML
    public void initialize(){
        characterShow.setImage(Utils.chooseCharacter(characterIndex));
        next.setVisible(true);
        buy.setVisible(false);

        nextCharacter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                characterIndex = ( characterIndex + 1) % 10;
                characterShow.setImage(Utils.chooseCharacter(characterIndex));

                if(StartApp.getSaveData().getAvailCharacter()[characterIndex]){
                    next.setVisible(true);
                    buy.setVisible(false);
                }else{
                    next.setVisible(false);
                    buy.setVisible(true);
                    buy.setText(Integer.toString(Setting.priceCharacters[characterIndex]));
                }
            }
        });

        preCharacter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                characterIndex = (10 + characterIndex - 1) % 10;
                characterShow.setImage(Utils.chooseCharacter(characterIndex));

                if(StartApp.getSaveData().getAvailCharacter()[characterIndex]){
                    next.setVisible(true);
                    buy.setVisible(false);
                }else{
                    next.setVisible(false);
                    buy.setVisible(true);
                    buy.setText(Integer.toString(Setting.priceCharacters[characterIndex]));
                }
            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handlerApp.getStage().setScene(handlerApp.getDifficultyScene().getScene());
                StartApp.getSaveData().savedGame.get(0).setCharacter(characterIndex);
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handlerApp.getStage().setScene(handlerApp.getApp().getStartScene().getScene());
            }
        });

        buy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(StartApp.getSaveData().getGold() >= Setting.priceCharacters[characterIndex]){
                    StartApp.getSaveData().setGold(StartApp.getSaveData().getGold()-Setting.priceCharacters[characterIndex]);
                    StartApp.getSaveData().getAvailCharacter()[characterIndex] = true;
                    buy.setVisible(false);
                    next.setVisible(true);
                    setGold(StartApp.getSaveData().getGold());
                    Utils.saveData(StartApp.getSaveData());
                }
            }
        });
    }

    public void setGold(long amount){
        gold.setText("Gold: " + Long.toString(amount));
    }

}
