package org.teachingkidsprogramming.typingdeepdive;

import java.awt.event.KeyEvent;

public class HotkeyProcessor extends KeyProcessor {
    private DeepDiveTypingGame deepDiveTypingGame;

    public HotkeyProcessor(DeepDiveTypingGame deepDiveTypingGame) {
        this.deepDiveTypingGame = deepDiveTypingGame;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        deepDiveTypingGame.processLetter(detectKeyPressed(e));
    }

    public char detectKeyPressed(KeyEvent e) {
        return KeyEvent.getKeyText(e.getKeyCode()).charAt(0);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //do nothing
    }
}
