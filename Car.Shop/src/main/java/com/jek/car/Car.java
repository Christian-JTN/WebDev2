package com.jek.car;

import java.util.Objects;

public class Car {
    private Long carId;
    private String licensePlateNumber;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private BodyType bodyType;
    private EngineType engineType;
    private Transmission transmission;

    public Car() {
    }

    public Car(String licensePlateNumber, String make, String model, Integer year, 
               String color, BodyType bodyType, EngineType engineType, Transmission transmission) {
        this.licensePlateNumber = licensePlateNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.bodyType = bodyType;
        this.engineType = engineType;
        this.transmission = transmission;
    }

    // Getters and Setters
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

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

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carId, car.carId) && 
               Objects.equals(licensePlateNumber, car.licensePlateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, licensePlateNumber);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", licensePlateNumber='" + licensePlateNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", bodyType=" + bodyType +
                ", engineType=" + engineType +
                ", transmission=" + transmission +
                '}';
    }

    public enum BodyType {
        SEDAN, SUV, HATCHBACK
    }

    public enum EngineType {
        GASOLINE, DIESEL, ELECTRIC, HYBRID
    }

    public enum Transmission {
        AUTOMATIC, MANUAL
    }
}
