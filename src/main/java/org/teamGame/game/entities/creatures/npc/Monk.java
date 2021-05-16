package org.teamGame.game.entities.creatures.npc;

import org.teamGame.game.Handler;
import org.teamGame.game.gfx.Dialogue;
import org.teamGame.game.gfx.Assets;

public class Monk extends NPC{
    public Monk(Handler handler, double x, double y) {
        super(handler, Assets.male_npcs, x, y, Dialogue.Monk, 0, 264, 462, 264, 330, 396);
    }
}
