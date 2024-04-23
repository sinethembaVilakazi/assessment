package com.enviro.assessment.grad001.SinethembaVilakazimain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "waste_categories")
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private  String categoryName;


    @NotNull
    private boolean biodegradable;

    @NotBlank
    @Size(max = 50)
    private String type;

    /**
     * Constructs a new WasteCategory object.
     * @param id The unique identifier of the waste category.
     * @param categoryName The name of the waste category.
     * @param biodegradable Indicates if the waste is biodegradable.
     * @param type The type of waste category.
     */
    public WasteCategory(Long id, String categoryName, boolean biodegradable, String type) {
        this.id = id;
        this.categoryName = categoryName;
        this.biodegradable = biodegradable;
        this.type = type;
    }

    /**
     * Default constructor for WasteCategory (used by JPA).
     */
    public WasteCategory(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Retrieves the name of the waste category.
     * @return The name of the waste category.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the name of the waste category.
     * @param categoryName The name to set.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public boolean isBiodegradable() {
        return biodegradable;
    }

    public void setBiodegradable(boolean biodegradable) {
        this.biodegradable = biodegradable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
