package com.jek.car.controller;

import com.jek.car.model.Car;
import com.jek.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {
    
    private final CarService carService;
    
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    
    @GetMapping
    public String listCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "cars/list";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("bodyTypes", Car.BodyType.values());
        model.addAttribute("engineTypes", Car.EngineType.values());
        model.addAttribute("transmissions", Car.Transmission.values());
        return "cars/add";
    }
    
    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car) {
        carService.saveCar(car);
        return "redirect:/cars";
    }
    
    @GetMapping("/clear")
    public String clearAllCars() {
        carService.deleteAllCars();
        return "redirect:/cars";
    }
    
    @GetMapping("/")
    public String redirectToCars() {
        return "redirect:/cars";
    }
}
