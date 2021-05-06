package org.teamGame.game.entities.creatures.skills;

import org.teamGame.game.Handler;
import org.teamGame.game.entities.creatures.Creature;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;

public abstract class Skill {

    protected Handler handler;

    //master = 0 => player
    //master = 1 => enemy
    private int master;

    //countdown
    private int countdown;

    //master
    Enemy enemy;
    Player player;

    public Skill(Handler handler, int i, Enemy enemy){
        this.handler = handler;
        this.enemy = enemy;
    }

    public Skill(Handler handler, int i, Player player){
        this.handler = handler;
        this.player = player;
    }

    public abstract void attack();

}
