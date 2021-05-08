package org.teamGame.save;

import java.io.Serializable;

public class SaveDataGame implements Serializable {
    private static final long serialVersionUID = 1L;

    private int map;

    //health
    private int health;
    private int maxHealth;

    //experience
    private int ex;
    private int maxEx;

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

    public SaveDataGame(int map, int health, int maxHealth, int ex, int maxEx, int character, int damage, int defence, double speed, int count, int[] skills,
                        int difficulty, int level) {
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

    public int getEx() {
        return ex;
    }

    public void setEx(int ex) {
        this.ex = ex;
    }

    public int getMaxEx() {
        return maxEx;
    }

    public void setMaxEx(int maxEx) {
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
}
