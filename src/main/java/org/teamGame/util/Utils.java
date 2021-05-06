package org.teamGame.util;

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

}
