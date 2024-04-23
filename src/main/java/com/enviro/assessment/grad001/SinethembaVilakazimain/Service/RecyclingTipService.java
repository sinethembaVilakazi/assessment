package com.enviro.assessment.grad001.SinethembaVilakazimain.Service;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.RecyclingTip;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing RecyclingTip entities.
 */
public interface RecyclingTipService {

    /**
     * Create a new recycling tip.
     *
     * @param recyclingTip The recycling tip to create.
     * @return The created recycling tip.
     */
    RecyclingTip createRecyclingTip(RecyclingTip recyclingTip);

    /**
     * Get a recycling tip by ID.
     *
     * @param id The ID of the recycling tip to retrieve.
     * @return An Optional containing the recycling tip if found, otherwise empty.
     */
    Optional<RecyclingTip> getRecyclingTipById(Long id);

    /**
     * Get all recycling tips.
     *
     * @return A list of all recycling tips.
     */
    List<RecyclingTip> getAllRecyclingTips();

    /**
     * Update an existing recycling tip.
     *
     * @param id            The ID of the recycling tip to update.
     * @param recyclingTip  The updated recycling tip object.
     * @return The updated recycling tip.
     */
    RecyclingTip updateRecyclingTip(Long id, RecyclingTip recyclingTip);

    /**
     * Delete a recycling tip by ID.
     *
     * @param id The ID of the recycling tip to delete.
     */
    boolean deleteRecyclingTip(Long id);

    /**
     * Get all recycling tips for a specific category.
     *
     * @param categoryName The category name for which recycling tips are required.
     * @return A list of recycling tips for the specified category.
     */
    List<RecyclingTip> getRecyclingTipsByCategoryName(String categoryName);
}
