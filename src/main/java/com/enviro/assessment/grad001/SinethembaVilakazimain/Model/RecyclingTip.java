package com.enviro.assessment.grad001.SinethembaVilakazimain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Entity class representing recycling tips.
 */
@Entity
@Table(name = "recycling_tips")
public class RecyclingTip {

    public RecyclingTip() {
    }

    /**
     * Parameterized constructor.
     *
     * @param id           The ID of the recycling tip.
     * @param categoryName The category name of the recycling tip.
     * @param tip          The recycling tip message.
     */
    public RecyclingTip(Long id, String categoryName, String tip) {
        this.id = id;
        this.categoryName = categoryName;
        this.tip = tip;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    private WasteCategory wasteCategory;

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

//    public WasteCategory getWasteCategory() {
//        return wasteCategory;
//    }
//
//    public void setWasteCategory(WasteCategory wasteCategory) {
//        this.wasteCategory = wasteCategory;
//    }

    /**
     * Get the recycling tip message.
     *
     * @return The recycling tip message.
     */
    public String getTip() {
        return tip;
    }

    /**
     * Set the recycling tip message.
     *
     * @param tip The recycling tip message.
     */
    public void setTip(String tip) {
        this.tip = tip;
    }

    /**
     * Get the category name of the recycling tip.
     *
     * @return The category name of the recycling tip.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Set the category name of the recycling tip.
     *
     * @param categoryName The category name of the recycling tip.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
