package org.teamGame.game.maps;

import org.teamGame.game.gfx.Assets;

public class CheckPoint extends Tile {

    public CheckPoint(int id) {
        super(Assets.checkpoint, id);
    }

    public boolean isCheckPoint(){
        return true;
    }
}
