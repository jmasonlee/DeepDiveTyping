package org.teachingkidsprogramming.typingdeepdive;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyProcessor implements KeyListener {
    private final DeepDiveTypingGame deepDiveTypingGame;

    private KeyProcessor(DeepDiveTypingGame deepDiveTypingGame) {
        this.deepDiveTypingGame = deepDiveTypingGame;
    }

    public static KeyProcessor createKeyProcessor(DeepDiveTypingGame deepDiveTypingGame) {
        return new KeyProcessor(deepDiveTypingGame);
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