package com.johnverz.webdev1_g1.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFound(ResourceNotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("errorType", "Resource Not Found");
        return "error/error";  // Thymeleaf error page
    }

    @ExceptionHandler(BadRequestException.class)
    public String handleBadRequest(BadRequestException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("errorType", "Bad Request");
        return "error/error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        model.addAttribute("message", "Unexpected error: " + ex.getMessage());
        model.addAttribute("errorType", "Internal Server Error");
        return "error/error";
    }
}
