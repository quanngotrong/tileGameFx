package org.teamGame.game.entities.creatures.npc;

import org.teamGame.game.Handler;
import org.teamGame.game.gfx.Dialogue;
import org.teamGame.game.gfx.Assets;

public class Guard extends NPC{
    String text;
    public Guard(Handler handler, double x, double y) {
        super(handler, Assets.male_npcs, x, y, Dialogue.Guard, 264, 0, 196, 0, 66, 132);
    }

    public Guard(Handler handler, String text, double x, double y) {
        super(handler, Assets.male_npcs, x, y, text, 264, 0, 196, 0, 66, 132);
        this.text = text;
    }

    @Override
    public void tick() {
        playDialogue();
    }
}
