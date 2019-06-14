package com.skewpixel.jrl.mobs.ai;

import com.skewpixel.jrl.map.Tile;
import com.skewpixel.jrl.mobs.Creature;

public class CreatureAi {

    protected Creature creature;

    public CreatureAi(Creature creature) {
        this.creature = creature;
        this.creature.setCreatureAi(this);
    }

    public void onEnter(int x, int y, Tile tile) { }
}
