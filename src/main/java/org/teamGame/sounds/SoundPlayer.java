package org.teamGame.sounds;

import javafx.scene.media.MediaPlayer;
import org.teamGame.game.configs.Configs;

public class SoundPlayer {
    public static void PlaySound(MediaPlayer mp) {
        if (!Configs.IS_MUTE) {
            if (mp.getStatus() == MediaPlayer.Status.PLAYING)
                mp.stop();
            mp.play();
        }
    }
}
