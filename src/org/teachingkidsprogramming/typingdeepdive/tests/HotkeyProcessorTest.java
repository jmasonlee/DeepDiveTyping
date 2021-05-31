package org.teachingkidsprogramming.typingdeepdive.tests;

import org.junit.jupiter.api.Test;
import org.teachingkidsprogramming.typingdeepdive.DeepDiveTypingGame;
import org.teachingkidsprogramming.typingdeepdive.HotkeyProcessor;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HotkeyProcessorTest {

    @Test
    void keyPressedDetectsKey() {
        DeepDiveTypingGame game = new DeepDiveTypingGame();
        KeyEvent keyEvent = new KeyEvent(new Button("b"), 1, 20, 1, KeyEvent.VK_A, 'A');
        HotkeyProcessor hotkeyProcessor = new HotkeyProcessor(game);

        assertEquals(hotkeyProcessor.detectKeyPressed(keyEvent), keyEvent.getKeyChar());
    }
}