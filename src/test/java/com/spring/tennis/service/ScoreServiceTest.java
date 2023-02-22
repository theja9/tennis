package com.spring.tennis.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ScoreServiceTest {

    @InjectMocks
    ScoreService scoreService;

    @Test
    public void testGetScore() {
        String translatedScore = scoreService.getScore(1, 2);
        assertEquals("Fifteen, Thirty", translatedScore);
    }

}
