package com.spring.tennis.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ScoreServiceTest {

    @InjectMocks
    ScoreService scoreService;

    @ParameterizedTest
    @CsvSource({
            "0,0,Love All",
            "1,1,Fifteen All",
            "2,2,Thirty All",
            "3,3,Deuce",
            "3,4,PlayerTwo Advantage",
            "4,3,PlayerOne Advantage",
            "4,6,PlayerTwo Wins",
            "6,4,PlayerOne Wins",
    })
    public void testGetScore(int playerOnePoints, int playerTwoPoints, String expectedScore) {
        String translatedScore = scoreService.getScore(playerOnePoints, playerTwoPoints);
        assertEquals(expectedScore, translatedScore);
    }

}
