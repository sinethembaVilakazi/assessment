package com.enviro.assessment.grad001.SinethembaVilakazimain.Repository;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {

    WasteCategory save(WasteCategory wasteCategory);
    WasteCategory saveAndFlush(WasteCategory wasteCategory);
    void deleteByBiodegradable(boolean biodegradable);
    List<WasteCategory> findByBiodegradable(boolean biodegradable);

    List<WasteCategory> findByRecyclable(boolean recyclable);
    WasteCategory findByNameContainingIgnoreCase(String name);

    List<WasteCategory> findbyType(String type);
}
