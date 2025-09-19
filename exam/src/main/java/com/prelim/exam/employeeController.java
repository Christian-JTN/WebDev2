package com.prelim.exam;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class employeeController {

    @Autowired
    private employeeRepository employeeRepository;

    @GetMapping
    public String listEmployees(Model model) {
        List<employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new employee());
        return "employees/form";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employees/form";
        }
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        employee employee = employeeRepository.findById(id).orElse(new employee());
        model.addAttribute("employee", employee);
        return "employees/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }
}
