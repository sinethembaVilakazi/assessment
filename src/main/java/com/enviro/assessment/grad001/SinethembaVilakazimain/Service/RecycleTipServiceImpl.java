package com.enviro.assessment.grad001.SinethembaVilakazimain.Service;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.RecyclingTip;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Repository.RecycleTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of RecyclingTipService interface that provides methods to manage RecyclingTip entities.
 */
@Service
public class RecycleTipServiceImpl implements RecyclingTipService{
    @Autowired
    private RecycleTipRepository recycleTipRepository;


    /**
     * Create a new recycling tip.
     *
     * @param recyclingTip The recycling tip to create.
     * @return The created recycling tip.
     */
    @Override
    public RecyclingTip createRecyclingTip(RecyclingTip recyclingTip) {
        return recycleTipRepository.save(recyclingTip);
    }

    /**
     * Get a recycling tip by ID.
     *
     * @param id The ID of the recycling tip to retrieve.
     * @return An Optional containing the recycling tip if found, otherwise empty.
     */
    @Override
    public Optional<RecyclingTip> getRecyclingTipById(Long id) {
        return recycleTipRepository.findById(id);
    }

    /**
     * Get all recycling tips.
     *
     * @return A list of all recycling tips.
     */
    @Override
    public List<RecyclingTip> getAllRecyclingTips() {
        return recycleTipRepository.findAll();
    }

    /**
     * Update an existing recycling tip.
     *
     * @param id            The ID of the recycling tip to update.
     * @param recyclingTip  The updated recycling tip object.
     * @return The updated recycling tip.
     */
    @Override
    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip recyclingTip) {
        if(recycleTipRepository.existsById(id)){
            recyclingTip.setId(id);
            return recycleTipRepository.save(recyclingTip);
        }
        return null; // Return null if recycling tip with the given ID does not exist
    }

    /**
     * Delete a recycling tip by ID.
     *
     * @param id The ID of the recycling tip to delete.
     */
    @Override
    public  boolean deleteRecyclingTip(Long id) {
        Optional<RecyclingTip> optionalRecyclingTip = recycleTipRepository.findById(id);
        if (optionalRecyclingTip.isPresent()) {
            recycleTipRepository.deleteById(id);
            return true; // Deletion successful
        } else {
            return false; // Category with the given ID not found
        }
    }

    /**
     * Get all recycling tips for a specific category.
     *
     * @param categoryName The category name for which recycling tips are required.
     * @return A list of recycling tips for the specified category.
     */
    @Override
    public List<RecyclingTip> getRecyclingTipsByCategoryName(String categoryName) {
        return recycleTipRepository.findByCategoryName(categoryName);
    }
}
