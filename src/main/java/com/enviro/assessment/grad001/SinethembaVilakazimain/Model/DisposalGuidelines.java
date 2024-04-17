package com.enviro.assessment.grad001.SinethembaVilakazimain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class DisposalGuidelines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private WasteCategory wasteCategory;

    @NotBlank
    @Size(max = 1000)
    private String guidelines;

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

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public String getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(String guidelines) {
        this.guidelines = guidelines;
    }

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
}


