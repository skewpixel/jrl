package com.skewpixel.jrl.mobs;

import asciiPanel.AsciiPanel;
import com.skewpixel.jrl.map.World;
import com.skewpixel.jrl.mobs.ai.PlayerAi;

public class CreatureFactory {
    private World world;

    public CreatureFactory(World world) {
        this.world = world;
    }

    public Creature newPlayer() {
        Creature player = new Creature(world, '@', AsciiPanel.brightWhite);

        world.addAtEmptyLocation(player);
        new PlayerAi(player);

        return player;
    }
}
