package org.teamGame.game.gfx;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageLoader {
    public static Image loadImage(String path){
        return new Image(ImageLoader.class.getResource(path).toString());
    }

    public static Image loadImage(String path, int width, int height){
        return new Image(ImageLoader.class.getResource(path).toString(), width, height, true, true);
    }
}
