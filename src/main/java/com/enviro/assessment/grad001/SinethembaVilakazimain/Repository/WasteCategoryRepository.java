package com.enviro.assessment.grad001.SinethembaVilakazimain.Repository;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public  interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    Optional<WasteCategory> findByCategoryName(String categoryName);
    WasteCategory save(WasteCategory wasteCategory);

    WasteCategory saveAndFlush(WasteCategory wasteCategory);


    void deleteByBiodegradable(boolean biodegradable);
    List<WasteCategory> findByBiodegradable(boolean biodegradable);

//    Optional<WasteCategory> findByNameContainingIgnoreCase(String categoryName);

//    List<WasteCategory> findbyType(String type);
}
