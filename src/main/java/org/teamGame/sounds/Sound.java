package org.teamGame.sounds;

import javafx.scene.media.MediaPlayer;
import org.teamGame.game.configs.Configs;

public class Sound {

    public static MediaPlayer main = new MediaPlayer(SoundLoader.loadSound("/sounds/main_theme.wav"));
    public static MediaPlayer footstep = new MediaPlayer(SoundLoader.loadSound("/sounds/foot_step.wav"));
    public static MediaPlayer hurt = new MediaPlayer(SoundLoader.loadSound("/sounds/ouch.wav"));
    public static MediaPlayer uchiha = new MediaPlayer(SoundLoader.loadSound("/sounds/uchiha_theme.wav"));
    public static MediaPlayer gameover = new MediaPlayer(SoundLoader.loadSound("/sounds/gameover.wav"));
    public static MediaPlayer victory = new MediaPlayer(SoundLoader.loadSound("/sounds/victory.wav"));
    public static MediaPlayer punch = new MediaPlayer(SoundLoader.loadSound("/sounds/punch.wav"));
    public static MediaPlayer player_fired = new MediaPlayer(SoundLoader.loadSound("/sounds/player_fired.wav"));
    public static MediaPlayer player_sword = new MediaPlayer(SoundLoader.loadSound("/sounds/sword-arm-2a.wav"));
    public static MediaPlayer cut = new MediaPlayer(SoundLoader.loadSound("/sounds/sword-1a.wav"));
    public static MediaPlayer boom = new MediaPlayer(SoundLoader.loadSound("/sounds/boom.wav"));
    public static MediaPlayer dragon_fired = new MediaPlayer(SoundLoader.loadSound("/sounds/dragon_fired.wav"));

    //bat 1 cai nhac nhat dinh
    public static void playSound(MediaPlayer mediaPlayer) {
        if (!Configs.IS_MUTE) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING)
                mediaPlayer.stop();
            mediaPlayer.play();
        }
    }
}
