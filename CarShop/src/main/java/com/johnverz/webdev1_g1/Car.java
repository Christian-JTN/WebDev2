package com.johnverz.webdev1_g1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank(message = "Make cannot be empty")
    @Size(min = 2, max = 50, message = "Make must be between 2-50 characters")
    @Column(nullable = false)
    private String make;
    
    @NotBlank(message = "Model cannot be empty")
    @Size(min = 1, max = 50, message = "Model must be between 1-50 characters")
    @Column(nullable = false)
    private String model;
    
    @NotNull(message = "Year is required")
    @Min(value = 1900, message = "Year must be at least 1900")
    @Max(value = 2025, message = "Year must not exceed 2025")
    @Column(nullable = false)
    private int year;
    
    @NotBlank(message = "Color cannot be empty")
    @Size(min = 2, max = 30, message = "Color must be between 2-30 characters")
    @Column(nullable = false)
    private String color;
    
    @NotBlank(message = "Body type is required")
    @Pattern(regexp = "^(Sedan|SUV|Hatchback|Coupe|Convertible|Wagon|Truck|Van)$", 
             message = "Please select a valid body type")
    @Column(nullable = false)
    private String bodyType;
    
    @NotBlank(message = "Engine type is required")
    @Pattern(regexp = "^(Gasoline|Diesel|Electric|Hybrid|Plug-in Hybrid)$", 
             message = "Please select a valid engine type")
    @Column(nullable = false)
    private String engineType;
    
    @NotBlank(message = "License plate cannot be empty")
    @Size(min = 2, max = 15, message = "License plate must be between 2-15 characters")
    @Pattern(regexp = "^[A-Z0-9\\s-]+$", message = "License plate can only contain letters, numbers, spaces, and hyphens")
    @Column(nullable = false, unique = true)
    private String licensePlate;

    public int getId(){return id;}

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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