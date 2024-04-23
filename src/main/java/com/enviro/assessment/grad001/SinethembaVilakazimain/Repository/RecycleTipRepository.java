package com.enviro.assessment.grad001.SinethembaVilakazimain.Repository;


import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.RecyclingTip;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository interface for managing RecyclingTip entities.
 */
@Repository
public interface RecycleTipRepository extends JpaRepository<RecyclingTip,Long> {

    /**
     * Find recycling tips by category name.
     *
     * @param categoryName The category name to search for.
     * @return A list of recycling tips with the specified category name.
     */
    List<RecyclingTip> findByCategoryName(String categoryName);

//    List<RecyclingTip> findByTipInfoContainingIgnoreCase(String keyword);

    /**
     * Find a recycling tip by category name and ID.
     *
     * @param categoryName The category name of the recycling tip.
     * @param id           The ID of the recycling tip.
     * @return The recycling tip with the specified category name and ID.
     */
    RecyclingTip findByCategoryNameAndId(String categoryName, Long id);

//    RecyclingTip findById(Long id);
    /**
     * Save or update a recycling tip.
     *
     * @param recyclingTip The recycling tip to save or update.
     * @return The saved recycling tip.
     */
    @Override
    RecyclingTip save(RecyclingTip recyclingTip);

    /**
     * Delete a recycling tip by category name and ID.
     *
     * @param categoryName The category name of the recycling tip to delete.
     * @param id           The ID of the recycling tip to delete.
     */
    void deleteByCategoryNameAndId(String categoryName, Long id);



}
