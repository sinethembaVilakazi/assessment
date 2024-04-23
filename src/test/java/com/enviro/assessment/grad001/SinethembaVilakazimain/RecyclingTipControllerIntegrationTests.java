package com.enviro.assessment.grad001.SinethembaVilakazimain;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.RecyclingTip;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RecyclingTipControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateRecyclingTip() throws Exception {
        RecyclingTip recyclingTip = new RecyclingTip();
        recyclingTip.setCategoryName("Category");
        recyclingTip.setTip("Recycling tip content");

        ResultActions resultActions = mockMvc.perform(post("/api/recycling-tips")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recyclingTip)));

        resultActions.andExpect(status().isCreated());
    }

    @Test
    public void testGetRecyclingTipById() throws Exception {
        Long id = 3L;
        ResultActions resultActions = mockMvc.perform(get("/api/recycling-tips/{id}", id));
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void testUpdateRecyclingTip() throws Exception {
        Long id = 1L;
        RecyclingTip updatedRecyclingTip = new RecyclingTip();
        updatedRecyclingTip.setCategoryName("Updated Category");
        updatedRecyclingTip.setTip("Updated recycling tip content");

        ResultActions resultActions = mockMvc.perform(put("/api/recycling-tips/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedRecyclingTip)));

        resultActions.andExpect(status().isOk());
    }

    @Test
    public void testDeleteRecyclingTip() throws Exception {
        Long id = 2L;
        ResultActions resultActions = mockMvc.perform(delete("/api/recycling-tips/{id}", id));

        resultActions.andExpect(status().isOk());
    }


}

