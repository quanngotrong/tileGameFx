package org.teamGame.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.teamGame.util.HandlerApp;

public class VictoryController implements FxController {
    HandlerApp handlerApp;

    public VictoryController(HandlerApp handlerApp){
        this.handlerApp = handlerApp;
    }

    @FXML
    Button restart;

    @FXML
    Button exit;

    @FXML
    public void initialize(){

        this.restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handlerApp.getVictoryScene().stopSound();
                handlerApp.getStartScene().playSound();

                handlerApp.getStage().setScene(handlerApp.getApp().getStartScene().getScene());
            }
        });

        this.exit.setOnAction(actionEvent -> Platform.exit());
    }


}
