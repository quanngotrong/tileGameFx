package org.teamGame.game.gfx;

import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class Assets {
    public static Font font28;
    public static Font font20;

    private static final int width = 32, height = 32;
    public static Image icon, dirt, grass, stone, skeleton, player, witch;
    public static Image checkpoint, clear, easy, medium, hard, difficultState, creditsState;
    public static Image[] tree = new Image[13];
    public static Image[][] map1 = new Image[30][30];
    public static Image[][] map2 = new Image[30][30];
    public static Image[][] map3 = new Image[30][30];
    public static Image[][] map4 = new Image[30][30];
    public static Image background, gameover, pause, victory;
    public static Image start, exit, mute_unmute, restart, main_menu, back, credits, resume;


    public static Image[] slime_up, slime_down, slime_left, slime_right;
    public static Image talk;

    //boss
    public static Image bossblue;
    public static Image firebreath;
    public static Image energyBall;
    public static Image energyBall1;
    public static Image energyBall2;
    public static Image energyBall3;
    public static Image energyBall4;

    //item
    public static Image lotionMana, lotionHP, lotionDamage;

    //inventory
    public static Image inventoryScreen;

    public static Image player_bullet;

    //chuong
    public static Image player_ball1,player_ball2,player_ball3,player_ball4;
    public static Image player_sword1,player_sword2,player_sword3,player_sword4;

    //npc
    public static Image male_npcs, female_npcs, children_npcs;

    public static void init(){
        //boss
        bossblue = ImageLoader.loadImage("/textures/bossblue.png");
        firebreath = ImageLoader.loadImage("/textures/boss/fireball3.png");
        energyBall = ImageLoader.loadImage("/textures/boss/energyBall.png");
        SpriteSheet e = new SpriteSheet(energyBall);
        energyBall1 = e.crop(0,0,182,206);
        energyBall2 = e.crop(182 * 1,0,182,206);
        energyBall3 = e.crop(182 * 2,0,182,206);
        energyBall4 = e.crop(182 * 3,0,182,206);

        //inventory
        inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");

//        //load font
        font28 = FontLoader.loadFont("/fonts/slkscr.ttf",28);
        font20 = FontLoader.loadFont("/fonts/slkscr.ttf",20);

        //load icon
        icon = ImageLoader.loadImage("/textures/icon.png");

        //load talk
        talk = ImageLoader.loadImage("/textures/talk.png", 42, 42);

        SpriteSheet crystal_clear = new SpriteSheet(ImageLoader.loadImage("/textures/BladeY.png"));
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        for(int i=0; i<=12; i++){
            tree[i] = ImageLoader.loadImage("/textures/tree/tree (" + i + ").png");
        }

        // map
        SpriteSheet teleport = new SpriteSheet(ImageLoader.loadImage("/textures/Teleport.png"));
        SpriteSheet map_1 = new SpriteSheet(ImageLoader.loadImage("/textures/Map1.png"));
        SpriteSheet map_2 = new SpriteSheet(ImageLoader.loadImage("/textures/Map2.png"));
        SpriteSheet map_3 = new SpriteSheet(ImageLoader.loadImage("/textures/Map3.png"));
        SpriteSheet map_4 = new SpriteSheet(ImageLoader.loadImage("/textures/Map4.png"));

        for(int i = 0; i<20; i++){
            for(int j = 0; j<25; j++){
                map1[j][i] = map_1.crop(width*j, height*i, width, height);
                map2[j][i] = map_2.crop(width*j, height*i, width, height);
                map3[j][i] = map_3.crop(width*j, height*i, width, height);
                map4[j][i] = map_4.crop(width*j, height*i, width, height);
            }
        }

        clear = crystal_clear.crop(0, 0, width, height);

        //bo
        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        stone = sheet.crop(width * 3, 0, width, height);

        skeleton = ImageLoader.loadImage("/textures/skeleton.png");
        player = ImageLoader.loadImage("/textures/player.png");
        witch = ImageLoader.loadImage("/textures/witch.png");

        //checkpoint
        checkpoint = teleport.crop(40, 180, 430, 430);

        //bullet
        player_bullet = ImageLoader.loadImage("/textures/player_bullet.png");
        //chuong
        SpriteSheet energyBall = new SpriteSheet(ImageLoader.loadImage("/textures/energy_ball.png"));
        player_ball1 = energyBall.crop(0, height,width , height);
        player_ball2 = energyBall.crop(0, 0,width, height);
        player_ball3 = energyBall.crop(width , 0,width , height );
        player_ball4 = energyBall.crop(width , height ,width  , height);

        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/player_sword.png"));
        player_sword1 = sheet3.crop(width/3, 0,width/3 , height+13);
        player_sword2 = sheet3.crop(0, 0,width/3 , height+13);
        player_sword3 = sheet3.crop(0, height+24,width+13 , height/3);
        player_sword4 = sheet3.crop(0, height+13,width+13 , height/3);

        // bo
//        start = ImageLoader.loadImage("/textures/start_button.png");
//        exit = ImageLoader.loadImage("/textures/exit_button.png");
//        mute_unmute = ImageLoader.loadImage("/textures/mute_unmute.png");
//        restart = ImageLoader.loadImage("/textures/restart_button.png");
//        main_menu = ImageLoader.loadImage("/textures/menu_button.png");
//        back = ImageLoader.loadImage("/textures/back_button.png");
//        credits = ImageLoader.loadImage("/textures/credits_button.png");
//        resume = ImageLoader.loadImage("/textures/resume_button.png");
//
//        background = ImageLoader.loadImage("/textures/background.png");
//        gameover = ImageLoader.loadImage("/textures/gameover.jpg");
//        pause = ImageLoader.loadImage("/textures/pause.jpg");
//        victory = ImageLoader.loadImage("/textures/victory.jpg");
        // bo


        //slime move
        slime_up = new Image[4];
        for(int i = 0; i < 4; i++)
            slime_up[i] = ImageLoader.loadImage("/textures/slime/SlimeUp_" + i + ".png");

        slime_down = new Image[4];
        for(int i = 0; i < 4; i++)
            slime_down[i] = ImageLoader.loadImage("/textures/slime/SlimeDown_" + i + ".png");

        slime_left = new Image[4];
        for(int i = 0; i < 4; i++)
            slime_left[i] = ImageLoader.loadImage("/textures/slime/SlimeLeft_" + i + ".png");
        slime_right = new Image[4];
        for(int i = 0; i < 4; i++)
            slime_right[i] = ImageLoader.loadImage("/textures/slime/SlimeRight_" + i + ".png");

        //item
        SpriteSheet sheet_item = new SpriteSheet(ImageLoader.loadImage("/textures/items4x.png"));
        lotionMana = sheet_item.crop(64 * 3, 0, 64, 64);
        lotionHP = sheet_item.crop(64 * 4, 0, 64, 64);
        lotionDamage = sheet_item.crop(64 * 5, 0, 64, 64);

        //NPCs
        male_npcs = ImageLoader.loadImage("/textures/male_npcs.png", 528, 528);
        female_npcs = ImageLoader.loadImage("/textures/female_npcs.png", 528, 528);
        children_npcs = ImageLoader.loadImage("/textures/children_npcs.png", 528, 528);
    }
}
