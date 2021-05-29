package org.teamGame.sounds;

import javafx.scene.media.Media;

import java.io.File;
import java.net.URL;

public class SoundLoader {

    public static Media loadSound(String path) {

        URL ostFile = SoundLoader.class.getResource(path);
        return new Media(ostFile.toString());
    }

}
