package org.teamGame.sounds;

import javafx.scene.media.MediaPlayer;
import org.teamGame.game.Handler;
import org.teamGame.util.HandlerApp;

import java.util.ArrayList;

public class SoundManager {

    private HandlerApp handlerApp;
    private ArrayList<MediaPlayer> sounds;


    public SoundManager(HandlerApp handlerApp){
        this.handlerApp = handlerApp;
        sounds = new ArrayList<>();
    }

    public void addSound(MediaPlayer mediaPlayer) {
        sounds.add(mediaPlayer);
    }

    //tat toan bo am thanh
    public void soundOff() {
        for (MediaPlayer mediaP : sounds)
            mediaP.stop();
    }

    //tat am
    public void muteAll() {
        for (MediaPlayer mediaP : sounds)
            mediaP.setMute(true);
    }

    //bat am
    public void unMuteAll() {
        for (MediaPlayer mediaP : sounds)
            mediaP.setMute(false);
    }

    //thay doi am luong
    public void setVolume(int volume) {
        for (MediaPlayer mediaP : sounds)
            mediaP.setVolume(volume);
    }

    //chat ve list nhac
    public ArrayList<MediaPlayer> getSoundList() {
        return sounds;
    }

    //chua dung
    public MediaPlayer getSound(MediaPlayer mediaPlayer) {
        for (MediaPlayer mediaP : sounds) {
            if (mediaP.equals(mediaPlayer))
                return mediaP;
        }
        return null;
    }
}
