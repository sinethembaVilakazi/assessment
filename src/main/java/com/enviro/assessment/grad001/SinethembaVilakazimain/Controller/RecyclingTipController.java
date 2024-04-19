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

@RestController
@RequestMapping("/api/recycling-tips")
@Validated
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        List<RecyclingTip> recyclingTips = recyclingTipService.getAllRecyclingTips();
        return ResponseEntity.ok(recyclingTips);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        Optional<RecyclingTip> recyclingTip = recyclingTipService.getRecyclingTipById(id);
        return recyclingTip.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<RecyclingTip> createRecyclingTip(@Valid @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip createdRecyclingTip = recyclingTipService.createRecyclingTip(recyclingTip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecyclingTip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id,
                                                           @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip updatedRecyclingTip = recyclingTipService.updateRecyclingTip(id, recyclingTip);
        return updatedRecyclingTip != null ?
                ResponseEntity.ok(updatedRecyclingTip) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }
}
