package org.teamGame.game.worlds;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.teamGame.StartApp;
import org.teamGame.game.Handler;
import org.teamGame.game.configs.Configs;
import org.teamGame.game.entities.EntityManager;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.game.gfx.Assets;
import org.teamGame.game.items.ItemManager;
import org.teamGame.game.maps.Tile;
import org.teamGame.util.Utils;

public class World {
    //width and height of world
    private int width, height;

    //position
    private int spawnXNext;
    private int spawnYNext;
    private int spawnXPre;
    private int spawnYPre;
    private int spawnX;
    private int spawnY;
    private int layer = 3;

    //current world
    private int countWorld;
    private int[][][] tiles;

    //Entities
    private EntityManager entityManager;
    private Handler handler;
    private int enemyOnBoard = 0;

    //Items
    private ItemManager itemManager;

    //Player
    private Image player;

    public World(Handler handler, String path){
        this.handler = handler;

        loadWorld(path);
        if(handler.isTele()){
            spawnX = spawnXNext;
            spawnY = spawnYNext;
        }else{
            spawnX = spawnXPre;
            spawnY = spawnYPre;
        }

        //choose player
        int saved = handler.getGameManager().getSaved();
        int character = StartApp.getSaveData().savedGame.get(saved).getCharacter();

        if(character == 0){
            entityManager = new EntityManager(handler, new Player(handler, spawnX, spawnY, Configs.PLAYER_SWORD_DAMAGE));
        }
        else if(character == 1){//monk
            entityManager = new EntityManager(handler, new Player(handler, Assets.male_npcs,
                    spawnX, spawnY, 0, 264, 462, 264, 330, 396, Configs.PLAYER_SWORD_DAMAGE));
        }else if(character == 2){//jill
            entityManager = new EntityManager(handler, new Player(handler, Assets.female_npcs,
                    spawnX, spawnY,  0, 0, 196, 0, 66, 132, Configs.PLAYER_SWORD_DAMAGE));
        }else if(character == 3){//jack
            entityManager = new EntityManager(handler, new Player(handler, Assets.male_npcs,
                    spawnX, spawnY,  0, 0, 196, 0, 66, 132, Configs.PLAYER_SWORD_DAMAGE));
        }else if(character == 4){//guard
            entityManager = new EntityManager(handler, new Player(handler, Assets.male_npcs,
                    spawnX, spawnY,  264, 0, 196, 0, 66, 132, Configs.PLAYER_SWORD_DAMAGE));
        }else if(character == 5){//greenhair
            entityManager = new EntityManager(handler, new Player(handler, Assets.children_npcs,
                    spawnX, spawnY, 0, 0, 196, 0, 66, 132, Configs.PLAYER_SWORD_DAMAGE));
        }else if(character == 6){//grandma
            entityManager = new EntityManager(handler, new Player(handler, Assets.female_npcs,
                    spawnX, spawnY, 132, 0, 196, 0, 66, 132, Configs.PLAYER_SWORD_DAMAGE));
        }else if(character == 7){//femaleguard
            entityManager = new EntityManager(handler, new Player(handler, Assets.female_npcs,
                    spawnX, spawnY, 264, 0, 196, 0, 66, 132, Configs.PLAYER_SWORD_DAMAGE));
        }else if(character == 8){//farmer
            entityManager = new EntityManager(handler, new Player(handler, Assets.male_npcs,
                    spawnX, spawnY, 132, 0, 196, 0, 66, 132, Configs.PLAYER_SWORD_DAMAGE));
        }else if(character == 9){//bluehat
            entityManager = new EntityManager(handler, new Player(handler, Assets.children_npcs,
                    spawnX, spawnY, 264, 0, 196, 0, 66, 132, Configs.PLAYER_SWORD_DAMAGE));
        }

        itemManager = new ItemManager(handler);
    }

    public void tick(){
        itemManager.tick();
        entityManager.tick();
    }

    public void render(GraphicsContext g){
        int xStart = (int) (Math.max(0, handler.getGameCamera().getxOffset() / Configs.TILE_WIDTH));
        int xEnd = (int) (Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Configs.TILE_WIDTH + 1));
        int yStart = (int) (Math.max(0, handler.getGameCamera().getyOffset() / Configs.TILE_HEIGHT));
        int yEnd = (int) (Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Configs.TILE_HEIGHT + 1));

        for(int z = 0; z< layer; z++) {
            for (int y = yStart; y < yEnd; y++) {
                for (int x = xStart; x < xEnd; x++) {

                    getTile(x, y, z).render(g, (int) (x * Configs.TILE_WIDTH - handler.getGameCamera().getxOffset()),
                            (int) (y * Configs.TILE_HEIGHT - handler.getGameCamera().getyOffset()));

                }
            }
        }
        itemManager.render(g);
        entityManager.render(g);
    }

    public Tile getTile(int x, int y, int z){
        if(x < 0 || y < 0 || x >= width || y >= height){
            return Tile.rockTile;
        }
        Tile t = Tile.tiles[tiles[x][y][z]];
        if(t == null)
            return Tile.clear;
        return t;
    }
    public void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnXNext = Utils.parseInt(tokens[2]);
        spawnYNext = Utils.parseInt(tokens[3]);
        spawnXPre = Utils.parseInt(tokens[4]);
        spawnYPre = Utils.parseInt(tokens[5]);
        countWorld = Utils.parseInt(tokens[6]);
        layer = Utils.parseInt(tokens[7]);

        tiles = new int[width][height][layer];

        for(int z = 0; z < layer; z++) {
            for (int j = 0; j < height; j++) {
                for (int i = 0; i < width; i++) {
                    tiles[i][j][z] = Utils.parseInt(tokens[width*height*z + i + j * width + 8]);
                }
            }
        }
    }

    //getter and setter
    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public int getEnemyOnBoard() {
        return enemyOnBoard;
    }

    public void setEnemyOnBoard(int enemyOnBoard) {
        this.enemyOnBoard = enemyOnBoard;
    }

    public Image getPlayer() {
        return player;
    }

    public void setPlayer(Image player) {
        this.player = player;
    }

    public int[][][] getTiles() {
        return tiles;
    }

    public void setTiles(int[][][] tiles) {
        this.tiles = tiles;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpawnXNext() {
        return spawnXNext;
    }

    public void setSpawnXNext(int spawnXNext) {
        this.spawnXNext = spawnXNext;
    }

    public int getSpawnYNext() {
        return spawnYNext;
    }

    public void setSpawnYNext(int spawnYNext) {
        this.spawnYNext = spawnYNext;
    }

    public int getSpawnXPre() {
        return spawnXPre;
    }

    public void setSpawnXPre(int spawnXPre) {
        this.spawnXPre = spawnXPre;
    }

    public int getSpawnYPre() {
        return spawnYPre;
    }

    public void setSpawnYPre(int spawnYPre) {
        this.spawnYPre = spawnYPre;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
    }

    public int getCountWorld() {
        return countWorld;
    }

    public void setCountWorld(int countWorld) {
        this.countWorld = countWorld;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }
}
