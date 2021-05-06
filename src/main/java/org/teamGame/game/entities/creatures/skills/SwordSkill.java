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

    public static long lastCutTimer, cutCoolDown = Configs.PLAYER_SWORD_COOL_DOWN, cutTimer = cutCoolDown;

    public SwordSkill(Handler handler, int i, Enemy enemy) {
        super(handler, i, enemy);
    }

    public SwordSkill(Handler handler, int i, Player player) {
        super(handler, i, player);
    }

    @Override
    public void attack() {
        cutTimer += System.currentTimeMillis() - lastCutTimer;
        lastCutTimer = System.currentTimeMillis();
        if(cutTimer < cutCoolDown){
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

        cutTimer = 0;
    }
}
