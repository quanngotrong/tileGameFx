package org.teamGame.game.entities.creatures.npc;

import org.teamGame.game.Handler;
import org.teamGame.game.gfx.Dialogue;
import org.teamGame.game.gfx.Assets;

public class Jill extends NPC{
    public Jill(Handler handler, double x, double y) {
        super(handler, Assets.female_npcs, x, y, Dialogue.Jill, 0, 0, 196, 0, 66, 132);
    }
}
