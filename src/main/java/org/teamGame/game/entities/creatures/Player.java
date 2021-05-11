package org.teamGame.game.entities.creatures;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.teamGame.StartApp;
import org.teamGame.game.Handler;
import org.teamGame.game.configs.Configs;
import org.teamGame.game.entities.Entity;
import org.teamGame.game.entities.creatures.skills.SkillManager;
import org.teamGame.game.entities.creatures.weapons.Bullet;
import org.teamGame.game.entities.creatures.weapons.Sword;
import org.teamGame.game.gfx.Assets;
import org.teamGame.game.gfx.SpriteAnimation;
import org.teamGame.game.inventory.Inventory;
import org.teamGame.game.items.Item;
import org.teamGame.game.state.GameState;
import org.teamGame.save.SaveDataGame;
import org.teamGame.sounds.Sound;
import org.teamGame.sounds.SoundPlayer;

public class Player extends Creature {

    protected int count;
    protected int columns;
    protected int offsetX;
    protected int offsetY;
    protected int width;
    protected int height;

    protected boolean tele;
    protected SpriteAnimation animation;
    protected Image player;

    //character
    protected int character;

    //level
    protected int level;

    //neu khong phai la character 0
    //skin
    int offsetUp, offsetDown, offsetLeft, offsetRight;

    //Attack Timer
    protected long lastAttackTimer, attackCoolDown = Configs.PLAYER_SWORD_COOL_DOWN, attackTimer = attackCoolDown;
    public static long lastSpellTimer, spellCoolDown = Configs.PLAYER_SPELL_COOL_DOWN, spellTimer = spellCoolDown;
    public static long lastCutTimer, cutCoolDown = Configs.PLAYER_SWORD_COOL_DOWN, cutTimer = cutCoolDown;

    protected MediaPlayer footstep;

    public Rectangle abound;
    //inventory
    private Inventory inventory;

    //experience
    private long maxEx;
    private long ex;

    //skill
    private int countSkill =0;
    SkillManager skillManager;

    //item
    private int items[];

    //constructor khi khong dung skin
    public Player(Handler handler, double x, double y, int damage) {
        super(handler, Assets.player, x, y, Configs.DEFAULT_CREATURE_WIDTH, Configs.DEFAULT_CREATURE_HEIGHT, damage);

        count = 9;
        columns = 9;
        offsetX = 0;
        offsetY = 640;
        width = 64;
        height = 64;

        this.offsetUp = 512;
        this.offsetDown = 640;
        this.offsetLeft = 576;
        this.offsetRight = 704;

        //character 0
        //animation moving
        imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(imageView, Duration.millis(1000),count,columns,offsetX,offsetY,width,height);

        //move bound
        bounds.setX(24);
        bounds.setY(38);
        bounds.setWidth(16);
        bounds.setHeight(24);

        //attack bounds
        abound = new Rectangle();
        abound.setX(16);
        abound.setY(16);
        abound.setWidth(32);
        abound.setHeight(48);
        //character 0
        character = 0;

        init();
    }

    // neu dung skin thi su dung constructor nay
    public Player(Handler handler, Image image, double x, double y, int offsetX, int offsetY,
                  int offsetUp, int offsetDown, int offsetLeft, int offsetRight, int damage){
        super(handler, image, x, y, 64, 96, damage);

        count = 3;
        columns = 3;
        width = 44;
        height = 66;

        this.offsetUp = offsetUp;
        this.offsetDown = offsetDown;
        this.offsetLeft = offsetLeft;
        this.offsetRight = offsetRight;

        setSpeed(Configs.PLAYER_SPEED);
        imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(imageView, Duration.millis(1000),count,columns,offsetX,offsetY,width,height);

        bounds.setX(16);
        bounds.setY(36);
        bounds.setWidth(16);
        bounds.setHeight(28);

        abound = new Rectangle();
        abound.setX(10);
        abound.setY(11);
        abound.setWidth(24);
        abound.setHeight(53);

        character = 1;
        init();
    }

    public void init(){

        // foot sound
        footstep = Sound.footstep;
        handler.getSoundManager().addSound(footstep);



        //load saved game
        SaveDataGame saveDataGame = StartApp.getSaveData().savedGame.get(handler.getGameManager().getSaved());

        //item
        inventory = new Inventory(handler);
        items = new int[3];
        items = saveDataGame.getItems();
        System.out.println(saveDataGame.getItems());
        inventory.addItem(Item.lotionHP.createNew(items[0]));
        inventory.addItem(Item.lotionAttack.createNew(items[1]));
        inventory.addItem(Item.lotionMana.createNew(items[2]));

        //set speed
        setSpeed(saveDataGame.getSpeed());
        //set health
        maxHealth = saveDataGame.getMaxHealth();
        health = saveDataGame.getHealth();
        //set defence
        defence = saveDataGame.getDefence();
        //ex
        ex = saveDataGame.getEx();
        maxEx = saveDataGame.getMaxEx();
        //damage
        damage = saveDataGame.getDamage();
        //level
        level = saveDataGame.getLevel();
        //ap
//        ap = saveDataGame.getAp();
        //skill

        skillManager = new SkillManager(handler, this);
        countSkill = saveDataGame.getCount();
        for(int i = 1; i<= countSkill; i++){
            skillManager.addSkill(saveDataGame.getSkills()[i]);
        }

//        skillManager.addSkill(3);


        //test
//        level = 1;
//        speed = 20;
//        setDamage(1000);
//        health = 1000;
//        maxHealth = 1000;

        //show the property
        showProperty();
        showHPEX();

        //skill
//
//        skillManager.addSkill(2);
//        countSkill ++;
//        skillManager.addSkill(3);
//        countSkill ++;
//        skillManager.addSkill(2);
//        countSkill ++;
//        skillManager.addSkill(2);

    }

    public void useSkill(){
        if(skillManager.getCount() > 0) {
            if(handler.getKeyManager().isSkill1()) {
                skillManager.checkAttackSkill1();
            }

            if(skillManager.getCount() > 1){
                if(handler.getKeyManager().isSkill2()) {
                    skillManager.checkAttackSkill2();
                }
                if(skillManager.getCount() > 2){
                    if(handler.getKeyManager().isSkill3()) {
                        skillManager.checkAttackSkill3();
                    }
                    if(skillManager.getCount() > 3){
                        if(handler.getKeyManager().isSkill4()) {
                            skillManager.checkAttackSkill4();
                        }
                    }
                }
            }
        }

    }

    public void showProperty(){
        handler.getGameController().getAttack().setText("attack: " + damage);
        handler.getGameController().getAp().setText("ap: " + ap);
        handler.getGameController().getSpeed().setText("speed: " + speed);
        handler.getGameController().getDefence().setText("defence: " + defence);
    }

    public void showHPEX(){
        handler.getGameController().getHpShow().setText(health+"/" + maxHealth);
        handler.getGameController().getExShow().setText(ex+"/" + maxEx);

        if(health/(float)maxHealth <= 0){
            handler.getGameController().getHpBar().setProgress(0);
        }else if(health/(float)maxHealth >= 1){
            handler.getGameController().getHpBar().setProgress(1);
        }else{
            handler.getGameController().getHpBar().setProgress(health/(double)maxHealth);
        }

        if(ex/(float)maxEx <= 0){
            handler.getGameController().getExBar().setProgress(0);
        }else if(ex/(float)maxEx >= 1){
            handler.getGameController().getExBar().setProgress(1);
        }else{
            handler.getGameController().getExBar().setProgress(ex/(float)maxEx);
        }
    }

    @Override
    public void tick() {

        //Movement
        getInput();
        move();
        checkPointMove();

        //center
        handler.getGameCamera().centerOnEntity(this);

        //Attack
//        checkAttacks();

        useSkill();

        //inventory
        inventory.tick();

        //test
        skillManager.showCountDown();
    }

    //CHECKPOINT
    //check if Player reach CheckPoint, dung trong check point move
    private boolean checkPointTile(int x, int y){
        for(int z = 0; z<handler.getWorld().getLayer(); z++) {
            if(handler.getWorld().getTile(x,y, z).isCheckPoint()){
                return true;
            }
        }
        return false;
        //return handler.getWorld().getTile(x,y).isCheckPoint();
    }

    public void takeDamage(int damage){
        if(damage - defence <= 0){
            damage = 0;
        }else{
            damage = damage - defence;
        }
        this.health -= damage;
        if(this.health <= 0){
            die();
        }

        showHPEX();
    }


    //set world dung trong check point move
    private void setNewWorld(){

        {
            //neu thang nguoi o nua ban trai thi ve map truoc, o ben phai thi tien den map tiep
            if (handler.getWorld().getWidth() * 64 * 2 / 3 <= x + xMove) {
                GameState.world[0] = GameState.world[handler.getWorld().getCountWorld() + 1];
                GameState.entityManager = GameState.world[handler.getWorld().getCountWorld() + 1].getEntityManager();
                tele = true;
            } else {
                GameState.world[0] = GameState.world[handler.getWorld().getCountWorld() - 1];
                GameState.entityManager = GameState.world[handler.getWorld().getCountWorld() - 1].getEntityManager();
                tele = false;
            }
            GameState.playerCurrentHealth = handler.getWorld().getEntityManager().getPlayer().getHealth();
            GameState.playerCurrentSpeed = handler.getWorld().getEntityManager().getPlayer().getSpeed();

            handler.setWorld(GameState.world[0], tele);

            GameState.entityManager.getPlayer().setHealth(GameState.playerCurrentHealth);
            GameState.entityManager.getPlayer().setSpeed(GameState.playerCurrentSpeed);
        }

    }

    //get Move
    private void checkPointMove(){
        if(xMove > 0){
            int tx = (int) (x + xMove + bounds.getX() + bounds.getWidth()) / Configs.TILE_WIDTH;

            if(checkPointTile(tx, ((int) (y + bounds.getY()) / Configs.TILE_HEIGHT)) &&
                    checkPointTile(tx, (int) (y + bounds.getY() + bounds.getHeight()) / Configs.TILE_HEIGHT)){
                setNewWorld();
            }
        } else if(xMove < 0){
            int tx = (int) (x + xMove + bounds.getX()) / Configs.TILE_WIDTH;

            if(checkPointTile(tx, ((int) (y + bounds.getY()) / Configs.TILE_HEIGHT)) &&
                    checkPointTile(tx, (int) (y + bounds.getY() + bounds.getHeight()) / Configs.TILE_HEIGHT)){
                setNewWorld();
            }
        } else if(yMove < 0){
            int ty = (int) (y + yMove + bounds.getY()) / Configs.TILE_HEIGHT;

            if(checkPointTile((int) (x + bounds.getX()) / Configs.TILE_WIDTH, ty) &&
                    checkPointTile((int) (x + bounds.getX() + bounds.getWidth()) / Configs.TILE_WIDTH, ty)){
                setNewWorld();
            }
        } else {
            int ty = (int) (y + yMove + bounds.getY() + bounds.getHeight()) / Configs.TILE_HEIGHT;

            if(checkPointTile((int) (x + bounds.getX()) / Configs.TILE_WIDTH, ty) &&
                    checkPointTile((int) (x + bounds.getX() + bounds.getWidth()) / Configs.TILE_WIDTH, ty)){
                setNewWorld();
            }
        }
    }

//    private void checkAttacks(){
//        if(inventory.isActive())
//            return;
//
//        attackTimer += System.currentTimeMillis() - lastAttackTimer;
//        lastAttackTimer = System.currentTimeMillis();
//        if(attackTimer < attackCoolDown){
//            return;
//        }
//
//        Rectangle cb = getCollisionBounds(0, 0);
//        Rectangle ar = new Rectangle();
//
//        int arSize = 30;
//        ar.setWidth(arSize);
//        ar.setHeight(arSize);
//
//        if(handler.getMouseManager().isLeftPressed() && direction == 1){
//            ar.setX(cb.getX() + cb.getWidth()/2 - arSize/2);
//            ar.setY(cb.getY() - arSize);
//
//
//        } else if(handler.getMouseManager().isLeftPressed() && direction == 2){
//            ar.setX(cb.getX() + cb.getWidth()/2 - arSize/2);
//            ar.setY(cb.getY() + cb.getHeight());
//
//
//        } else if(handler.getMouseManager().isLeftPressed() && direction == 3){
//            ar.setX(cb.getX() - arSize);
//            ar.setY(cb.getY() + cb.getHeight()/2 - arSize/2);
//
//
//        } else if(handler.getMouseManager().isLeftPressed() && direction == 4){
//            ar.setX(cb.getX() + cb.getWidth());
//            ar.setY(cb.getY() + cb.getHeight()/2 - arSize/2);
//
//        } else {
//
//            return;
//        }
//
//        handler.getGraphicsContext().fillRect(ar.getX(), ar.getY(), arSize, arSize);
//
//        attackTimer = 0;
//
//        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
//            if(e.equals(this))
//                continue;
//            if(e.getCollisionBounds(0, 0).intersects(ar.getBoundsInLocal())){
//                e.takeDamage(damage);
//                if(!Configs.IS_MUTE){
//                    if(Sound.punch.getStatus() == MediaPlayer.Status.PLAYING)
//                        Sound.punch.stop();
//                    //Sound.punch.play();
//                }
//            }
//        }
//    }

    public void getInput(){
        xMove = 0;
        yMove = 0;

        if(inventory.isActive())
            return;

        if(handler.getKeyManager().isMoveUp()){
            direction = 1;
            yMove = -speed;
            animation.setOffsetY(offsetUp);

        }

        if(handler.getKeyManager().isMoveDown()){
            direction = 2;
            yMove = speed;
            animation.setOffsetY(offsetDown);
        }

        if(handler.getKeyManager().isMoveLeft()){
            direction = 3;
            xMove = -speed;
            animation.setOffsetY(offsetLeft);
        }

        if(handler.getKeyManager().isMoveRight()){
            direction = 4;
            xMove = speed;
            animation.setOffsetY(offsetRight);
        }
    }

    public void stepSound(){
        if(active){
            if(handler.getKeyManager().isMoveUp() || handler.getKeyManager().isMoveDown()
                    || handler.getKeyManager().isMoveLeft() || handler.getKeyManager().isMoveRight()){
                footstep.setCycleCount(MediaPlayer.INDEFINITE);
                //footstep.play();
            } else {
                //footstep.stop();
            }
        }
    }


    @Override
    public void render(GraphicsContext g) {
        //draw player
        if(xMove != 0 || yMove != 0)
            animation.play();
        else animation.stop();

        player = imageView.snapshot(params, null);
        g.drawImage(player, (int)(x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()));

    }

    public void postRender(GraphicsContext g){
        inventory.render(g);
    }

    @Override
    public void die() {
        //Set active
        active = false;

        //Sound off
        handler.getSoundManager().soundOff();
        handler.getGameManager().getHandlerApp().getGameOverScene().playSound();

        //chuyen canh
        handler.getGameManager().getMyTimer().stop();
        handler.getGameManager().getHandlerApp().getStage().setScene(handler.getGameManager().getHandlerApp().getGameOverScene().getScene());
    }

    @Override
    public void setHealth(int health){
        this.health = health;
    }

    public Rectangle getAttackBounds(double xOffset, double yOffset){
        return new Rectangle((int) (x + abound.getX() + xOffset),
                (int) (y + abound.getY() + yOffset), abound.getWidth(), abound.getHeight());
    }

    //tang kinh nghiem
    public void addExpe(int e){
        if(ex + e < maxEx) {
            this.ex += e;
        }else{
            ex = ex + e - maxEx;
            maxEx = maxEx + level * 50;
            level ++;
            maxHealth += 50;
            health = maxHealth;
            damage += 5;
            defence += 5;
            ap += 5;
            speed += 0.5;
            showProperty();
        }
        showHPEX();

    }

    //getter and setter
    public boolean isTele() {
        return tele;
    }

    public void setTele(boolean tele) {
        this.tele = tele;
    }

    public Rectangle getAbound() {
        return abound;
    }

    public void setAbound(Rectangle abound) {
        this.abound = abound;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public long getMaxEx() {
        return maxEx;
    }

    public void setMaxEx(long maxEx) {
        this.maxEx = maxEx;
    }

    public long getEx() {
        return ex;
    }

    public void setEx(long ex) {
        this.ex = ex;
    }

    public int getCountSkill() {
        return countSkill;
    }

    public void setCountSkill(int countSkill) {
        this.countSkill = countSkill;
    }

    public SkillManager getSkillManager() {
        return skillManager;
    }

    public void setSkillManager(SkillManager skillManager) {
        this.skillManager = skillManager;


    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }
}
