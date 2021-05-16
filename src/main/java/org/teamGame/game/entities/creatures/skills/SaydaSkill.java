package org.teamGame.game.entities.creatures.skills;

import org.teamGame.game.Handler;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;

public class SaydaSkill extends Skill{
    public SaydaSkill(Handler handler, int isPlayer, Enemy enemy, int order) {
        super(handler, isPlayer, enemy, order);

        countDown = 4000;
        timer = 4000;
    }

    public SaydaSkill(Handler handler, int isPlayer, Player player, int order) {
        super(handler, isPlayer, player, order);

        countDown = 4000;
        timer = 4000;
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

        player.setDefence(player.getDefence()+ 15);
        player.setDamage(player.getDamage() + 40);
        player.setSpeed(player.getSpeed() + 10);
        player.setAp(player.getAp() + 40);
        player.showProperty();

        player.setSayda(true);
        player.setLastSayda(System.currentTimeMillis());

        used = true;

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

        timer = 0;
    }
}
