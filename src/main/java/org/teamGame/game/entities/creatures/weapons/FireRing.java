package org.teamGame.game.entities.creatures.weapons;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.teamGame.game.Handler;
import org.teamGame.game.entities.Entity;
import org.teamGame.game.entities.creatures.Boss;
import org.teamGame.game.entities.creatures.Creature;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.game.gfx.Assets;
import org.teamGame.sounds.SoundPlayer;

public class FireRing extends Creature {

    private Enemy masterE;
    private Player masterP;

    private int isPlayer;

    private long startTime;
    private long countDown = 3500;

//    public FireRing(Handler handler, int damage,  Enemy master) {
//        super(handler, Assets.fireRing, master.getX(), master.getY(), master.getWidth(), master.getHeight(), damage);
//        this.masterE = master;
//        this.isPlayer = 0;
//        startTime = System.currentTimeMillis();
//    }

    public FireRing(Handler handler, int damage,  Enemy master, int isPlayer) {
        super(handler, Assets.fireRing, master.getX() , master.getY(), master.getWidth(), master.getHeight(), damage);
        this.masterE = master;
        this.isPlayer = isPlayer;
        startTime = System.currentTimeMillis();

        if(isPlayer == 0){
            this.width *= 6;
            this.height *= 6;
        }

        bounds.setX(100);
        bounds.setY(100);
        bounds.setHeight(620);
        bounds.setWidth(620);
    }

//    public FireRing(Handler handler, Image image, double x, double y, int width, int height, int damage,  Player master) {
//        super(handler, Assets.fireRing, x, y, width, height, damage);
//        this.masterP = master;
//        this.isPlayer = 1;
//        startTime = System.currentTimeMillis();
//
//    }

    @Override
    public void tick() {
        checkAttack();
        if(System.currentTimeMillis() - startTime >= countDown){
            die();
        }
    }

    public void checkAttack(){

        x= masterE.getX() - width/4;
        y= masterE.getY() - height/4;
        if(isPlayer == 0){
            if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0)
                    .intersects(getCollisionBounds(0,0).getBoundsInLocal())){
                handler.getWorld().getEntityManager().getPlayer().takeDamage(10);
                System.out.println(damage);
            }
            System.out.println(x +" " + y+ " " + bounds.getHeight()+" "+ bounds.getWidth());

//            for(Entity e : handler.getWorld().getEntityManager().getEntities()){
//                if(!e.equals(handler.getWorld().getEntityManager().getPlayer()))
//                    continue;
//                if(e.getCollisionBounds(0, 0).intersects(getCollisionBounds(0,0).getBoundsInLocal())){
//                    e.takeDamage(damage);
//                    System.out.println("ha");
//                }
//            }

        }
    }

    @Override
    public void render(GraphicsContext g) {
        g.drawImage(image, masterE.getX()- handler.getGameCamera().getxOffset()-width/4,
                masterE.getY()- handler.getGameCamera().getyOffset()-height/4, width,height);

    }

    @Override
    public void die() {
        active = false;
    }


    @Override
    protected boolean collisionWithTile(int x, int y){
//        for(int z = 0; z<handler.getWorld().getLayer(); z++) {
//            if(handler.getWorld().getTile(x, y, z).isSolid()){
//                return true;
//            }
//        }
        return false;
    }

}
