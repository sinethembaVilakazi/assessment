package com.enviro.assessment.grad001.SinethembaVilakazimain.Repository;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.DisposalGuidelines;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuidelines,Long> {
    List<DisposalGuidelines> findByWasteCategory(WasteCategory wasteCategory);

    List<DisposalGuidelines> findByHazardous(boolean hazardous);

    List<DisposalGuidelines> findByWasteCategoryAndHazardous(WasteCategory wasteCategory, boolean hazardous);

}