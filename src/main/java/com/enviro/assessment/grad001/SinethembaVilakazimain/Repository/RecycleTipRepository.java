package com.enviro.assessment.grad001.SinethembaVilakazimain.Repository;


import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.RecyclingTip;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecycleTipRepository extends JpaRepository<RecyclingTip,Long> {
    List<RecyclingTip> findByCategoryName(String categoryName);

//    List<RecyclingTip> findByTipInfoContainingIgnoreCase(String keyword);

    RecyclingTip findByCategoryNameAndId(String categoryName, Long id);

    // updating tip information
    RecyclingTip save(RecyclingTip recyclingTip);

    // deleting a tip by waste category name and id
    void deleteByCategoryNameAndId(String categoryName, Long id);



}
