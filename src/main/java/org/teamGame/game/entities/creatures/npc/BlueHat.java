package org.teamGame.game.entities.creatures.npc;

import org.teamGame.game.Handler;
import org.teamGame.game.gfx.Dialogue;
import org.teamGame.game.gfx.Assets;

public class BlueHat extends NPC{
    public BlueHat(Handler handler, double x, double y) {
        super(handler, Assets.children_npcs, x, y, Dialogue.BlueHat, 264, 0, 196, 0, 66, 132);
    }
}
