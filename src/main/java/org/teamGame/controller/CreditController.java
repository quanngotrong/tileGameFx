package org.teamGame.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.teamGame.util.HandlerApp;

public class CreditController implements FxController{

    HandlerApp handlerApp;

    public CreditController(HandlerApp handlerApp){
        this.handlerApp = handlerApp;
    }

    @FXML
    Button returnB;

    @FXML
    public void initialize(){

        this.returnB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handlerApp.getStage().setScene(handlerApp.getApp().getStartScene().getScene());
            }
        });
    }
}
