package org.teachingkidsprogramming.typingdeepdive.tests;

import org.junit.jupiter.api.Test;
import org.teachingkidsprogramming.typingdeepdive.WordProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordProcessorTest {

    @Test
    void keyTypedDetectsKey() {
        KeyEvent keyEvent = createKeyEvent('a');

        List<Character> actual = new ArrayList<>();
        WordProcessor.keyTyped(keyEvent, e -> actual.add(e));

        assertEquals(actual.get(0), 'a');
    }

    private KeyEvent createKeyEvent(char key) {
        return new KeyEvent(
                new Button(""),
                0,
                0,
                0,
                0,
                key);
    }
}