package org.teachingkidsprogramming.typingdeepdive;

import org.teachingkidsprogramming.typingdeepdive.tests.WordType;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class KeyProcessor implements KeyListener {
    public static KeyProcessor createKeyProcessor(DeepDiveTypingGame deepDiveTypingGame) {
        if(deepDiveTypingGame.type.equals(WordType.HOTKEYS)){
            return new HotkeyProcessor(deepDiveTypingGame);
        }
        return new WordProcessor(deepDiveTypingGame);
    }
}