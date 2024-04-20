package com.enviro.assessment.grad001.SinethembaVilakazimain.Service;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.DisposalGuidelines;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DisposalGuidelineServiceImpl implements DisposalGuidlineService{
    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;
    @Override
    public DisposalGuidelines createDisposalGuidelines(DisposalGuidelines disposalGuidelines) {
        return disposalGuidelineRepository.save(disposalGuidelines);
    }

    @Override
    public Optional<DisposalGuidelines> getDisposalGuidelineId(Long id) {
        return disposalGuidelineRepository.findById(id);
    }

    @Override
    public List<DisposalGuidelines> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    @Override
    public DisposalGuidelines updateDisposalGuideline(Long id, DisposalGuidelines disposalGuidelines) {
        if(disposalGuidelineRepository.existsById(id)){
            disposalGuidelines.setId(id);
            return disposalGuidelineRepository.save(disposalGuidelines);
        }

        return null;
    }

    @Override
    public void deleteDisposalGuidelines(Long id) {
        disposalGuidelineRepository.deleteById(id);

    }

//    @Override
//    public List<DisposalGuidelines> getDisposalGuidelinesbyWasteCategory(WasteCategory wasteCategory) {
//        return disposalGuidelineRepository.findByWasteCategory(wasteCategory);
//    }
}
