package org.teachingkidsprogramming.typingdeepdive;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class HotkeyProcessorTest {

    @Test
    void keyPressedDetectsKey() {
        DeepDiveTypingGame game = new DeepDiveTypingGame();
        KeyEvent keyEvent = new KeyEvent(new Button("b"), 1, 20, 1, KeyEvent.VK_A, 'A');
        HotkeyProcessor hotkeyProcessor = new HotkeyProcessor();
        final Character[] letter = {Character.MIN_VALUE};

        hotkeyProcessor.keyPressed(keyEvent, l -> letter[0] = l);

        assertEquals(letter[0], keyEvent.getKeyChar());
    }
}