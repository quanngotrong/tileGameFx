package org.teamGame.game.entities.creatures.npc;

import org.teamGame.game.Handler;
import org.teamGame.game.dialogue.Dialogue;
import org.teamGame.game.gfx.Assets;

public class GreenHair extends NPC{
    public GreenHair(Handler handler, double x, double y) {
        super(handler, Assets.children_npcs, x, y, Dialogue.GreenHair, 0, 0, 196, 0, 66, 132);
    }
}
