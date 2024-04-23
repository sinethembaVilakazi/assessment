package com.enviro.assessment.grad001.SinethembaVilakazimain.Service;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the WasteCategoryService interface that provides CRUD operations for WasteCategory entities.
 */
@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {
    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;


    /**
     * Constructs a WasteCategoryServiceImpl with the provided WasteCategoryRepository.
     * @param wasteCategoryRepository The repository to use for database operations.
     */
    public WasteCategoryServiceImpl(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    @Override
    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    @Override
    public Optional<WasteCategory> getWasteCategoryById(Long id) {

        return wasteCategoryRepository.findById(id);
    }

    @Override
    public List<WasteCategory> getAllWasteCategories() {

        return wasteCategoryRepository.findAll();
    }

    @Override
    public WasteCategory updateWasteCategory(Long id, WasteCategory wasteCategory) {
        if(wasteCategoryRepository.existsById(id)){
            wasteCategory.setId(id);
            return wasteCategoryRepository.save(wasteCategory);
        }
        return null;
    }

    @Override
    public boolean deleteWasteCategory(Long id) {
        Optional<WasteCategory> optionalWasteCategory = wasteCategoryRepository.findById(id);
        if (optionalWasteCategory.isPresent()) {
            wasteCategoryRepository.deleteById(id);
            return true; // Deletion successful
        } else {
            return false; // Category with the given ID not found
        }

    }

    @Override
    public WasteCategory getWasteCategoryName(String categoryName) {
        return wasteCategoryRepository.findByCategoryName(categoryName)
                .orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));
    }
}
