package com.enviro.assessment.grad001.SinethembaVilakazimain.Service;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.DisposalGuidelines;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;

import java.util.List;
import java.util.Optional;


public interface DisposalGuidlineService {
    DisposalGuidelines createDisposalGuidelines(DisposalGuidelines disposalGuidelines);

    Optional<DisposalGuidelines> getDisposalGuidelineId(Long id);

    List<DisposalGuidelines> getAllDisposalGuidelines();

    DisposalGuidelines updateDisposalGuideline(Long id,DisposalGuidelines disposalGuidelines);

    void deleteDisposalGuidelines(Long id);

    List<DisposalGuidelines> getDisposalGuidelinesbyWasteCategory(WasteCategory wasteCategory);
}
