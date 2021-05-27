package org.teachingkidsprogramming.typingdeepdive;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyProcessor implements KeyListener {
    private final DeepDiveTypingGame deepDiveTypingGame;

    public KeyProcessor(DeepDiveTypingGame deepDiveTypingGame) {
        this.deepDiveTypingGame = deepDiveTypingGame;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        deepDiveTypingGame.processLetter(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //do nothing
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //do nothing
    }
}