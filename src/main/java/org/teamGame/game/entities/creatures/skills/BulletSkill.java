package org.teamGame.game.entities.creatures.skills;

import org.teamGame.game.Handler;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.game.entities.creatures.weapons.Bullet;
import org.teamGame.game.gfx.Assets;
import org.teamGame.sounds.Sound;
import org.teamGame.sounds.SoundPlayer;

public class BulletSkill extends Skill{

    public BulletSkill(Handler handler, int i, Enemy enemy, int order) {
        super(handler, i, enemy, order);

        countDown = 3000;
        timer = 3000;
    }

    public BulletSkill(Handler handler, int i, Player player, int order) {
        super(handler, i, player, order);

        countDown = 3000;
        timer = 3000;
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

        if(order == 1){
            handler.getGameController().getCoverRec1().setVisible(true);
        }
        else if(order == 2){
            handler.getGameController().getCoverRec2().setVisible(true);
        }else if(order == 3){
            handler.getGameController().getCoverRec3().setVisible(true);
        }else if(order == 4){
            handler.getGameController().getCoverRec4().setVisible(true);
        }

        used = true;

        timer = 0;
    }
}
