package com.enviro.assessment.grad001.SinethembaVilakazimain.Service;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.RecyclingTip;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;

import java.util.List;
import java.util.Optional;
public interface RecyclingTipService {
    RecyclingTip createRecyclingTip(RecyclingTip recyclingTip);
    Optional<RecyclingTip> getRecyclingTipById(Long id);

    List<RecyclingTip> getAllRecyclingTips();

    RecyclingTip updateRecyclingTip(Long id, RecyclingTip recyclingTip);

    void deleteRecyclingTip(Long id);

    List<RecyclingTip> getRecyclingTipsByCategoryName(String categoryName);
}
