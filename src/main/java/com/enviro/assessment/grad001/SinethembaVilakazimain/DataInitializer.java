package com.enviro.assessment.grad001.SinethembaVilakazimain;

import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.RecyclingTip;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.WasteCategory;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Model.DisposalGuidelines;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.SinethembaVilakazimain.Repository.RecycleTipRepository;
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

    @Autowired
    private  RecycleTipRepository recycleTipRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Populate waste categories and disposal guidelines during application startup
        WasteCategory plasticCategory = new WasteCategory(null, "Plastic", false, "Recyclable");
        WasteCategory paperCategory = new WasteCategory(null, "Paper", true, "Recyclable");
        WasteCategory glassCategory = new WasteCategory(null, "Glass", true, "Recyclable");
        WasteCategory metalCategory = new WasteCategory(null, "Metal", false, "Recyclable");

        // Save waste categories to the database
        wasteCategoryRepository.save(plasticCategory);
        wasteCategoryRepository.save(paperCategory);
        wasteCategoryRepository.save(glassCategory);
        wasteCategoryRepository.save(metalCategory);

        // Create and save disposal guidelines for each waste category
        createDisposalGuidelines(plasticCategory, "Dispose of plastic waste in designated bins.",true);
        createDisposalGuidelines(paperCategory, "Recycle paper waste. Avoid mixing with wet waste.",false);
        createDisposalGuidelines(glassCategory, "Recycle glass bottles and containers. Handle with care to avoid breakage.",true);
        createDisposalGuidelines(metalCategory, "Recycle metal cans and objects. Ensure they are clean and free of contaminants.",true);

        createRecyclingTip(plasticCategory.getCategoryName(), "Reuse plastic containers whenever possible. Consider using biodegradable plastics.");
        createRecyclingTip(paperCategory.getCategoryName(), "Reuse paper for notes or crafts before recycling. Use paper bags for composting.");
        createRecyclingTip(glassCategory.getCategoryName(), "Reuse glass jars for storage or crafts.");
        createRecyclingTip(metalCategory.getCategoryName(), "Collect metal caps for recycling separately.");

    }

    private void createDisposalGuidelines(WasteCategory wasteCategory, String disposalMethod,boolean hazardous) {
        DisposalGuidelines guidelines = new DisposalGuidelines(null,  wasteCategory.getCategoryName(), hazardous, disposalMethod);
        disposalGuidelineRepository.save(guidelines);
    }
    private void createRecyclingTip(String categoryName, String tipText) {
        RecyclingTip recyclingTip = new RecyclingTip(null, categoryName, tipText);
        recycleTipRepository.save(recyclingTip);
    }
}

