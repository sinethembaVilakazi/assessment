package com.enviro.assessment.grad001.SinethembaVilakazimain.Controller;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.DisposalGuidelines;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Service.DisposalGuidlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller class for handling endpoints related to Disposal Guidelines.
 */
@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidlineService disposalGuidelineService;

    /**
     * Get all disposal guidelines.
     *
     * @return ResponseEntity with the list of all disposal guidelines and HTTP status 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<DisposalGuidelines>> getAllDisposalGuidelines() {
        List<DisposalGuidelines> disposalGuidelines = disposalGuidelineService.getAllDisposalGuidelines();
        return ResponseEntity.ok(disposalGuidelines);
    }

    /**
     * Get a disposal guideline by ID.
     *
     * @param id The ID of the disposal guideline to retrieve.
     * @return ResponseEntity with the retrieved disposal guideline or HTTP status 404 (Not Found) if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> getDisposalGuidelineById(@PathVariable Long id) {
        Optional<DisposalGuidelines> disposalGuideline = disposalGuidelineService.getDisposalGuidelineId(id);
        return disposalGuideline.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create a new disposal guideline.
     *
     * @param disposalGuideline The DisposalGuidelines object representing the new guideline.
     * @return ResponseEntity with the created disposal guideline and HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<DisposalGuidelines> createDisposalGuideline(@RequestBody DisposalGuidelines disposalGuideline) {
        DisposalGuidelines createdDisposalGuideline = disposalGuidelineService.createDisposalGuidelines(disposalGuideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDisposalGuideline);
    }

    /**
     * Update an existing disposal guideline by ID.
     *
     * @param id                The ID of the disposal guideline to update.
     * @param disposalGuideline The updated DisposalGuidelines object.
     * @return ResponseEntity with the updated disposal guideline or HTTP status 404 (Not Found) if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> updateDisposalGuideline(@PathVariable Long id,
                                                                     @RequestBody DisposalGuidelines disposalGuideline) {
        DisposalGuidelines updatedDisposalGuideline = disposalGuidelineService.updateDisposalGuideline(id, disposalGuideline);
        return updatedDisposalGuideline != null ?
                ResponseEntity.ok(updatedDisposalGuideline) :
                ResponseEntity.notFound().build();
    }

    /**
     * Delete a disposal guideline by ID.
     *
     * @param id The ID of the disposal guideline to delete.
     * @return ResponseEntity with a success message upon successful deletion or HTTP status 404 (Not Found) if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDisposalGuideline(@PathVariable Long id) {
        boolean deleted = disposalGuidelineService.deleteDisposalGuidelines(id);
        if (deleted) {
            return ResponseEntity.ok("Disposal guideline with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }}
}
