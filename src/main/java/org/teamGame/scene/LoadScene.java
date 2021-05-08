package org.teamGame.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.StartApp;
import org.teamGame.controller.LoadController;
import org.teamGame.game.configs.Configs;
import org.teamGame.game.gfx.Assets;
import org.teamGame.sounds.Sound;
import org.teamGame.util.HandlerApp;
import org.teamGame.util.Utils;

import java.io.IOException;

public class LoadScene extends SceneFx{
    LoadController loadController;

    public LoadScene(HandlerApp handlerApp) {
        super(handlerApp, "LoadScene");

        //music
        sceneSound = Sound.uchiha;
        handlerApp.getSoundManager().addSound(sceneSound);
//        if(!Configs.IS_MUTE)
//            sceneSound.play();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+ fxml+ ".fxml"));
        loadController = new LoadController(handlerApp);
        fxmlLoader.setController(loadController);

        AnchorPane root = null;
        try {
            root = (AnchorPane)fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root, 800, 600);

    }

    //refresh saved data scene
    public void refreshLoadScene(){
        int count = StartApp.getSaveData().savedGame.size();

        if(count >= 2){
            loadController.getLoadView1().setImage(Utils.chooseCharacter( StartApp.getSaveData().savedGame.get(1).getCharacter()));

        }else{
            loadController.getLoadView1().setImage(Assets.lock);
        }
        if(count >= 3){
            loadController.getLoadView2().setImage(Utils.chooseCharacter( StartApp.getSaveData().savedGame.get(2).getCharacter()));
        }else{
            loadController.getLoadView2().setImage(Assets.lock);
        }
        if(count >= 4){
            loadController.getLoadView3().setImage(Utils.chooseCharacter( StartApp.getSaveData().savedGame.get(3).getCharacter()));
        }else{
            loadController.getLoadView3().setImage(Assets.lock);
        }
        if(count >= 5){
            loadController.getLoadView4().setImage(Utils.chooseCharacter( StartApp.getSaveData().savedGame.get(4).getCharacter()));
        }else{
            loadController.getLoadView4().setImage(Assets.lock);
        }
        if(count >= 6){
            loadController.getLoadView5().setImage(Utils.chooseCharacter( StartApp.getSaveData().savedGame.get(5).getCharacter()));
        }else{
            loadController.getLoadView5().setImage(Assets.lock);
        }
        if(count >= 7){
            loadController.getLoadView6().setImage(Utils.chooseCharacter( StartApp.getSaveData().savedGame.get(6).getCharacter()));
        }else{
            loadController.getLoadView6().setImage(Assets.lock);
        }
        if(count >= 8){
            loadController.getLoadView7().setImage(Utils.chooseCharacter( StartApp.getSaveData().savedGame.get(7).getCharacter()));
        }else{
            loadController.getLoadView7().setImage(Assets.lock);
        }
        if(count >= 9){
            loadController.getLoadView8().setImage(Utils.chooseCharacter( StartApp.getSaveData().savedGame.get(8).getCharacter()));
        }else{
            loadController.getLoadView8().setImage(Assets.lock);


        }
        if(count >= 10){
            loadController.getLoadView9().setImage(Utils.chooseCharacter( StartApp.getSaveData().savedGame.get(9).getCharacter()));
        }else{
            loadController.getLoadView9().setImage(Assets.lock);

        }

    }
}
