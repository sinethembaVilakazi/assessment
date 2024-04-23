package com.enviro.assessment.grad001.SinethembaVilakazimain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entity class representing disposal guidelines for waste categories.
 */
@Entity
public class DisposalGuidelines {

    /**
     * Parameterized constructor.
     *
     * @param id               The ID of the disposal guideline.
     * @param categoryName     The name of the waste category.
     * @param hazardous        Flag indicating if the waste is hazardous.
     * @param disposalMethods  Methods of disposal (comma-separated list).
     */
    public DisposalGuidelines(Long id, String categoryName, boolean hazardous, String disposalMethods) {
        this.id = id;
        this.categoryName = categoryName;
        this.hazardous = hazardous;
        this.disposalMethods = disposalMethods;
    }
    public DisposalGuidelines(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    private WasteCategory wasteCategory;

    @NotBlank
    private String categoryName;

    @NotNull
    private boolean hazardous;

    @NotBlank
    @Size(max = 500)
    private String disposalMethods;  //disposal methods should be stored in a comma-separated list


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public WasteCategory getWasteCategory() {
//        return wasteCategory;
//    }
//
//    public void setWasteCategory(WasteCategory wasteCategory) {
//        this.wasteCategory = wasteCategory;
//    }

    public boolean isHazardous() {
        return hazardous;
    }

    public void setHazardous(boolean hazardous) {
        this.hazardous = hazardous;
    }

    public String getDisposalMethods() {
        return disposalMethods;
    }
    public void setDisposalMethods(String disposalMethods) {
        this.disposalMethods = disposalMethods;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}


