package com.skewpixel.jrl.map;

import com.skewpixel.jrl.mobs.Creature;

import java.awt.*;

public class World {
    private Tile[][] tiles;
    private int width;
    private int height;

    public World(Tile[][] tiles) {
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }

    public Tile getTileAt(int x, int y) {
        if(x < 0 || x >= width || y < 0 || y >=height){
            return Tile.BOUNDS;
        }
        else {
            return tiles[x][y];
        }
    }

    public char getGlyphAt(int x, int y) {
        return getTileAt(x, y).getGlyph();
    }

    public Color getColorAt(int x, int y) {
        return getTileAt(x, y).getColor();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void dig(int wx, int wy) {
        if(getTileAt(wx, wy).isDiggable()) {
            tiles[wx][wy] = Tile.FLOOR;
        }
    }

    public void addAtEmptyLocation(Creature creature) {
        int x;
        int y;

        do {
            x = (int) Math.random() * width;
            y = (int) Math.random() * height;
        }
        while(!getTileAt(x, y).isGround());

        creature.x = x;
        creature.y = y;
    }
}
