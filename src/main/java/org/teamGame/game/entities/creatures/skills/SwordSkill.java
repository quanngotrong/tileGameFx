package org.teamGame.game.entities.creatures.skills;

import org.teamGame.game.Handler;
import org.teamGame.game.configs.Configs;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.game.entities.creatures.weapons.Sword;
import org.teamGame.game.gfx.Assets;
import org.teamGame.sounds.Sound;
import org.teamGame.sounds.SoundPlayer;

public class SwordSkill extends Skill{


    public SwordSkill(Handler handler, int i, Enemy enemy, int order) {
        super(handler, i, enemy, order);

        countDown = 500;
        timer = countDown;
    }

    public SwordSkill(Handler handler, int i, Player player, int order) {
        super(handler, i, player, order);

        countDown = 500;
        timer = countDown;
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
//        if(handler.getKeyManager().isSpace()){
            if(player.getDirection() ==1) {
                handler.getWorld().getEntityManager().addSword(new Sword(handler, Assets.player_sword1,
                        player.getX()+33 , player.getY()+25 , player.getDamage() + 20, player.getDirection()));}
            if(player.getDirection() ==2) {
                handler.getWorld().getEntityManager().addSword(new Sword(handler, Assets.player_sword2,
                        player.getX()+34, player.getY()+25 , player.getDamage() + 20, player.getDirection()));}
            if(player.getDirection() ==3) {
                handler.getWorld().getEntityManager().addSword(new Sword(handler, Assets.player_sword3,
                        player.getX()+15, player.getY()+37 , player.getDamage() + 20, player.getDirection()));}
            if(player.getDirection() ==4) {
                handler.getWorld().getEntityManager().addSword(new Sword(handler, Assets.player_sword4,
                        player.getX()+15, player.getY()+37 , player.getDamage() + 20, player.getDirection()));}

            SoundPlayer.PlaySound(Sound.player_sword);
//        } else {
//            return;
//        }

        timer = 0;
    }
}
