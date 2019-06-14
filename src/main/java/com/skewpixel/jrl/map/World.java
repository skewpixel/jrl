package com.skewpixel.jrl.map;

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
}
