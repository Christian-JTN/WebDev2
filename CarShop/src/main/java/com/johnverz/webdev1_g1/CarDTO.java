package com.johnverz.webdev1_g1;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CarDTO {

    @Size(min = 2, max = 50, message = "Make must be between 2-50 characters")
    private String make;

    @Size(min = 1, max = 50, message = "Model must be between 1-50 characters")
    private String model;

    @NotNull(message = "Year is required")
    private Integer year;

    @Size(min = 2, max = 30, message = "Color must be between 2-30 characters")
    private String color;

    @Pattern(regexp = "^(Sedan|SUV|Hatchback|Coupe|Convertible|Wagon|Truck|Van)$", 
             message = "Please select a valid body type")
    private String bodyType;

    @Pattern(regexp = "^(Gasoline|Diesel|Electric|Hybrid|Plug-in Hybrid)$", 
             message = "Please select a valid engine type")
    private String engineType;

    @Size(min = 2, max = 15, message = "License plate must be between 2-15 characters")
    @Pattern(regexp = "^[A-Z0-9\\s-]+$", message = "License plate can only contain letters, numbers, spaces, and hyphens")
    private String licensePlate;

    // Default constructor
    public CarDTO() {}

    // Getters and setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
