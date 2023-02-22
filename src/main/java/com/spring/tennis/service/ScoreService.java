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
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final String SPACE = " ";

    public String getScore(int playerOneScore, int playerTwoScore) {
        if (playerOneScore == playerTwoScore) {
            return playerOneScore > TWO ? DEUCE : translateScore(playerOneScore) + SPACE + ALL;
        } else if (Math.max(playerOneScore, playerTwoScore) > THREE) {
            if (playerOneScore == playerTwoScore + ONE) {
                return PLAYER_ONE + SPACE + ADVANTAGE;
            }
            if (playerTwoScore == playerOneScore + ONE) {
                return PLAYER_TWO + SPACE + ADVANTAGE;
            }
            if (playerOneScore == playerTwoScore + TWO) {
                return PLAYER_ONE + SPACE + WINS;
            }
            if (playerTwoScore == playerOneScore + TWO) {
                return PLAYER_TWO + SPACE + WINS;
            }
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
