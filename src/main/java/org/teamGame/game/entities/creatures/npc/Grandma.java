package org.teamGame.game.entities.creatures.npc;

import org.teamGame.game.Handler;
import org.teamGame.game.dialogue.Dialogue;
import org.teamGame.game.gfx.Assets;

public class Grandma extends NPC{
    public Grandma(Handler handler, double x, double y) {
        super(handler, Assets.female_npcs, x, y, Dialogue.Grandma, 132, 0, 196, 0, 66, 132);
    }
}
