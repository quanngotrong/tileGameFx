package org.teamGame.save;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveData implements Serializable {

    private static final long serialVersionUID = 1L;

    private long gold;

    private boolean availCharacter[];

    public ArrayList<SaveDataGame> savedGame;

    public SaveData(){
        savedGame = new ArrayList<SaveDataGame>();
        availCharacter = new boolean[10];
    }

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public boolean[] getAvailCharacter() {
        return availCharacter;
    }

    public void setAvailCharacter(boolean[] availCharacter) {
        this.availCharacter = availCharacter;
    }
}
