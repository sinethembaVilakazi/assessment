package com.enviro.assessment.grad001.SinethembaVilakazimain.Service;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * Interface that defines operations for managing WasteCategory entities.
 */
public interface WasteCategoryService {
    /**
     * Creates a new WasteCategory entity.
     *
     * @param wasteCategory The WasteCategory object to create.
     * @return The created WasteCategory entity.
     */
    WasteCategory createWasteCategory(WasteCategory wasteCategory);

    /**
     * Retrieves a WasteCategory entity by its ID.
     *
     * @param id The ID of the WasteCategory to retrieve.
     * @return An Optional containing the WasteCategory, or empty if not found.
     */
    Optional<WasteCategory> getWasteCategoryById(Long id);

    /**
     * Retrieves all WasteCategory entities.
     *
     * @return A list of all WasteCategory entities.
     */
    List<WasteCategory> getAllWasteCategories();

    /**
     * Updates an existing WasteCategory entity.
     *
     * @param id            The ID of the WasteCategory to update.
     * @param wasteCategory The updated WasteCategory object.
     * @return The updated WasteCategory entity, or null if not found.
     */
    WasteCategory updateWasteCategory(Long id,WasteCategory wasteCategory);

    /**
     * Deletes a WasteCategory entity by its ID.
     *
     * @param id The ID of the WasteCategory to delete.
     * @return true if deletion was successful, false otherwise.
     */
    boolean deleteWasteCategory(Long id);

    /**
     * Retrieves a WasteCategory entity by its name.
     *
     * @param categoryName The name of the WasteCategory to retrieve.
     * @return The WasteCategory with the specified name.
     * @throws ResourceNotFoundException if the WasteCategory is not found.
     */
    WasteCategory getWasteCategoryName(String categoryName);

//    List<WasteCategory> getWasteCategoryByType(String type);
}
