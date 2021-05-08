package org.teamGame.game.state;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.teamGame.StartApp;
import org.teamGame.game.Handler;
import org.teamGame.game.configs.Configs;
import org.teamGame.game.entities.EntityManager;
import org.teamGame.game.entities.creatures.*;
import org.teamGame.game.entities.creatures.npc.*;
import org.teamGame.game.gfx.Assets;
import org.teamGame.sounds.Sound;

import org.teamGame.game.worlds.World;

public class GameState {

    Handler handler;

    public MediaPlayer stateSound;

    public static World[] world = new World[5];
    public static EntityManager entityManager;
    public static int playerCurrentHealth;
    public static double playerCurrentSpeed;
    public static int gold = 0;

    public GameState(Handler handler){
        this.handler = handler;

        //load world
        world[1] = new World(handler, "src/main/resources/worlds/world1.txt");
        world[2] = new World(handler, "src/main/resources/worlds/world2.txt");
        world[3] = new World(handler, "src/main/resources/worlds/world3.txt");
        world[4] = new World(handler, "src/main/resources/worlds/world4.txt");
        world[0] = world[1];

        handler.setWorld(world[0], true);

        entityManager = world[0].getEntityManager();

        stateSound = Sound.main;
        handler.getSoundManager().addSound(stateSound);
        stateSound.setCycleCount(MediaPlayer.INDEFINITE);

//        world[1].getEntityManager().addEntity(new Boss(handler, 200, 600));
        //create NPCs
        world[1].getEntityManager().addEntity(new Guard(handler, "Tao có súng\nđây nè...",300, 660));
        world[1].getEntityManager().addEntity(new Guard(handler, 170, 660));
        world[1].getEntityManager().addEntity(new Jack(handler, 500, 760));
        world[1].getEntityManager().addEntity(new Jill(handler, 700, 660));
        world[1].getEntityManager().addEntity(new Monk(handler, 300, 800));
        world[1].getEntityManager().addEntity(new Grandma(handler, 900, 1100));
        world[1].getEntityManager().addEntity(new Farmer(handler, 1200, 950));
        world[1].getEntityManager().addEntity(new BlueHat(handler, 1300, 350));
        world[1].getEntityManager().addEntity(new GreenHair(handler, 1200, 350));
        world[1].getEntityManager().addEntity(new FemaleGuard(handler, 1460, 350));
        world[1].getEntityManager().addEntity(new FemaleGuard(handler, 1460, 500));

        //enemies in world 2
        for(int i = 0; i < 3; ++i){
            world[2].getEntityManager().addEntity(new Skeleton(handler, 550 + 55 * i, 1050, 2));
            world[2].getEntityManager().addEntity(new Slime(handler, 150 + 45 * i, 650, 2));
            world[2].getEntityManager().addEntity(new Skeleton(handler, 150 + 55 * i, 700, 2));

            world[2].getEntityManager().addEntity(new Skeleton(handler, 1200 + 55 * i, 150, 2));
            world[2].getEntityManager().addEntity(new Slime(handler, 1350 + 45 * i, 250, 2));
            world[2].getEntityManager().addEntity(new Skeleton(handler, 1100 + 55 * i, 650, 2));

            world[2].getEntityManager().addEntity(new Skeleton(handler, 750 + 55 * i, 300, 2));
            world[2].getEntityManager().addEntity(new Slime(handler, 900 + 45 * i, 400, 2));
        }

        for(int i = 0; i < 3; ++i){
            world[3].getEntityManager().addEntity(new Skeleton(handler, 550 + 55 * i, 650, 3));
            world[3].getEntityManager().addEntity(new Witch(handler, 150 + 45 * i, 650, 3));
            world[3].getEntityManager().addEntity(new Skeleton(handler, 150 + 55 * i, 700, 3));

            world[3].getEntityManager().addEntity(new Skeleton(handler, 1000 + 55 * i, 450, 3));
            world[3].getEntityManager().addEntity(new Witch(handler, 950 + 45 * i, 400, 3));
            world[3].getEntityManager().addEntity(new Slime(handler, 1100 + 55 * i, 550, 3));

        }

        //enemies in world 4
        world[4].getEntityManager().addEntity(new Boss(handler, 600, 600));

    }

    public void tick() {
        if(!Configs.IS_MUTE)
            stateSound.play();

        world[0].tick();
//        checkPause();
//        checkWin();
    }

    public void checkPause(){

    }

    public void checkWin(){

    }

    public void render(GraphicsContext g){
        world[0].render(g);

        //DRAW gold
        g.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        g.setFill(Color.LAVENDER);
        g.fillRect(Configs.STAGE_WIDTH - 200, 0, 200, 30);
        g.setFill(Color.BLACK);
//        g.fillText("Điểm số: " + Settings.SCORES, Settings.STAGE_WIDTH - 190, 22);
        g.fillText("Gold: " + StartApp.getGold(), Configs.STAGE_WIDTH - 190, 22);
    }
}
