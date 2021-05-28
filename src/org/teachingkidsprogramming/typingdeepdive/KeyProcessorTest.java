package org.teachingkidsprogramming.typingdeepdive;

import org.teachingkidsprogramming.typingdeepdive.tests.WordType;

import static org.junit.jupiter.api.Assertions.*;

class KeyProcessorTest {

    @org.junit.jupiter.api.Test
    void createsCorrectKeyProcessor() {
        assertEquals(KeyProcessor.createKeyProcessor(new DeepDiveTypingGame(WordType.ENGLISH)).getClass(), WordProcessor.class);
        assertEquals(KeyProcessor.createKeyProcessor(new DeepDiveTypingGame(WordType.FINNISH)).getClass(), WordProcessor.class);
        assertEquals(KeyProcessor.createKeyProcessor(new DeepDiveTypingGame(WordType.HOTKEYS)).getClass(), HotkeyProcessor.class);
    }
}