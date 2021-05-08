package org.teamGame.game.entities.creatures.skills;

import org.teamGame.game.Handler;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.game.entities.creatures.weapons.Spell;
import org.teamGame.game.gfx.Assets;
import org.teamGame.sounds.Sound;
import org.teamGame.sounds.SoundPlayer;

public class SpellSkill extends Skill{

    public SpellSkill(Handler handler, int i, Enemy enemy, int order) {
        super(handler, i, enemy, order);

        countDown = 3000;
        timer = 3000;
    }

    public SpellSkill(Handler handler, int i, Player player, int order) {
        super(handler, i, player, order);

        countDown = 3000;
        timer = 3000;
    }

    @Override
    public void attack(){


        timer += System.currentTimeMillis() - lastTimer;
        lastTimer = System.currentTimeMillis();
        if(timer < countDown){
            return;
        }

        if(enemy.checkPlayerZone()){
            handler.getWorld().getEntityManager().addBullet(new Spell(handler, Assets.player_bullet,
                    enemy.getX()+20, enemy.getY()+30, enemy.getAp(), enemy.getDirection()));
            SoundPlayer.PlaySound(Sound.player_fired);
        } else {
            return;
        }

        timer = 0;
    }


}
