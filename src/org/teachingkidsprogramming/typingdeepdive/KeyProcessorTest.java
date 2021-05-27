package org.teachingkidsprogramming.typingdeepdive;

import static org.junit.jupiter.api.Assertions.*;

class KeyProcessorTest {

    @org.junit.jupiter.api.Test
    void createsCorrectKeyProcessor() {
        assertEquals(KeyProcessor.createKeyProcessor(new DeepDiveTypingGame()).getClass(), KeyProcessor.class);
    }
}