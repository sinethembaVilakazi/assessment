package com.enviro.assessment.grad001.SinethembaVilakazimain.Service;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.DisposalGuidelines;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing DisposalGuidelines entities.
 */
public interface DisposalGuidlineService {

    /**
     * Create a new DisposalGuidelines entity.
     *
     * @param disposalGuidelines The DisposalGuidelines object to be created.
     * @return The created DisposalGuidelines object.
     */
    DisposalGuidelines createDisposalGuidelines(DisposalGuidelines disposalGuidelines);

    /**
     * Retrieve a DisposalGuidelines entity by its ID.
     *
     * @param id The ID of the DisposalGuidelines entity to retrieve.
     * @return An Optional containing the DisposalGuidelines object if found, otherwise empty.
     */

    Optional<DisposalGuidelines> getDisposalGuidelineId(Long id);

    /**
     * Retrieve all DisposalGuidelines entities.
     *
     * @return A list of all DisposalGuidelines objects.
     */
    List<DisposalGuidelines> getAllDisposalGuidelines();

    /**
     * Update an existing DisposalGuidelines entity.
     *
     * @param id                 The ID of the DisposalGuidelines entity to update.
     * @param disposalGuidelines The updated DisposalGuidelines object.
     * @return The updated DisposalGuidelines object.
     */
    DisposalGuidelines updateDisposalGuideline(Long id,DisposalGuidelines disposalGuidelines);

    /**
     * Delete a DisposalGuidelines entity by its ID.
     *
     * @param id The ID of the DisposalGuidelines entity to delete.
     * @return true if the deletion is successful, false otherwise.
     */
    boolean deleteDisposalGuidelines(Long id);

//    List<DisposalGuidelines> getDisposalGuidelinesbyWasteCategory(WasteCategory wasteCategory);
}
