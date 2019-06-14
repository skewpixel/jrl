package com.skewpixel.jrl.screens;

import asciiPanel.AsciiPanel;
import com.skewpixel.jrl.map.World;
import com.skewpixel.jrl.map.WorldBuilder;
import com.skewpixel.jrl.mobs.Creature;
import com.skewpixel.jrl.mobs.CreatureFactory;

import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {

    private World world;
    private int screenWidth;
    private int screenHeight;

    CreatureFactory creatureFactory;
    Creature player;

    public PlayScreen() {
        screenWidth = 80;
        screenHeight = 21;
        createWorld();

        creatureFactory = new CreatureFactory(world);
        player = creatureFactory.newPlayer();
    }

    private void createWorld() {
        world = new WorldBuilder(90, 31).makeCaves().build();
    }


    public int getScrollX() {
        return Math.max(0, Math.min(player.x - screenWidth/2, world.getWidth() - screenWidth));
    }

    public int getScrollY() {
        return Math.max(0, Math.min(player.y - screenHeight/2, world.getHeight() - screenHeight));
    }

    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for(int x = 0; x < screenWidth; x++) {
            for(int y = 0; y < screenHeight; y++) {
                int wx = x + left;
                int wy = y + top;

                terminal.write(world.getGlyphAt(wx, wy), x, y, world.getColorAt(wx, wy));
            }
        }
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        int left = getScrollX();
        int top = getScrollY();

        displayTiles(terminal, left, top );
        terminal.write(player.getGlyph(), player.x - left, player.y - top, player.getColor());
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H: player.moveBy(-1, 0); break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L: player.moveBy(1, 0); break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_K: player.moveBy(0, -1); break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J: player.moveBy(0, 1); break;

            case KeyEvent.VK_Y: player.moveBy(-1, -1); break;
            case KeyEvent.VK_U: player.moveBy(1, -1); break;
            case KeyEvent.VK_B: player.moveBy(-1, 1); break;
            case KeyEvent.VK_N: player.moveBy(1, 1); break;

        }

        return this;
    }
}
