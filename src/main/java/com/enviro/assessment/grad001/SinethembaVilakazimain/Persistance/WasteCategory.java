package com.enviro.assessment.grad001.SinethembaVilakazimain.Persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private  String name;

    @NotBlank
    @Size(max = 500)
    private String description;

    @NotNull
    private boolean liquidWaste;

    @NotNull
    private boolean solidWaste;

    @NotNull
    private boolean organicWaste;


    @NotNull
    private boolean recyclable;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLiquidWaste() {
        return liquidWaste;
    }

    public void setLiquidWaste(boolean liquidWaste) {
        this.liquidWaste = liquidWaste;
    }

    public boolean isSolidWaste() {
        return solidWaste;
    }

    public void setSolidWaste(boolean solidWaste) {
        this.solidWaste = solidWaste;
    }

    public boolean isOrganicWaste() {
        return organicWaste;
    }

    public void setOrganicWaste(boolean organicWaste) {
        this.organicWaste = organicWaste;
    }

    public boolean isRecyclable() {
        return recyclable;
    }

    public void setRecyclable(boolean recyclable) {
        this.recyclable = recyclable;
    }
}
