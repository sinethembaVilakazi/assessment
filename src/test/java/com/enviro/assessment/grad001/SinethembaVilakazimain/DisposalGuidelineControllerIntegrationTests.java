package com.enviro.assessment.grad001.SinethembaVilakazimain;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.DisposalGuidelines;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DisposalGuidelineControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void testGetDisposalGuidelinesById() throws Exception {
        Long guidelineId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/disposal-guidelines/{id}", guidelineId))
                .andExpect(status().isOk()) // Expect HTTP 200 OK status
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Expect JSON response
                .andExpect(jsonPath("$.id").value(guidelineId)) // Check response JSON content
                .andExpect(jsonPath("$.disposalMethods").value("Dispose of plastic waste in designated bins."));
    }

    @Test
    public void testCreateDisposalGuidelines() throws Exception {
        DisposalGuidelines newGuideline = new DisposalGuidelines();
        newGuideline.setCategoryName("Plastic");
        newGuideline.setDisposalMethods("Dispose of plastic waste in designated bins.");

        String requestBody = objectMapper.writeValueAsString(newGuideline);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/disposal-guidelines")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated()) // Expect HTTP 201 Created status
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Expected JSON response
                .andExpect(jsonPath("$.categoryName").value(newGuideline.getCategoryName()));
    }

    @Test
    public void testUpdateDisposalGuidelines() throws Exception {
        Long guidelineId = 1L;
        DisposalGuidelines updatedGuideline = new DisposalGuidelines();
        updatedGuideline.setCategoryName("Updated Plastic");
        updatedGuideline.setDisposalMethods("Updated recycling instructions.");

        String requestBody = objectMapper.writeValueAsString(updatedGuideline);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/disposal-guidelines/{id}", guidelineId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk()) // Expect HTTP 200 OK status after update
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Expected JSON response
                .andExpect(jsonPath("$.categoryName").value(updatedGuideline.getCategoryName()));
    }

    @Test
    public void testDeleteDisposalGuidelines() throws Exception {
        Long guidelineId = 3L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/disposal-guidelines/{id}", guidelineId))
                .andExpect(status().isNoContent()); // Expect HTTP 204 No Content after successful deletion
    }



}
