package org.teamGame.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.teamGame.StartApp;
import org.teamGame.game.input.KeyManager;
import org.teamGame.scene.*;
import org.teamGame.util.HandlerApp;

import java.io.IOException;

public class StartMenuController implements FxController {

    private HandlerApp handlerApp;

    public StartMenuController(HandlerApp handlerApp){
        this.handlerApp  = handlerApp;
    }

    @FXML
    private Button startButton;

    @FXML
    private Button continueButton;

    @FXML
    private Button creditButton;

    @FXML
    private Button exitButton;

    @FXML
    public void initialize(){

        this.startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handlerApp.getStage().setScene(handlerApp.getDifficultyScene().getScene());
            }
        });

        this.creditButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handlerApp.getStage().setScene(handlerApp.getCreditScene().getScene());
            }
        });

        this.exitButton.setOnAction(actionEvent -> Platform.exit());

        this.continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handlerApp.getLoadScene().refreshLoadScene();
                handlerApp.getStage().setScene(handlerApp.getLoadScene().getScene());
            }
        });
    }

}
