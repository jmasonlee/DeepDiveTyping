package org.teachingkidsprogramming.typingdeepdive;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class WordProcessorTest {

    @Test
    void keyTypedDetectsKey() {
        DeepDiveTypingGameFake game = new DeepDiveTypingGameFake();
        KeyEvent keyEvent = new KeyEvent(new Button("b"), 1, 20, 1, 10, 'a');
        WordProcessor wordProcessor = new WordProcessor(game);

        wordProcessor.keyTyped(keyEvent);

        assertEquals(game.letter, keyEvent.getKeyChar());
    }

    @Test
    void keyPressedDoesNothing() {
        DeepDiveTypingGameFake game = new DeepDiveTypingGameFake();
        KeyEvent keyEvent = new KeyEvent(new Button("b"), 1, 20, 1, 10, 'a');
        WordProcessor wordProcessor = new WordProcessor(game);

        wordProcessor.keyPressed(keyEvent);

        assertEquals(game.letter, Character.MIN_VALUE);
    }

    @Test
    void keyReleasedDetectsKey() {
        DeepDiveTypingGameFake game = new DeepDiveTypingGameFake();
        KeyEvent keyEvent = new KeyEvent(new Button("b"), 1, 20, 1, 10, 'a');
        WordProcessor wordProcessor = new WordProcessor(game);

        wordProcessor.keyReleased(keyEvent);

        assertEquals(game.letter, Character.MIN_VALUE);
    }

    class DeepDiveTypingGameFake extends DeepDiveTypingGame {
        char letter = Character.MIN_VALUE;

        @Override
        public void processLetter(char letter) {
            this.letter = letter;
        }
    }
}