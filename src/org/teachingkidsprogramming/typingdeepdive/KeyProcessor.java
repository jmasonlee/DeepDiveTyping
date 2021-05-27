package org.teachingkidsprogramming.typingdeepdive;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class KeyProcessor implements KeyListener {
    public static KeyProcessor createKeyProcessor(DeepDiveTypingGame deepDiveTypingGame) {
        return new WordProcessor(deepDiveTypingGame);
    }
}