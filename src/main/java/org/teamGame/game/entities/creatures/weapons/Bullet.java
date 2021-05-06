package org.teamGame.game.entities.creatures.weapons;

import javafx.scene.image.Image;
import org.teamGame.game.Handler;
import org.teamGame.sounds.Sound;

public class Bullet extends Weapon{
    public Bullet(Handler handler, Image image, double x, double y, int damage, int direction) {
        super(handler, image, x, y, 20,21, damage, 500, 500, Sound.boom);
        this.direction = direction;

        setSpeed(30);
        bounds.setX(4);
        bounds.setY(4);
        bounds.setHeight(20);
        bounds.setWidth(20);

    }
}
