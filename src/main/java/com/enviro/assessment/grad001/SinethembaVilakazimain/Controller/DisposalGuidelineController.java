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

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidlineService disposalGuidelineService;

    @GetMapping
    public ResponseEntity<List<DisposalGuidelines>> getAllDisposalGuidelines() {
        List<DisposalGuidelines> disposalGuidelines = disposalGuidelineService.getAllDisposalGuidelines();
        return ResponseEntity.ok(disposalGuidelines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> getDisposalGuidelineById(@PathVariable Long id) {
        Optional<DisposalGuidelines> disposalGuideline = disposalGuidelineService.getDisposalGuidelineId(id);
        return disposalGuideline.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DisposalGuidelines> createDisposalGuideline(@RequestBody DisposalGuidelines disposalGuideline) {
        DisposalGuidelines createdDisposalGuideline = disposalGuidelineService.createDisposalGuidelines(disposalGuideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDisposalGuideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> updateDisposalGuideline(@PathVariable Long id,
                                                                     @RequestBody DisposalGuidelines disposalGuideline) {
        DisposalGuidelines updatedDisposalGuideline = disposalGuidelineService.updateDisposalGuideline(id, disposalGuideline);
        return updatedDisposalGuideline != null ?
                ResponseEntity.ok(updatedDisposalGuideline) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteDisposalGuidelines(id);
        return ResponseEntity.noContent().build();
    }
}
