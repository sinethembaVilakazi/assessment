package com.enviro.assessment.grad001.SinethembaVilakazimain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class RecyclingTip {

    public RecyclingTip() {
    }

    public RecyclingTip(Long id, WasteCategory wasteCategory, String categoryName, String tip) {
        this.id = id;
        this.wasteCategory = wasteCategory;
        this.categoryName = categoryName;
        this.tip = tip;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private WasteCategory wasteCategory;
    @ManyToOne
    private  String categoryName;



    @NotBlank
    @Size(max =1000)
    private String tip;

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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
