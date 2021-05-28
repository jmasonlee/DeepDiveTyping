package org.teachingkidsprogramming.typingdeepdive;

import java.awt.event.KeyEvent;
import java.util.function.Consumer;

public class WordProcessor extends KeyProcessor {
    DeepDiveTypingGame deepDiveTypingGame;

    protected WordProcessor(DeepDiveTypingGame deepDiveTypingGame) {
        this.deepDiveTypingGame = deepDiveTypingGame;
    }

    public void keyTyped(KeyEvent e) {
        keyTyped(e, deepDiveTypingGame::processLetter);
    }

    public void keyTyped(KeyEvent e, Consumer<Character> processLetter) {
        processLetter.accept(e.getKeyChar());
    }

    public void keyPressed(KeyEvent e) {
        //do nothing
    }

    public void keyReleased(KeyEvent e) {
        //do nothing
    }
}
