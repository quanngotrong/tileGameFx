package org.teamGame.game.entities.creatures.skills;

import org.teamGame.game.Handler;
import org.teamGame.game.entities.Entity;
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
        if(used && isPlayer == 1){
            return;
        }

        timer += System.currentTimeMillis() - lastTimer;
        lastTimer = System.currentTimeMillis();
        if(timer < countDown){
            return;
        }

        if(isPlayer == 0) {
            if (enemy.checkPlayerZone()) {
                handler.getWorld().getEntityManager().addBullet(new Spell(handler, Assets.player_bullet,
                        enemy.getX() + 20, enemy.getY() + 30, enemy.getAp(), enemy.getDirection(),handler.getWorld().getEntityManager().getPlayer(), 7));
                SoundPlayer.PlaySound(Sound.player_fired);
            } else {
                return;
            }
        }

        if(isPlayer == 1){
            double enemyX;
            double enemyY;
            double playerX = handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0).getX();
            double playerY = handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0).getY();
            double distance;

            for(Entity e : handler.getWorld().getEntityManager().getEntities()){
                if(e.equals(handler.getWorld().getEntityManager().getPlayer())){
                    continue;

                }else if(e.getIsPlayer() == 2) {
                    enemyX = e.getCollisionBounds(0,0).getX();
                    enemyY = e.getCollisionBounds(0,0).getY();
                    distance = (enemyX - playerX)*(enemyX - playerX) + (enemyY - playerY)*(enemyY - playerY);
                    if(distance <= 300 * 300){
                        handler.getWorld().getEntityManager().addBullet(new Spell(handler, Assets.player_bullet,
                                player.getX() + 20, player.getY() + 30, player.getAp(), player.getDirection(),e, 10));
                        SoundPlayer.PlaySound(Sound.player_fired);
                    }
                }
            }

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
        }



        timer = 0;
    }


}
