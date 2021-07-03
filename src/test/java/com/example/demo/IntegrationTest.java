package com.example.demo;

import com.example.demo.beans.Trainer;
import com.example.demo.controller.TrainerController;
import com.example.demo.response.TrainerResponse;
import com.example.demo.service.TrainerService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

//todo 我兴高采烈的点开测试，你就给我看这个？拉了拉了

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
