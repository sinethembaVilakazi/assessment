package com.enviro.assessment.grad001.SinethembaVilakazimain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Service.WasteCategoryService;
import org.junit.jupiter.api.BeforeEach;
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
public class WasteCategoryControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // ObjectMapper for JSON serialization/deserialization

    private Long categoryId;

//    @BeforeEach
//    public void setup() {
//        // Create a WasteCategory before each test
//        WasteCategory wasteCategory = new WasteCategory();
//        wasteCategory.setCategoryName("Plastic");
//        wasteCategory.setBiodegradable(false);
//        wasteCategory.setType("Recyclable");
//
//        WasteCategory createdCategory = WasteCategoryService.createWasteCategory(wasteCategory);
//        categoryId = createdCategory.getId();
//    }

    @Test
    public void testCreateWasteCategory() throws Exception {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setCategoryName("Plastic");
        wasteCategory.setBiodegradable(false);
        wasteCategory.setType("Recyclable");

        // Convert WasteCategory object to JSON
        String requestBody = objectMapper.writeValueAsString(wasteCategory);

        // Perform POST request to create waste category Expect HTTP 201 Created status
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/waste-category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andReturn();
        ;
    }

    @Test
    public void testGetWasteCategoryById() throws Exception {
        Long categoryId = 1L;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/waste-category/{id}", categoryId))
                .andExpect(status().isOk()) // Expect HTTP 200 OK status
                .andExpect(jsonPath("$.id").value(categoryId)); // Check response JSON content
    }

    @Test
    public void testUpdateWasteCategory() throws Exception {
        Long categoryId = 1L;
        WasteCategory updatedCategory = new WasteCategory();
        updatedCategory.setCategoryName("Updated Plastic");
        updatedCategory.setBiodegradable(true);
        updatedCategory.setType("Reusable");

        String requestBody = objectMapper.writeValueAsString(updatedCategory);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/waste-category/{id}", categoryId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk()) // Expect HTTP 200 OK status after update
                .andExpect(jsonPath("$.categoryName").value(updatedCategory.getCategoryName())); // Check updated content
    }

    @Test
    public void testDeleteWasteCategory() throws Exception {
        Long categoryId = 4L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/waste-category/{id}", categoryId))
                .andExpect(status().isNoContent()); // Expect HTTP 204 No Content after successful deletion
    }


}
