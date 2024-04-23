package com.enviro.assessment.grad001.SinethembaVilakazimain.Controller;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.RecyclingTip;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller class for managing RecyclingTip entities via REST endpoints.
 */
@RestController
@RequestMapping("/api/recycling-tips")
@Validated
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    /**
     * Get all recycling tips.
     *
     * @return ResponseEntity with a list of all recycling tips and HTTP status 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        List<RecyclingTip> recyclingTips = recyclingTipService.getAllRecyclingTips();
        return ResponseEntity.ok(recyclingTips);
    }

    /**
     * Get a recycling tip by ID.
     *
     * @param id The ID of the recycling tip to retrieve.
     * @return ResponseEntity with the recycling tip if found (HTTP status 200 - OK), or not found (HTTP status 404 - Not Found).
     */
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        Optional<RecyclingTip> recyclingTip = recyclingTipService.getRecyclingTipById(id);
        return recyclingTip.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create a new recycling tip.
     *
     * @param recyclingTip The recycling tip to create.
     * @return ResponseEntity with the created recycling tip and HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<RecyclingTip> createRecyclingTip(@Valid @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip createdRecyclingTip = recyclingTipService.createRecyclingTip(recyclingTip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecyclingTip);
    }

    /**
     * Update an existing recycling tip.
     *
     * @param id            The ID of the recycling tip to update.
     * @param recyclingTip  The updated recycling tip object.
     * @return ResponseEntity with the updated recycling tip if successful (HTTP status 200 - OK), or not found (HTTP status 404 - Not Found).
     */
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id,
                                                           @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip updatedRecyclingTip = recyclingTipService.updateRecyclingTip(id, recyclingTip);
        return updatedRecyclingTip != null ?
                ResponseEntity.ok(updatedRecyclingTip) :
                ResponseEntity.notFound().build();
    }

    /**
     * Delete a recycling tip by ID.
     *
     * @param id The ID of the recycling tip to delete.
     * @return ResponseEntity containing a success message if deletion is successful, otherwise return HTTP status 404 (Not Found).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecyclingTip(@PathVariable Long id) {
        boolean deleted = recyclingTipService.deleteRecyclingTip(id);
        if (deleted) {
            return ResponseEntity.ok("Recycle tip with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }}
}
