package org.teamGame.game.entities.creatures.npc;

import org.teamGame.game.Handler;
import org.teamGame.game.dialogue.Dialogue;
import org.teamGame.game.gfx.Assets;

public class Farmer extends NPC{
    public Farmer(Handler handler, double x, double y) {
        super(handler, Assets.male_npcs, x, y, Dialogue.Farmer, 132, 0, 196, 0, 66, 132);
    }
}
