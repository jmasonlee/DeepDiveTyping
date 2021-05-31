package org.teachingkidsprogramming.typingdeepdive.tests;

import org.junit.jupiter.api.Assertions;
import org.teachingkidsprogramming.typingdeepdive.DeepDiveTypingGame;
import org.teachingkidsprogramming.typingdeepdive.HotkeyProcessor;
import org.teachingkidsprogramming.typingdeepdive.KeyProcessor;
import org.teachingkidsprogramming.typingdeepdive.WordProcessor;
import org.teachingkidsprogramming.typingdeepdive.tests.WordType;

import static org.junit.jupiter.api.Assertions.*;

class KeyProcessorTest {

    @org.junit.jupiter.api.Test
    void createsCorrectKeyProcessor() {
        Assertions.assertEquals(KeyProcessor.createKeyProcessor(new DeepDiveTypingGame(WordType.ENGLISH)).getClass(), WordProcessor.class);
        assertEquals(KeyProcessor.createKeyProcessor(new DeepDiveTypingGame(WordType.FINNISH)).getClass(), WordProcessor.class);
        assertEquals(KeyProcessor.createKeyProcessor(new DeepDiveTypingGame(WordType.HOTKEYS)).getClass(), HotkeyProcessor.class);
    }
}