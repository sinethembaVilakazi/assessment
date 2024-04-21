package com.enviro.assessment.grad001.SinethembaVilakazimain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "waste_categories")
public class WasteCategory {
    public WasteCategory(Long id, String categoryName, boolean biodegradable, String type) {
    this.id = id;
    this.categoryName = categoryName;
    this.biodegradable = biodegradable;
    this.type = type;
}
    public WasteCategory(){

    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

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
