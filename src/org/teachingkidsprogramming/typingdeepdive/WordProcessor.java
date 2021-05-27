package org.teachingkidsprogramming.typingdeepdive;

import java.awt.event.KeyEvent;

public class WordProcessor extends KeyProcessor {
    DeepDiveTypingGame deepDiveTypingGame;

    protected WordProcessor(DeepDiveTypingGame deepDiveTypingGame) {
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
