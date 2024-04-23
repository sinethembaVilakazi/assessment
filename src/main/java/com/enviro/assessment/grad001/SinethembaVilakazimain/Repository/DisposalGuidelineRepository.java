package com.enviro.assessment.grad001.SinethembaVilakazimain.Repository;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.DisposalGuidelines;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing DisposalGuidelines entities.
 */
@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuidelines,Long> {

    /**
     * Find disposal guidelines by category name.
     *
     * @param categoryName The name of the waste category.
     * @return An Optional containing the disposal guidelines for the specified category name.
     */
    Optional<DisposalGuidelines> findByCategoryName(String categoryName);
//    List<DisposalGuidelines> findByWasteCategory(WasteCategory wasteCategory);

    /**
     * Find disposal guidelines by hazardous flag.
     *
     * @param hazardous Flag indicating if the waste is hazardous.
     * @return A list of disposal guidelines with the specified hazardous flag.
     */
    List<DisposalGuidelines> findByHazardous(boolean hazardous);


//    List<DisposalGuidelines> findByWasteCategoryAndHazardous(String categoryName, boolean hazardous);

}
