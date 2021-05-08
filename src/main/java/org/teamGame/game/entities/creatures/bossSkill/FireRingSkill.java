package org.teamGame.game.entities.creatures.bossSkill;

import org.teamGame.game.Handler;
import org.teamGame.game.entities.creatures.Boss;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.game.entities.creatures.skills.Skill;
import org.teamGame.game.entities.creatures.weapons.FireRing;
import org.teamGame.game.entities.creatures.weapons.Spell;
import org.teamGame.game.gfx.Assets;
import org.teamGame.sounds.Sound;
import org.teamGame.sounds.SoundPlayer;

public class FireRingSkill extends Skill {

    public FireRingSkill(Handler handler, int i, Enemy enemy, int order) {
        super(handler, i, enemy, order);

        countDown = 5000;
        timer = 5000;
    }

    public FireRingSkill(Handler handler, int i, Player player, int order) {
        super(handler, i, player, order);

        countDown = 5000;
        timer = 5000;
    }

    @Override
    public void attack() {
        if(used && isPlayer == 1){
            return;
        }

        timer += System.currentTimeMillis() - lastTimer;
        lastTimer = System.currentTimeMillis();
        if(timer < countDown){
            return;
        }

        if(enemy.getDirection() < 1000*1000){
            handler.getWorld().getEntityManager().addFireRing(new FireRing(handler, 3, enemy, isPlayer));
//            SoundPlayer.PlaySound(Sound.player_fired);
        } else {
            return;
        }

        timer = 0;
    }
}
