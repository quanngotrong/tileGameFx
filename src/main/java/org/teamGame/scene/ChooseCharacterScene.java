package org.teamGame.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.controller.ChooseCharacterController;
import org.teamGame.controller.CreditController;
import org.teamGame.sounds.Sound;
import org.teamGame.util.HandlerApp;

import java.io.IOException;

public class ChooseCharacterScene extends SceneFx{
    private ChooseCharacterController chooseCharacterController;

    public ChooseCharacterScene(HandlerApp handlerApp) {
        super(handlerApp, "ChooseCharacterScene");

        //music
        sceneSound = Sound.uchiha;
        handlerApp.getSoundManager().addSound(sceneSound);

        chooseCharacterController = new ChooseCharacterController(handlerApp);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+ fxml+ ".fxml"));
        fxmlLoader.setController(chooseCharacterController);

        AnchorPane root = null;
        try {
            root = (AnchorPane)fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root ,800, 600);
    }

    public ChooseCharacterController getChooseCharacterController() {
        return chooseCharacterController;
    }

    public void setChooseCharacterController(ChooseCharacterController chooseCharacterController) {
        this.chooseCharacterController = chooseCharacterController;
    }
}
