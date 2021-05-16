package org.teamGame.game.entities.creatures.skills;

import javafx.scene.image.ImageView;
import org.teamGame.game.Handler;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.game.entities.creatures.bossSkill.FireRingSkill;
import org.teamGame.game.gfx.Assets;

import java.util.ArrayList;
import java.util.Iterator;

public class SkillManager {

    private Handler handler;

    //skill array
    //skill 1: Q
    //skill 2: W
    //skill 3: E
    //skill 4: R
    private int skills[];

    //count amount of skill
    private int count;

    private Player player;
    private Enemy enemy;

    //Array
    private ArrayList<Skill> skillArray;

    //is player
    public int isPlayer;

    Iterator i;

    public SkillManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;

        skills = new int[5];

        isPlayer = 1;
        count = 0;
        skillArray = new ArrayList<Skill>();
    }

    public SkillManager(Handler handler, Enemy enemy){
        this.handler = handler;
        this.enemy = enemy;

        skills = new int[5];

        isPlayer = 0;
        count = 0;
        skillArray = new ArrayList<Skill>();
    }
    //use skill
    public void checkAttackSkill1(){
        skillArray.get(0).attack();
    }

    public void checkAttackSkill2(){
        skillArray.get(1).attack();
    }

    public void checkAttackSkill3(){
        skillArray.get(2).attack();
    }

    public void checkAttackSkill4(){
        skillArray.get(3).attack();
    }

    //show countDown
    public void showCountDown(){
        for(int i = 0; i< count; i++){
            skillArray.get(i).showCountDown();
        }
    }

    /*
    skill 1: spellSkill
    skill 2: bulletSkill
    skill 3: swordSkill
    skill 4: fire ring
    skill 5: sayda skill
     */
    public void addSkill(int skill){
        if(count == 4){
            return;
        }
        // neu khong la player
        if(isPlayer == 0) {
            for (int i = 1; i <= 4; i++) {
                if (skills[i] == 0) {
                    skills[i] = skill;
                    count++;
                    switch (skill) {
                        case 1:
                            skillArray.add(new SpellSkill(handler, isPlayer, enemy, i));
                            break;
                        case 2:
                            skillArray.add(new BulletSkill(handler, isPlayer, enemy, i));
                            break;
                        case 3:
                            skillArray.add(new SwordSkill(handler, isPlayer, enemy, i));
                            break;
                        case 4:
                            skillArray.add(new FireRingSkill(handler, isPlayer, enemy, i));
                            break;
                        case 5:
                            skillArray.add(new SaydaSkill(handler, isPlayer, enemy, i));
                            break;
                    }
                    break;
                }
            }
        }
        // neu la player
        else{
            for (int i = 1; i <= 4; i++) {
                if (skills[i] == 0) {
                    ImageView imageView = new ImageView();
                    switch (i){
                        case 1:
                            imageView = handler.getGameController().getSkill1();
                            break;
                        case 2:
                            imageView = handler.getGameController().getSkill2();
                            break;
                        case 3:
                            imageView = handler.getGameController().getSkill3();
                            break;
                        case 4:
                            imageView = handler.getGameController().getSkill4();
                            break;

                    }

                    skills[i] = skill;
                    count++;
                    switch (skill) {
                        case 1:
                            skillArray.add(new SpellSkill(handler, isPlayer, player, i));
                            imageView.setImage(Assets.spellSkill);
                            break;
                        case 2:
                            skillArray.add(new BulletSkill(handler, isPlayer, player, i));
                            imageView.setImage(Assets.fireBallSkill);
                            break;
                        case 3:
                            skillArray.add(new SwordSkill(handler, isPlayer, player, i));
                            imageView.setImage(Assets.swordSkill);
                            break;
                        case 4:
                            skillArray.add(new FireRingSkill(handler, isPlayer, player, i));

                            break;
                        case 5:
                            skillArray.add(new SaydaSkill(handler, isPlayer, player, i));
                            imageView.setImage(Assets.saydaSkill);
                            break;
                    }
                    break;
                }
            }
        }
    }

    public int[] getSkills() {
        return skills;
    }

    public void setSkills(int[] skills) {
        this.skills = skills;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Skill> getSkillArray() {
        return skillArray;
    }

    public void setSkillArray(ArrayList<Skill> skillArray) {
        this.skillArray = skillArray;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
