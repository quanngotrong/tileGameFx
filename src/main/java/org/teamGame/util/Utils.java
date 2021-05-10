package org.teamGame.util;

import javafx.scene.image.Image;
import org.teamGame.StartApp;
import org.teamGame.controller.LoadController;
import org.teamGame.game.gfx.Assets;
import org.teamGame.save.ResourceManager;
import org.teamGame.save.SaveData;
import org.teamGame.save.SaveDataGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    /*
    load map
     */
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null)
                builder.append(line).append("\n");
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return builder.toString();
    }

    //string to int
    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //load data
    public static SaveData loadData(){
        try {
            SaveData saveData = (SaveData) ResourceManager.load("src/main/resources/SavedData/savedData.save");
            return saveData;
        }
        catch(Exception e){
            System.out.println("Couldn't load: " + e.getMessage());
            return null;
        }

    }

    //save data
    public static void saveData(SaveData saveData){
        try{
            ResourceManager.save(saveData, "src/main/resources/SavedData/savedData.save");
        }
        catch (Exception e){
            System.out.println("Couldn't save: " + e.getMessage());
        }
    }

    //choose character
    public static Image chooseCharacter(int i){
        if(i == 1){
            return Assets.character1;
        }
        if(i == 2){
            return Assets.character2;
        }
        if(i == 3){
            return Assets.character3;
        }
        if(i == 4){
            return Assets.character4;
        }
        if(i == 5){
            return Assets.character5;
        }
        if(i == 6){
            return Assets.character6;
        }
        if(i == 7){
            return Assets.character7;
        }
        if(i == 8){
            return Assets.character8;
        }
        if(i == 9){
            return Assets.character9;
        }
        return Assets.character0;
    }

    //reset game
    public static void resetGame(){
        SaveData save = new SaveData();
        save.setGold(500);
        int skills[] = new int[5];
        skills[1] = 2;
        skills[2] = 3;
        int items[] = new int[3];
        items[0] = 1;
        items[1] = 1;
        items[2] = 1;

        boolean[] characters = new boolean[]{true, true, true, false, false, false ,false ,false ,false, false};
        SaveDataGame saveDataGame = new SaveDataGame(1, 500, 500, 0, 50, 0,
                50, 5, 8.0, 2, skills, 0, 1, 10, items);
        save.setAvailCharacter(characters);

        save.savedGame.add(saveDataGame);

        StartApp.setSaveData(save);

        Utils.saveData(StartApp.getSaveData());
    }
}
