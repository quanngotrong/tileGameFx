package org.teamGame.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.teamGame.StartApp;
import org.teamGame.scene.GameScene;
import org.teamGame.util.HandlerApp;

public class DifficultySceneController implements FxController {

    HandlerApp handlerApp;

    public DifficultySceneController(HandlerApp handlerApp){
        this.handlerApp = handlerApp;
    }

    @FXML
    Button easyB;

    @FXML
    Button mediumB;

    @FXML
    Button hardB;

    @FXML
    Button backB;

    @FXML
    public void initialize(){

        this.easyB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameScene gameScene = new GameScene(handlerApp, 0);
                handlerApp.getStartScene().stopSound();
                //test
                StartApp.getSaveData().savedGame.get(0).setDifficulty(0);

                handlerApp.getStage().setScene(gameScene.getScene());

                handlerApp.getGameManager().start();

                handlerApp.getGameManager().getMyTimer().start();

            }
        });

        this.mediumB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameScene gameScene = new GameScene(handlerApp, 0);
                handlerApp.getStartScene().stopSound();
                //test
                StartApp.getSaveData().savedGame.get(0).setDifficulty(1);

                handlerApp.getStage().setScene(gameScene.getScene());

                handlerApp.getGameManager().start();

                handlerApp.getGameManager().getMyTimer().start();
                System.out.println("ha");

            }
        });

        this.hardB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameScene gameScene = new GameScene(handlerApp, 0);
                handlerApp.getStartScene().stopSound();
                //test
                StartApp.getSaveData().savedGame.get(0).setDifficulty(2);

                handlerApp.getStage().setScene(gameScene.getScene());

                handlerApp.getGameManager().start();

                handlerApp.getGameManager().getMyTimer().start();
                System.out.println("ha");
            }
        });

        this.backB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handlerApp.getStage().setScene(handlerApp.getChooseCharacterScene().getScene());
            }
        });

    }
}
