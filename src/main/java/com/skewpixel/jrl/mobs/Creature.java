package com.skewpixel.jrl.mobs;

import com.skewpixel.jrl.map.World;
import com.skewpixel.jrl.mobs.ai.CreatureAi;

import java.awt.*;

public class Creature {

    private final World world;

    public int x;
    public int y;

    private char glyph;
    private Color color;

    private CreatureAi ai;

    public Creature(World world, char glyph, Color color) {
        this.world = world;
        this.glyph = glyph;
        this.color = color;
    }

    public char getGlyph() {
        return glyph;
    }

    public Color getColor() {
        return color;
    }

    public void setCreatureAi(CreatureAi ai) {
        this.ai = ai;
    }

    public void dig(int wx, int wy) {
        world.dig(wx, wy);
    }

    public void moveBy(int mx, int my) {
        ai.onEnter(x + mx, y + my, world.getTileAt(x + mx, y + my));
    }
}
