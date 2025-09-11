package com.johnverz.webdev1_g1;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.johnverz.webdev1_g1.exception.ResourceNotFoundException;

import jakarta.validation.Valid;

@Controller
public class HomeController {

    private final CarRepository carRepository;
    private final CarService carService;

    public HomeController(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars",carRepository.findAll());
        cars.forEach(car -> {
            System.out.println(car.getMake());
        });
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        CarDTO carDTO = new CarDTO();
        model.addAttribute("carDTO", carDTO);
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("carDTO") CarDTO carDTO,
                       BindingResult result,
                       Model model){
        if (result.hasErrors()) {
            return "create"; // redisplay form with errors
        }

        carService.save(carDTO);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", id));
        
        model.addAttribute("car", car);
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", id));
        
        CarDTO carDTO = carService.convertToDTO(car);
        model.addAttribute("carDTO", carDTO);
        model.addAttribute("carId", id);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("carDTO") CarDTO carDTO,
                         BindingResult result,
                         @ModelAttribute("carId") int carId,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("carId", carId);
            return "edit"; // redisplay form with errors
        }

        carService.update(carDTO, carId);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        // Check if car exists before deleting
        carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", id));
        
        carRepository.deleteById(id);
        return "redirect:/";
    }
}
