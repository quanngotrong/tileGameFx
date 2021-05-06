package org.teamGame.game.entities.creatures.skills;

import org.teamGame.game.Handler;
import org.teamGame.game.entities.creatures.Creature;

public abstract class Skill {

    private Handler handler;

    //master = 0 => player
    //master = 1 => enemy
    private int master;

    public Skill(Handler handler, int i){

    }

}
