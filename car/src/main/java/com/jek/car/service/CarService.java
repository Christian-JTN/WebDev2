package com.jek.car.service;

import com.jek.car.model.Car;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CarService {
    
    private static final String CSV_FILE_PATH = "cars.csv";
    private final AtomicLong nextCarId = new AtomicLong(1);
    
    public CarService() {
        initializeCsvFile();
        loadNextCarId();
    }
    
    private void initializeCsvFile() {
        Path path = Paths.get(CSV_FILE_PATH);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                // Write header
                writeHeader();
            } catch (IOException e) {
                throw new RuntimeException("Failed to create CSV file", e);
            }
        }
    }
    
    private void writeHeader() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH))) {
            writer.println("CarID,LicensePlateNumber,Make,Model,Year,Color,BodyType,EngineType,Transmission");
        } catch (IOException e) {
            throw new RuntimeException("Failed to write CSV header", e);
        }
    }
    
    private void loadNextCarId() {
        List<Car> cars = getAllCars();
        if (!cars.isEmpty()) {
            long maxId = cars.stream()
                    .mapToLong(Car::getCarId)
                    .max()
                    .orElse(0);
            nextCarId.set(maxId + 1);
        }
    }
    
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        Path path = Paths.get(CSV_FILE_PATH);
        
        if (!Files.exists(path)) {
            return cars;
        }
        
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip header
                }
                
                if (!line.trim().isEmpty()) {
                    Car car = parseCarFromCsv(line);
                    if (car != null) {
                        cars.add(car);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV file", e);
        }
        
        return cars;
    }
    
    public Car saveCar(Car car) {
        car.setCarId(nextCarId.getAndIncrement());
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
            writer.println(carToCsvLine(car));
        } catch (IOException e) {
            throw new RuntimeException("Failed to save car to CSV", e);
        }
        
        return car;
    }
    
    private Car parseCarFromCsv(String csvLine) {
        try {
            String[] parts = csvLine.split(",");
            if (parts.length >= 9) {
                Car car = new Car();
                car.setCarId(Long.parseLong(parts[0].trim()));
                car.setLicensePlateNumber(parts[1].trim());
                car.setMake(parts[2].trim());
                car.setModel(parts[3].trim());
                car.setYear(Integer.parseInt(parts[4].trim()));
                car.setColor(parts[5].trim());
                car.setBodyType(Car.BodyType.valueOf(parts[6].trim()));
                car.setEngineType(Car.EngineType.valueOf(parts[7].trim()));
                car.setTransmission(Car.Transmission.valueOf(parts[8].trim()));
                return car;
            }
        } catch (Exception e) {
            // Log error and return null for invalid lines
            System.err.println("Error parsing CSV line: " + csvLine + " - " + e.getMessage());
        }
        return null;
    }
    
    private String carToCsvLine(Car car) {
        return String.format("%d,%s,%s,%s,%d,%s,%s,%s,%s",
                car.getCarId(),
                escapeCsvField(car.getLicensePlateNumber()),
                escapeCsvField(car.getMake()),
                escapeCsvField(car.getModel()),
                car.getYear(),
                escapeCsvField(car.getColor()),
                car.getBodyType(),
                car.getEngineType(),
                car.getTransmission()
        );
    }
    
    private String escapeCsvField(String field) {
        if (field == null) {
            return "";
        }
        // If field contains comma, quote, or newline, wrap in quotes and escape internal quotes
        if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        return field;
    }
    
    public void deleteAllCars() {
        try {
            Files.deleteIfExists(Paths.get(CSV_FILE_PATH));
            initializeCsvFile();
            nextCarId.set(1);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete CSV file", e);
        }
    }
}
