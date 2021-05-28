package org.teachingkidsprogramming.typingdeepdive;

import java.awt.event.KeyEvent;
import java.util.function.Consumer;

public class HotkeyProcessor extends KeyProcessor {
    @Override
    public void keyTyped(KeyEvent e) {
        //do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e, Consumer<Character> processLetter) {
        processLetter.accept(KeyEvent.getKeyText(e.getKeyCode()).charAt(0));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //do nothing
    }
}
