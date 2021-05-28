package org.teachingkidsprogramming.typingdeepdive;

import java.awt.event.KeyEvent;

public class WordProcessor extends KeyProcessor {
    DeepDiveTypingGame deepDiveTypingGame;

    protected WordProcessor(DeepDiveTypingGame deepDiveTypingGame) {
        this.deepDiveTypingGame = deepDiveTypingGame;
    }

    public void keyTyped(KeyEvent e) {
        deepDiveTypingGame.processLetter(e.getKeyChar());
    }

    public void keyPressed(KeyEvent e) {
        //do nothing
    }

    public void keyReleased(KeyEvent e) {
        //do nothing
    }
}
