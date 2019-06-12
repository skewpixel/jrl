package com.skewpixel.jrl;

import asciiPanel.AsciiPanel;

import javax.swing.*;

public class GameWindow extends JFrame {

    private AsciiPanel terminal;

    public GameWindow() {
        super();

        this.terminal = new AsciiPanel();
        this.setTitle(".:: jrl ::.");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(terminal);
        pack();
    }
}
