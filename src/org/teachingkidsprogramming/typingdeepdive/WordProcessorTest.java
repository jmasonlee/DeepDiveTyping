package org.teachingkidsprogramming.typingdeepdive;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class WordProcessorTest {

    @Test
    void keyTypedDetectsKey() {
        DeepDiveTypingGame game = new DeepDiveTypingGame();
        KeyEvent keyEvent = new KeyEvent(new Button("b"), 1, 20, 1, 10, 'a');
        WordProcessor wordProcessor = new WordProcessor(game);
        final Character[] letter = {Character.MIN_VALUE};

        wordProcessor.keyTyped(keyEvent, e -> letter[0] = e);

        assertEquals(letter[0], keyEvent.getKeyChar());
    }
}