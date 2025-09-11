package com.johnverz.webdev1_g1;

import org.springframework.stereotype.Service;

import com.johnverz.webdev1_g1.exception.ResourceNotFoundException;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void save(CarDTO dto) {
        Car car = new Car();
        car.setMake(dto.getMake());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setColor(dto.getColor());
        car.setBodyType(dto.getBodyType());
        car.setEngineType(dto.getEngineType());
        car.setLicensePlate(dto.getLicensePlate());

        carRepository.save(car);
    }

    public void update(CarDTO dto, int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", id));
        
        car.setMake(dto.getMake());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setColor(dto.getColor());
        car.setBodyType(dto.getBodyType());
        car.setEngineType(dto.getEngineType());
        car.setLicensePlate(dto.getLicensePlate());

        carRepository.save(car);
    }

    public CarDTO convertToDTO(Car car) {
        CarDTO dto = new CarDTO();
        dto.setMake(car.getMake());
        dto.setModel(car.getModel());
        dto.setYear(car.getYear());
        dto.setColor(car.getColor());
        dto.setBodyType(car.getBodyType());
        dto.setEngineType(car.getEngineType());
        dto.setLicensePlate(car.getLicensePlate());
        return dto;
    }
}
