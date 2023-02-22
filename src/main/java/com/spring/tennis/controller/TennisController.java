package com.spring.tennis.controller;

import com.spring.tennis.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TennisController {

    @Autowired
    private PlayerService players;

    @GetMapping("/updateScore")
    public String updateScore(@RequestParam String pointsTo) {
        if (pointsTo.equalsIgnoreCase("playerOne")) {
            players.playerOneScores();
        } else if (pointsTo.equalsIgnoreCase("playerTwo")) {
            players.playerTwoScores();
        }
        return String.format("%s , %s ", players.getPlayerOnePoints(), players.getPlayerTwoPoints());
    }

}
