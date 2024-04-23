package com.enviro.assessment.grad001.SinethembaVilakazimain.Service;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.DisposalGuidelines;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.RecyclingTip;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing DisposalGuidelines entities.
 */
@Service
public class DisposalGuidelineServiceImpl implements DisposalGuidlineService{
    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;


    /**
     * Create a new DisposalGuidelines entity.
     *
     * @param disposalGuidelines The DisposalGuidelines object to be created.
     * @return The created DisposalGuidelines object.
     */
    @Override
    public DisposalGuidelines createDisposalGuidelines(DisposalGuidelines disposalGuidelines) {
        return disposalGuidelineRepository.save(disposalGuidelines);
    }

    /**
     * Retrieve a DisposalGuidelines entity by its ID.
     *
     * @param id The ID of the DisposalGuidelines entity to retrieve.
     * @return An Optional containing the DisposalGuidelines object if found, otherwise empty.
     */
    @Override
    public Optional<DisposalGuidelines> getDisposalGuidelineId(Long id) {
        return disposalGuidelineRepository.findById(id);
    }

    /**
     * Retrieve all DisposalGuidelines entities.
     *
     * @return A list of all DisposalGuidelines objects.
     */
    @Override
    public List<DisposalGuidelines> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    /**
     * Update an existing DisposalGuidelines entity.
     *
     * @param id                 The ID of the DisposalGuidelines entity to update.
     * @param disposalGuidelines The updated DisposalGuidelines object.
     * @return The updated DisposalGuidelines object if the update is successful, otherwise null.
     */
    @Override
    public DisposalGuidelines updateDisposalGuideline(Long id, DisposalGuidelines disposalGuidelines) {
        if(disposalGuidelineRepository.existsById(id)){
            disposalGuidelines.setId(id);
            return disposalGuidelineRepository.save(disposalGuidelines);
        }

        return null;
    }

    /**
     * Delete a DisposalGuidelines entity by its ID.
     *
     * @param id The ID of the DisposalGuidelines entity to delete.
     * @return true if the deletion is successful, false otherwise.
     */
    @Override
    public boolean deleteDisposalGuidelines(Long id) {
        Optional<DisposalGuidelines> optionalDisposalGuidelines = disposalGuidelineRepository.findById(id);
        if (optionalDisposalGuidelines.isPresent()) {
            disposalGuidelineRepository.deleteById(id);
            return true; // Deletion successful
        } else {
            return false; // Category with the given ID not found
        }
    }

//    @Override
//    public List<DisposalGuidelines> getDisposalGuidelinesbyWasteCategory(WasteCategory wasteCategory) {
//        return disposalGuidelineRepository.findByWasteCategory(wasteCategory);
//    }
}
