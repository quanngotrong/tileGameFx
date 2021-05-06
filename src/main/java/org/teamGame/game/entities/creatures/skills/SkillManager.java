package org.teamGame.game.entities.creatures.skills;

import org.teamGame.game.Handler;
import org.teamGame.game.entities.creatures.Enemy;
import org.teamGame.game.entities.creatures.Player;

import java.util.ArrayList;
import java.util.Iterator;

public class SkillManager {

    private Handler handler;

    //skill array
    //skill 1: Q
    //skill 2: E
    //skill 3: R
    //skill 4: space
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

    /*
    skill 1: spellSkill
    skill 2: bulletSkill
    skill 3:
     */
    public void addSkill(int skill){
        // neu khong la player
        if(isPlayer == 0) {
            for (int i = 1; i <= 4; i++) {
                if (skills[i] == 0) {
                    skills[i] = skill;
                    count++;
                    switch (skill) {
                        case 1:
                            skillArray.add(new SpellSkill(handler, isPlayer, enemy));
                            break;
                        case 2:
                            skillArray.add(new BulletSkill(handler, isPlayer, enemy));
                            break;
                        case 3:
                            skillArray.add(new SwordSkill(handler, isPlayer, enemy));
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
                    skills[i] = skill;
                    count++;
                    switch (skill) {
                        case 1:
                            skillArray.add(new SpellSkill(handler, isPlayer, player));
                            break;
                        case 2:
                            skillArray.add(new BulletSkill(handler, isPlayer, player));
                            break;
                        case 3:
                            skillArray.add(new SwordSkill(handler, isPlayer, player));
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
}
