package org.teamGame.save;

import java.io.Serializable;

public class SaveDataGame implements Serializable {
    private static final long serialVersionUID = 1L;

    private int map;

    //health
    private int health;
    private int maxHealth;

    //experience
    private long ex;
    private long maxEx;

    //character
    private int character;

    //property
    private int damage;
    private int defence;
    private double speed;

    //skill
    private int count;
    private int skills[];

    //difficulty
    private int difficulty;

    //level
    private int level;

    //ap
    private int ap;

    //item
    private int items[];

    public SaveDataGame(int map, int health, int maxHealth, long ex, long maxEx, int character, int damage, int defence, double speed, int count, int[] skills,
                        int difficulty, int level, int ap, int items[]) {
        this.map = map;
        this.health = health;
        this.maxHealth = maxHealth;
        this.ex = ex;
        this.maxEx = maxEx;
        this.character = character;
        this.damage = damage;
        this.defence = defence;
        this.speed = speed;
        this.count = count;
        this.skills = skills;
        this.difficulty = difficulty;
        this.level = level;

        this.ap = ap;
        this.items = items;
    }

    public int getMap() {
        return map;
    }

    public void setMap(int map) {
        this.map = map;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public long getEx() {
        return ex;
    }

    public void setEx(long ex) {
        this.ex = ex;
    }

    public long getMaxEx() {
        return maxEx;
    }

    public void setMaxEx(long maxEx) {
        this.maxEx = maxEx;
    }

    public int getCharacter() {
        return character;
    }

    public void setCharacter(int character) {
        this.character = character;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[] getSkills() {
        return skills;
    }

    public void setSkills(int[] skills) {
        this.skills = skills;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }
}
