package com.enviro.assessment.grad001.SinethembaVilakazimain.Service;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.RecyclingTip;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Repository.RecycleTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RecycleTipServiceImpl implements RecyclingTipService{
    @Autowired
    private RecycleTipRepository recycleTipRepository;


    /**
     * @param recyclingTip
     * @return
     */
    @Override
    public RecyclingTip createRecyclingTip(RecyclingTip recyclingTip) {
        return recycleTipRepository.saveAndFlush(recyclingTip);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<RecyclingTip> getRecyclingTipById(Long id) {
        return recycleTipRepository.findById(id);
    }

    /**
     * @return
     */
    @Override
    public List<RecyclingTip> getAllRecyclingTips() {
        return recycleTipRepository.findAll();
    }

    /**
     * @param id
     * @param recyclingTip
     * @return
     */
    @Override
    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip recyclingTip) {
        if(recycleTipRepository.existsById(id)){
            recyclingTip.setId(id);
            return recycleTipRepository.save(recyclingTip);
        }
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteRecyclingTip(Long id) {
        recycleTipRepository.deleteById(id);
    }

    /**
     * @param wasteCategory
     * @return
     */
    @Override
    public List<RecyclingTip> getRecyclingTipsByWasteCategory(WasteCategory wasteCategory) {
        return recycleTipRepository.findByWasteCategory(wasteCategory);
    }
}
