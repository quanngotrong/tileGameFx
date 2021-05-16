package org.teamGame.game.entities.creatures.weapons;

import javafx.scene.image.Image;
import org.teamGame.game.Handler;
import org.teamGame.game.entities.Entity;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.sounds.SoundPlayer;

public class Spell extends Bullet{
//    private int isPlayer;
//    private Enemy enemy;
    private Entity entity;

    public Spell(Handler handler, Image image, double x, double y, int damage, int direction, Entity entity, int speed) {
        super(handler, image, x, y, damage, direction);
//        setSpeed(6);
//        isPlayer = 0;
        this.speed = speed;
        this.entity = entity;
    }

//    public Spell(Handler handler, Image image, double x, double y, int damage, int direction, Enemy enemy) {
//        super(handler, image, x, y, damage, direction);
//        setSpeed(6);
//        isPlayer = 1;
//        this.enemy = enemy;
//    }

    @Override
    public void checkHit(){
//        if(isPlayer == 0){
        //Enemy hit
//        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
//            if(!e.equals(handler.getWorld().getEntityManager().getPlayer()))
//                continue;
//            if(e.getCollisionBounds(0, 0).intersects(getCollisionBounds(0,0).getBoundsInLocal())){
//                e.takeDamage(damage);
//                SoundPlayer.PlaySound(mediaPlayer);
//                die();
//            }
//        }

        if(this.entity.getCollisionBounds(0,0).intersects(getCollisionBounds(0,0).getBoundsInLocal())){
            this.entity.takeDamage(damage);
            SoundPlayer.PlaySound(mediaPlayer);
            die();
        }

        //Bullet move
        if(Math.abs(xLong) > 500 || Math.abs(yLong) > 500)
            die();
    }

    @Override
    public void cut(){
        xMove = 0;
        yMove = 0;

//        if(y > handler.getWorld().getEntityManager().getPlayer().getY() + 25){ //up
//            direction = 1;
//            yMove = -speed;
//        }
//        if(y < handler.getWorld().getEntityManager().getPlayer().getY() + 25){ //down
//            direction = 2;
//            yMove = speed;
//        }
//        if(x < handler.getWorld().getEntityManager().getPlayer().getX() + 25){ //right
//            direction = 4;
//            xMove = speed;
//        }
//        if(x > handler.getWorld().getEntityManager().getPlayer().getX() + 25){ //left
//            direction = 3;
//            xMove = -speed;
//        }
        if(y > entity.getY() + 25){ //up
            direction = 1;
            yMove = -speed;
        }
        if(y < entity.getY() + 25){ //down
            direction = 2;
            yMove = speed;
        }
        if(x < entity.getX() + 25){ //right
            direction = 4;
            xMove = speed;
        }
        if(x > entity.getX() + 25){ //left
            direction = 3;
            xMove = -speed;
        }
    }


}
