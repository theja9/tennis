package com.spring.tennis.service;

import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private static final String ALL = "All";
    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE = "Advantage";
    private static final String WINS = "Wins";
    private static final String PLAYER_ONE = "PlayerOne";
    private static final String PLAYER_TWO = "PlayerTwo";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final String SPACE = " ";
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";

    public String getScore(int playerOneScore, int playerTwoScore) {
        if (playerOneScore == playerTwoScore) {
            return playerOneScore > TWO ? DEUCE : translateScore(playerOneScore) + SPACE + ALL;
        } else if (Math.max(playerOneScore, playerTwoScore) > THREE) {
            String score = isPointDifferenceOne(playerOneScore, playerTwoScore) ? ADVANTAGE : WINS;
            return getHighestScorer(playerOneScore, playerTwoScore) + SPACE + score;
        }
        return String.format("%s %s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    private boolean isPointDifferenceOne(int playerOneScore, int playerTwoScore) {
        return Math.abs(playerOneScore - playerTwoScore) == ONE;
    }

    private String getHighestScorer(int playerOneScore, int playerTwoScore) {
        return playerOneScore > playerTwoScore ? PLAYER_ONE : PLAYER_TWO;
    }

    public String translateScore(int score) {
        switch (score) {
            case THREE:
                return FORTY;
            case TWO:
                return THIRTY;
            case ONE:
                return FIFTEEN;
            case ZERO:
                return LOVE;
        }
        throw new IllegalArgumentException("Illegal score: " + score);
    }

}
