package org.teamGame.game.entities.creatures.npc;

import org.teamGame.game.Handler;
import org.teamGame.game.dialogue.Dialogue;
import org.teamGame.game.gfx.Assets;

public class Jack extends NPC{
    public Jack(Handler handler, double x, double y) {
        super(handler, Assets.male_npcs, x, y, Dialogue.Jack, 0, 0, 196, 0, 66, 132);
    }
}
