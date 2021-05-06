package org.teamGame.game.entities.creatures.skills;

import org.teamGame.game.Handler;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.game.entities.creatures.weapons.Bullet;
import org.teamGame.game.gfx.Assets;
import org.teamGame.sounds.Sound;
import org.teamGame.sounds.SoundPlayer;

public class BulletSkill extends Skill{

    public  long lastSpellTimer, spellCoolDown = 3000, spellTimer = spellCoolDown;

    public BulletSkill(Handler handler, int i, Enemy enemy) {
        super(handler, i, enemy);
    }

    public BulletSkill(Handler handler, int i, Player player) {
        super(handler, i, player);
    }

    @Override
    public void attack() {
        spellTimer += System.currentTimeMillis() - lastSpellTimer;
        lastSpellTimer = System.currentTimeMillis();
        if(spellTimer < spellCoolDown){
            return;
        }

//        if(handler.getKeyManager().isSpell()){
            if(player.getDirection()==1) {
                handler.getWorld().getEntityManager().addBullet(new Bullet(handler, Assets.player_ball1,
                        player.getX()+20 , player.getY()+30 , player.getAp() * 2, player.getDirection()));}
            if(player.getDirection() ==2) {
                handler.getWorld().getEntityManager().addBullet(new Bullet(handler, Assets.player_ball2,
                        player.getX()+20, player.getY()+35 , player.getAp() * 2 , player.getDirection()));}
            if(player.getDirection() ==3) {
                handler.getWorld().getEntityManager().addBullet(new Bullet(handler, Assets.player_ball3,
                        player.getX()+22, player.getY()+30 , player.getAp() * 2 , player.getDirection()));}
            if(player.getDirection() ==4) {
                handler.getWorld().getEntityManager().addBullet(new Bullet(handler, Assets.player_ball4,
                        player.getX()+35, player.getY()+30 , player.getAp() * 2, player.getDirection()));}

            SoundPlayer.PlaySound(Sound.player_fired);
//        } else {
//            return;
//        }

        spellTimer = 0;
    }
}
