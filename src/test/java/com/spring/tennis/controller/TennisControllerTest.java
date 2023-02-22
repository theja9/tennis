package com.spring.tennis.controller;

import com.spring.tennis.service.PlayerService;
import com.spring.tennis.service.ScoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TennisController.class)
public class TennisControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private PlayerService players;

    @MockBean
    private ScoreService scoreService;

    @Test
    public void testUpdateScore() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/tennis/updateScore?pointsTo=playerOne");
        mockmvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void testGetScore() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/tennis/getScore");
        mockmvc.perform(request)
                .andExpect(status().isOk());
    }

}
