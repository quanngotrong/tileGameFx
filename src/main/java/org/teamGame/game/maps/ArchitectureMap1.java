package org.teamGame.game.maps;

import org.teamGame.game.gfx.Assets;

public class ArchitectureMap1 extends Tile{
    public ArchitectureMap1(int id) {
        super(Assets.map1[(id-1)%25][(id-1-((id-1)%25))/25], id);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
