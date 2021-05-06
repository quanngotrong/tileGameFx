package org.teamGame.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.teamGame.game.input.KeyManager;
import org.teamGame.scene.CreditScene;
import org.teamGame.scene.DifficultyScene;
import org.teamGame.scene.GameScene;
import org.teamGame.scene.StartScene;
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
                DifficultyScene difficultyScene = new DifficultyScene(handlerApp);

                handlerApp.getStage().setScene(difficultyScene.getScene());

            }
        });

        this.creditButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CreditScene creditScene = new CreditScene(handlerApp);
                handlerApp.getStage().setScene(creditScene.getScene());
            }
        });

        this.exitButton.setOnAction(actionEvent -> Platform.exit());

    }

}
