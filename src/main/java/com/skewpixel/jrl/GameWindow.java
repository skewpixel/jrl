package com.skewpixel.jrl;

import asciiPanel.AsciiPanel;
import com.skewpixel.jrl.screens.Screen;
import com.skewpixel.jrl.screens.StartScreen;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame implements KeyListener {

    private AsciiPanel terminal;
    private Screen currentScreen;

    public GameWindow() {
        super();

        this.terminal = new AsciiPanel();
        this.setTitle(".:: jrl ::.");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(terminal);
        pack();

        addKeyListener(this);

        currentScreen = new StartScreen();
        repaint();
    }

    @Override
    public void repaint() {
        terminal.clear();
        currentScreen.displayOutput(terminal);
        super.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentScreen = currentScreen.respondToUserInput(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }


}
