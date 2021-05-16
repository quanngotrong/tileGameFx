module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.teamGame to javafx.fxml;
    opens org.teamGame.controller;
    opens org.teamGame.scene;
    opens org.teamGame.util;
    opens org.teamGame.game;
    opens org.teamGame.game.worlds;
    opens org.teamGame.game.gfx;
//    opens org.teamGame.game.tiles;
    opens org.teamGame.game.input;
    opens org.teamGame.game.entities;
    opens org.teamGame.game.entities.creatures;
    opens org.teamGame.sounds;

    exports org.teamGame;
    exports org.teamGame.controller;
    exports org.teamGame.scene;
    exports org.teamGame.util;
    exports org.teamGame.game;
    exports org.teamGame.game.worlds;
    exports org.teamGame.game.gfx;

    exports org.teamGame.game.input;
    exports org.teamGame.game.entities;
    exports org.teamGame.sounds;
    exports org.teamGame.game.entities.creatures;

}