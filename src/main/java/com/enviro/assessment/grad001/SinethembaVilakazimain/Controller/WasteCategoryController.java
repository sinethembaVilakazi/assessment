package com.enviro.assessment.grad001.SinethembaVilakazimain.Controller;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/waste-category")
public class WasteCategoryController {
    @Autowired
    private WasteCategoryService wasteCategoryService;

    /**
     * Constructor injection for WasteCategoryController.
     *
     * @param wasteCategoryService The service for handling WasteCategory operations.
     */
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    /**
     * Get WasteCategory by category name.
     *
     * @param categoryName The name of the waste category to retrieve.(e.g Paper)
     * @return ResponseEntity with WasteCategory if found, otherwise ResponseEntity.notFound().
     */
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<WasteCategory> getWasteCategory(@PathVariable String categoryName) {
        WasteCategory wasteCategory = wasteCategoryService.getWasteCategoryName(categoryName);
        return wasteCategory != null ?
                ResponseEntity.ok(wasteCategory) :
                ResponseEntity.notFound().build();
    }

    /**
     * Get all WasteCategories.
     *
     * @return ResponseEntity with a list of all WasteCategories.
     */
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories(){
        List<WasteCategory> wasteCategories = wasteCategoryService.getAllWasteCategories();
        return ResponseEntity.ok(wasteCategories);
    }

    /**
     * Get WasteCategory by ID.
     *
     * @param id The ID of the waste category to retrieve.
     * @return ResponseEntity with WasteCategory if found, otherwise ResponseEntity.notFound().
     */
    @GetMapping("/{id}")
    public  ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id){
        Optional<WasteCategory> wasteCategory = wasteCategoryService.getWasteCategoryById(id);
        return wasteCategory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create a new WasteCategory.
     *
     * @param wasteCategory The WasteCategory object to create.
     * @return ResponseEntity with the created WasteCategory and HTTP status CREATED.
     */
    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        WasteCategory createdWasteCategory = wasteCategoryService.createWasteCategory(wasteCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWasteCategory);
    }

    /**
     * Update an existing WasteCategory.
     *
     * @param id            The ID of the WasteCategory to update.
     * @param wasteCategory The updated WasteCategory object.
     * @return ResponseEntity with the updated WasteCategory if successful, otherwise ResponseEntity.notFound().
     */
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @RequestBody WasteCategory wasteCategory) {
        WasteCategory updatedWasteCategory = wasteCategoryService.updateWasteCategory(id, wasteCategory);
        return updatedWasteCategory != null ?
                ResponseEntity.ok(updatedWasteCategory) :
                ResponseEntity.notFound().build();
    }

    /**
     * Delete a WasteCategory by ID.
     *
     * @param id The ID of the WasteCategory to delete.
     * @return ResponseEntity with a success message if deletion is successful, otherwise ResponseEntity.notFound().
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWasteCategory(@PathVariable Long id) {
        boolean deleted = wasteCategoryService.deleteWasteCategory(id);
        if (deleted) {
            return ResponseEntity.ok("WasteCategory with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
