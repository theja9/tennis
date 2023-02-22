package com.spring.tennis.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TennisController.class)
public class TennisControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @Test
    public void testIncrement() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/updateScore?pointsTo=playerOne");
        mockmvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("1, 0"))
                .andReturn();
    }

}
