package com.enviro.assessment.grad001.SinethembaVilakazimain;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.DisposalGuidelines;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {
    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Populate waste categories and disposal guidelines during application startup
        WasteCategory category1 = new WasteCategory();
        WasteCategory wasteCategory1 = new WasteCategory(null, "Paper Waste",  true, "Recyclable");
        category1.setCategoryName("Plastic");

        DisposalGuidelines guideline1 = new DisposalGuidelines();
        guideline1.setCategoryName("Plastic");
        guideline1.setDisposalMethods("Recycle plastics with recycling code 1-7. Clean and dry items before recycling.");
//        guideline1.setRecyclingTip("Reuse plastic containers whenever possible.");

        // Save to database
        wasteCategoryRepository.save(category1);
        wasteCategoryRepository.save(wasteCategory1);
        disposalGuidelineRepository.save(guideline1);

        // Similarly, populate other waste categories and disposal guidelines
    }
}

