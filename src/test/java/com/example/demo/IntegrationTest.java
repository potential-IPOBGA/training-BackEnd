package com.example.demo;

import com.example.demo.beans.Trainer;
import com.example.demo.controller.TrainerController;
import com.example.demo.response.TrainerResponse;
import com.example.demo.service.TrainerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(TrainerController.class)
@AutoConfigureJsonTesters
public class IntegrationTest {
    @MockBean
    private TrainerService trainerService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JacksonTester<TrainerService> trainerServiceJacksonTester;
    @Autowired
    private JacksonTester<TrainerResponse> trainerResponseJacksonTester;

    private Trainer initTrainer;

    @BeforeEach
    public void beforeEach() {
        initTrainer = Trainer.builder()
                .id(1L)
                .name("Christopher")
                .grouped(false)
                .build();
    }
}
