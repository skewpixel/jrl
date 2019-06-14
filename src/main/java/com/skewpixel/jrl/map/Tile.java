package com.skewpixel.jrl.map;

import asciiPanel.AsciiPanel;

import java.awt.*;

public enum Tile {
    FLOOR((char)250, AsciiPanel.yellow),
    WALL((char)177, AsciiPanel.yellow),
    BOUNDS('x', AsciiPanel.brightBlack)
    ;

    private Color color;
    private char glyph;

    public Color getColor() {
        return color;
    }

    public char getGlyph() {
        return glyph;
    }

    Tile(char glyph, Color color) {
        this.color = color;
        this.glyph = glyph;
    }

    public boolean isDiggable() {
        return this == WALL;
    }

    public boolean isGround() {
        return this != WALL && this != BOUNDS;
    }
}
