package org.teamGame.game.entities.creatures.skills;

import org.teamGame.game.Handler;
import org.teamGame.game.configs.Configs;
import org.teamGame.game.entities.creatures.Creature;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;

public abstract class Skill {

    protected Handler handler;

    //master = 0 => player
    //master = 1 => enemy
    protected int master;

    //countdown
    protected long countDown, timer, lastTimer;

    //position in skill show
    protected int order;

    //used
    public boolean used;
    public int isPlayer;

    //master
    protected Enemy enemy;
    protected Player player;

    public Skill(Handler handler, int isPlayer, Enemy enemy, int order){
        this.handler = handler;
        this.enemy = enemy;
        this.isPlayer= isPlayer;
        this.order = order;
    }

    public Skill(Handler handler, int isPlayer, Player player, int order){
        this.handler = handler;
        this.player = player;

        this.isPlayer = isPlayer;
        this.order = order;
    }

    public abstract void attack();

    public void showCountDown(){
        if(used) {
            long temp = System.currentTimeMillis() - lastTimer;
            if (temp >= countDown) {
                if(order == 1){
                    handler.getGameController().getCoverRec1().setVisible(false);
                    handler.getGameManager().getGameController().getCountDown1().setText("");
                }
                else if(order == 2){
                    handler.getGameController().getCoverRec2().setVisible(false);
                    handler.getGameManager().getGameController().getCountDown2().setText("");
                }else if(order == 3){
                    handler.getGameController().getCoverRec3().setVisible(false);
                    handler.getGameManager().getGameController().getCountDown3().setText("");
                }else if(order == 4){
                    handler.getGameController().getCoverRec4().setVisible(false);
                    handler.getGameManager().getGameController().getCountDown4().setText("");
                }

                used = false;
                return;
            } else {

                switch (order){
                    case 1:
                        handler.getGameManager().getGameController().getCountDown1().setText(String.valueOf((countDown - temp)/1000 + 1));
                        break;
                    case 2:
                        handler.getGameManager().getGameController().getCountDown2().setText(String.valueOf((countDown - temp)/1000 + 1));
                        break;
                    case 3:
                        handler.getGameManager().getGameController().getCountDown3().setText(String.valueOf((countDown - temp)/1000 + 1));
                        break;
                    case 4:
                        handler.getGameManager().getGameController().getCountDown4().setText(String.valueOf((countDown - temp)/1000 + 1));
                        break;
                }

            }
        }
    }



}
