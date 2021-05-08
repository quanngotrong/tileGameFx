package org.teamGame.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.teamGame.StartApp;
import org.teamGame.scene.GameScene;
import org.teamGame.util.HandlerApp;
import org.teamGame.util.Utils;

public class LoadController implements FxController{

    HandlerApp handlerApp;

    //quyết định xem data nào đang được chọn, từ 1 - 9
    private int choseData = 0;

    public LoadController(HandlerApp handlerApp){

        this.handlerApp = handlerApp;

    }

    @FXML
    public Button returnB;

    @FXML
    public Button delete;

    @FXML
    public Button Continue;

    @FXML
    public ImageView loadView1;

    @FXML
    public ImageView loadView2;

    @FXML
    public ImageView loadView3;

    @FXML
    public ImageView loadView4;

    @FXML
    public ImageView loadView5;

    @FXML
    public ImageView loadView6;

    @FXML
    public ImageView loadView7;

    @FXML
    public ImageView loadView8;

    @FXML
    public ImageView loadView9;

    @FXML
    public void initialize(){
        this.returnB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handlerApp.getStage().setScene(handlerApp.getApp().getStartScene().getScene());
            }
        });

        this.loadView1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(StartApp.getSaveData().savedGame.size() >= 2){
                    delete.setVisible(true);
                    Continue.setVisible(true);
                    choseData = 1;
                }else{
                    delete.setVisible(false);
                    Continue.setVisible(false);
                    choseData = 0;
                }
            }
        });

        this.loadView2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(StartApp.getSaveData().savedGame.size() >= 3){
                    delete.setVisible(true);
                    Continue.setVisible(true);
                    choseData = 2;
                }else{
                    delete.setVisible(false);
                    Continue.setVisible(false);
                    choseData = 0;
                }
            }
        });

        this.loadView3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(StartApp.getSaveData().savedGame.size() >= 4){
                    delete.setVisible(true);
                    Continue.setVisible(true);
                    choseData = 3;
                }else{
                    delete.setVisible(false);
                    Continue.setVisible(false);
                    choseData = 0;
                }
            }
        });

        this.loadView4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(StartApp.getSaveData().savedGame.size() >= 5){
                    delete.setVisible(true);
                    Continue.setVisible(true);
                    choseData = 4;
                }else{
                    delete.setVisible(false);
                    Continue.setVisible(false);
                    choseData = 0;
                }
            }
        });

        this.loadView5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(StartApp.getSaveData().savedGame.size() >= 6){
                    delete.setVisible(true);
                    Continue.setVisible(true);
                    choseData = 5;
                }else{
                    delete.setVisible(false);
                    Continue.setVisible(false);
                    choseData = 0;
                }
            }
        });

        this.loadView6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(StartApp.getSaveData().savedGame.size() >= 7){
                    delete.setVisible(true);
                    Continue.setVisible(true);
                    choseData = 6;
                }else{
                    delete.setVisible(false);
                    Continue.setVisible(false);
                    choseData = 0;
                }
            }
        });

        this.loadView7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(StartApp.getSaveData().savedGame.size() >= 8){
                    delete.setVisible(true);
                    Continue.setVisible(true);
                    choseData = 7;
                }else{
                    delete.setVisible(false);
                    Continue.setVisible(false);
                    choseData = 0;
                }
            }
        });

        this.loadView8.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(StartApp.getSaveData().savedGame.size() >= 9){
                    delete.setVisible(true);
                    Continue.setVisible(true);
                    choseData = 8;
                }else{
                    delete.setVisible(false);
                    Continue.setVisible(false);
                    choseData = 0;
                }
            }
        });

        this.loadView9.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(StartApp.getSaveData().savedGame.size() >= 10){
                    delete.setVisible(true);
                    Continue.setVisible(true);
                    choseData = 9;
                }else{
                    delete.setVisible(false);
                    Continue.setVisible(false);
                    choseData = 0;
                }
            }
        });

        this.Continue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameScene gameScene = new GameScene(handlerApp, choseData);
                handlerApp.getStartScene().stopSound();
                //test
                StartApp.getSaveData().savedGame.get(0).setDifficulty(0);

                handlerApp.getStage().setScene(gameScene.getScene());

                handlerApp.getGameManager().start();

                handlerApp.getGameManager().getMyTimer().start();
            }
        });

        this.delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                StartApp.getSaveData().savedGame.remove(choseData);
                handlerApp.getLoadScene().refreshLoadScene();
                Utils.saveData(StartApp.getSaveData());
            }
        });

    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Button getContinue() {
        return Continue;
    }

    public void setContinue(Button aContinue) {
        Continue = aContinue;
    }

    public ImageView getLoadView1() {
        return loadView1;
    }

    public void setLoadView1(ImageView loadView1) {
        this.loadView1 = loadView1;
    }

    public ImageView getLoadView2() {
        return loadView2;
    }

    public void setLoadView2(ImageView loadView2) {
        this.loadView2 = loadView2;
    }

    public ImageView getLoadView3() {
        return loadView3;
    }

    public void setLoadView3(ImageView loadView3) {
        this.loadView3 = loadView3;
    }

    public ImageView getLoadView4() {
        return loadView4;
    }

    public void setLoadView4(ImageView loadView4) {
        this.loadView4 = loadView4;
    }

    public ImageView getLoadView5() {
        return loadView5;
    }

    public void setLoadView5(ImageView loadView5) {
        this.loadView5 = loadView5;
    }

    public ImageView getLoadView6() {
        return loadView6;
    }

    public void setLoadView6(ImageView loadView6) {
        this.loadView6 = loadView6;
    }

    public ImageView getLoadView7() {
        return loadView7;
    }

    public void setLoadView7(ImageView loadView7) {
        this.loadView7 = loadView7;
    }

    public ImageView getLoadView8() {
        return loadView8;
    }

    public void setLoadView8(ImageView loadView8) {
        this.loadView8 = loadView8;
    }

    public ImageView getLoadView9() {
        return loadView9;
    }

    public void setLoadView9(ImageView loadView9) {
        this.loadView9 = loadView9;
    }
}
