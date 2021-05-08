package org.teamGame.game.entities;

import javafx.scene.canvas.GraphicsContext;
import org.teamGame.game.Handler;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.game.entities.creatures.bossSkill.energyBall;
import org.teamGame.game.entities.creatures.weapons.Bullet;
import org.teamGame.game.entities.creatures.weapons.FireRing;
import org.teamGame.game.entities.creatures.weapons.Sword;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    private ArrayList<Bullet> bullets;
    private ArrayList<Sword> swords;
    private ArrayList<Entity> temp;
    private ArrayList<FireRing> fireRings;

    private ArrayList<energyBall> fire;

    private Iterator i, j, t, eb, fr;

    private Comparator<Entity> renderSort = Comparator.comparingDouble(a -> a.getY() + a.getHeight());

    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
        bullets = new ArrayList<>();
        swords = new ArrayList<>();
        fire = new ArrayList<>();
        temp = new ArrayList<>();
        fireRings = new ArrayList<>();
        addEntity(player);
    }

    public void tick(){
        i = entities.iterator();
        while(i.hasNext()){
            Entity e = (Entity) i.next();
            e.tick();

            if(!e.isActive())
                i.remove();

        }
        entities.addAll(temp);
        entities.sort(renderSort);
        temp.removeAll(temp);

        j = bullets.iterator();
        while(j.hasNext()){
            Bullet bullet = (Bullet) j.next();
            bullet.tick();

            if(!bullet.isActive())
                j.remove();
        }

        t = swords.iterator();
        while(t.hasNext()){
            Sword sword = (Sword) t.next();
            sword.tick();
            if(!sword.isActive()){
                t.remove();
            }
        }

        eb = fire.iterator();
        while(eb.hasNext()){
            energyBall energyB = (energyBall) eb.next();
            energyB.tick();
            if(!energyB.isActive()){
                eb.remove();
            }
        }

        fr = fireRings.iterator();
        while(fr.hasNext()){
            FireRing fireRing = (FireRing) fr.next();
            fireRing.tick();
            if(!fireRing.isActive()){
                fr.remove();
            }
        }
    }

    public void render(GraphicsContext g){
        for(Entity e: entities){
            e.render(g);
        }

        for(Bullet b : bullets){
            b.render(g);
        }
        for(Sword s : swords ){
            s.render(g);
        }
        for(energyBall eb : fire){
            eb.render(g);
        }
        for(FireRing fr : fireRings){
            fr.render(g);
        }
        player.postRender(g);

    }

    public void addFireRing(FireRing fr){
        fireRings.add(fr);
    }
    public void addEntity(Entity e){
        temp.add(e);
    }
    public void addBullet(Bullet b) {
        bullets.add(b);
    }
    public void addSword(Sword s){
        swords.add(s);
    }
    public void removePlayer(Player player){
        entities.remove(player);
    }
    public void addEnergyBall(energyBall eb){
        fire.add(eb);
    }

    //Getters & Setters
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
        addEntity(player);
    }


    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public ArrayList<Bullet> getBullets(){
        return bullets;
    }

    public ArrayList<Sword> getSwords(){
        return swords;
    }
}
