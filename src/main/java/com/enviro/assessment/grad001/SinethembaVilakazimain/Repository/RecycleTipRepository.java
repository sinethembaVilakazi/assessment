package com.enviro.assessment.grad001.SinethembaVilakazimain.Repository;


import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.RecyclingTip;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecycleTipRepository extends JpaRepository<RecyclingTip,Long> {
    List<RecyclingTip> findByWasteCategory(WasteCategory wasteCategory);

    List<RecyclingTip> findByTipInfoContainingIgnoreCase(String keyword);

    RecyclingTip findByWasteCategoryAndId(WasteCategory wasteCategory, Long id);

    // updating tip information
    RecyclingTip saveAndFlush(RecyclingTip recyclingTip);

    // deleting a tip by waste category and id
    void deleteByWasteCategoryAndId(WasteCategory wasteCategory, Long id);

}
