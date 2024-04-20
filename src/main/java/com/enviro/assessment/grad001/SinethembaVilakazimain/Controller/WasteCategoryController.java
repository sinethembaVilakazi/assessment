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
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<WasteCategory> getWasteCategory(@PathVariable String categoryName) {
        WasteCategory wasteCategory = wasteCategoryService.getWasteCategoryName(categoryName);
        return wasteCategory != null ?
                ResponseEntity.ok(wasteCategory) :
                ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories(){
        List<WasteCategory> wasteCategories = wasteCategoryService.getAllWasteCategories();
        return ResponseEntity.ok(wasteCategories);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id){
        Optional<WasteCategory> wasteCategory = wasteCategoryService.getWasteCategoryById(id);
        return wasteCategory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        WasteCategory createdWasteCategory = wasteCategoryService.createWasteCategory(wasteCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWasteCategory);
    }
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @RequestBody WasteCategory wasteCategory) {
        WasteCategory updatedWasteCategory = wasteCategoryService.updateWasteCategory(id, wasteCategory);
        return updatedWasteCategory != null ?
                ResponseEntity.ok(updatedWasteCategory) :
                ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }


}
