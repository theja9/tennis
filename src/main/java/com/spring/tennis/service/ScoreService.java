package com.spring.tennis.service;

import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private static final String ALL = "All";
    private static final String DEUCE = "Deuce";
    private static final int TWO = 2;

    public String getScore(int playerOneScore, int playerTwoScore) {
        if (playerOneScore == playerTwoScore) {
            return playerOneScore > TWO ? DEUCE : translateScore(playerOneScore) + " " + ALL;
        }
        return String.format("%s, %s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    public String translateScore(int score) {
        switch (score) {
            case 3:
                return "Forty";
            case 2:
                return "Thirty";
            case 1:
                return "Fifteen";
            case 0:
                return "Love";
        }
        throw new IllegalArgumentException("Illegal score: " + score);
    }

}
