package com.spring.tennis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TennisController {

    private int playerOneScore;
    private int playerTwoScore;

    @GetMapping("/updateScore")
    public String updateScore(@RequestParam String pointsTo) {
        if (pointsTo.equalsIgnoreCase("playerOne")) {
            playerOneScore++;
        } else if (pointsTo.equalsIgnoreCase("playerTwo")) {
            playerTwoScore++;
        }
        return String.format("%s, %s", playerOneScore, playerTwoScore);
    }

}
