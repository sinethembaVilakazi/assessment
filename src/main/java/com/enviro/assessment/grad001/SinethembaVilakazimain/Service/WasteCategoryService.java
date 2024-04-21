package com.enviro.assessment.grad001.SinethembaVilakazimain.Service;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;

import java.util.List;
import java.util.Optional;
public interface WasteCategoryService {
    WasteCategory createWasteCategory(WasteCategory wasteCategory);

    Optional<WasteCategory> getWasteCategoryById(Long id);

    List<WasteCategory> getAllWasteCategories();

    WasteCategory updateWasteCategory(Long id,WasteCategory wasteCategory);

    boolean deleteWasteCategory(Long id);

    WasteCategory getWasteCategoryName(String categoryName);

//    List<WasteCategory> getWasteCategoryByType(String type);
}
