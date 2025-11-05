package com.johnverz.webdev1_g1.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Description is required")
        String description,

        @Min(value = 1, message = "Stock must be at least 1")
        int stock,

        @NotBlank(message = "Unit is required")
        String unit,

        @DecimalMin(value = "1.0", inclusive = true, message = "Price must be at least 1.0")
        double price
) {
}
