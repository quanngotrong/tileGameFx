package org.teamGame.test;

import org.teamGame.save.ResourceManager;
import org.teamGame.save.SaveData;
import org.teamGame.save.SaveDataGame;

public class Test {

    public Test(){

    }

    public static void testSave(){
        SaveData saveData = new SaveData();
        saveData.setGold(1000);
        int skills[] = new int[5];
        skills[1] = 2;
        int items[] = new int[3];
        items[0] = 1;
        items[1] = 3;
        items[2] = 0;

        boolean[] characters = new boolean[]{true, true, true, false, false, false ,false ,false ,false, false};
        SaveDataGame saveDataGame = new SaveDataGame(1, 200, 200, 0, 50, 0,
                25, 5, 7.0, 1, skills, 0, 1, 10, items);
        SaveDataGame saveDataGame2 = new SaveDataGame(1, 200, 200, 0, 50, 1,
                25, 5, 7.0, 1, skills, 0, 1, 15, items);
        saveData.setAvailCharacter(characters);
        saveData.savedGame.add(saveDataGame);
        saveData.savedGame.add(saveDataGame2);


        try{
            ResourceManager.save(saveData, "src/main/resources/SavedData/savedData.save");
        }
        catch (Exception e){
            System.out.println("Couldn't save: " + e.getMessage());
        }

    }

    public static void testLoad(){
        try {
            SaveData saveData = (SaveData) ResourceManager.load("src/main/resources/SavedData/savedData.save");
            System.out.println(saveData.getGold());
            SaveDataGame saveDataGame = saveData.savedGame.get(0);
            System.out.println(saveDataGame.getEx());
            System.out.println(saveDataGame.getSkills());
            System.out.println(saveData.savedGame.get(1).getCharacter());
        }
        catch(Exception e){
            System.out.println("Couldn't load: " + e.getMessage());
        }
    }
}
