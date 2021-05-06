package org.teamGame.game.entities.creatures.skills;

import org.teamGame.game.Handler;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.game.entities.creatures.weapons.Spell;
import org.teamGame.game.gfx.Assets;
import org.teamGame.sounds.Sound;
import org.teamGame.sounds.SoundPlayer;

public class SpellSkill extends Skill{

    public  long lastSpellTimer, spellCoolDown = 3000, spellTimer = spellCoolDown;

    public SpellSkill(Handler handler, int i, Enemy enemy) {
        super(handler, i, enemy);
    }

    public SpellSkill(Handler handler, int i, Player player) {
        super(handler, i, player);
    }

    @Override
    public void attack(){
        spellTimer += System.currentTimeMillis() - lastSpellTimer;
        lastSpellTimer = System.currentTimeMillis();
        if(spellTimer < spellCoolDown){
            return;
        }

        if(enemy.getDirection() < 300*300){
            handler.getWorld().getEntityManager().addBullet(new Spell(handler, Assets.player_bullet,
                    enemy.getX()+20, enemy.getY()+30, enemy.getAp(), enemy.getDirection()));
            SoundPlayer.PlaySound(Sound.player_fired);
        } else {
            return;
        }

        spellTimer = 0;
    }

}
