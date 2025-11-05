package com.johnverz.webdev1_g1.controller.api;

import com.johnverz.webdev1_g1.dto.ProductDTO;
import com.johnverz.webdev1_g1.model.Product;
import com.johnverz.webdev1_g1.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/products")
    public Product newProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @Valid @RequestBody ProductDTO productDTO) {
        Product product = productService.findById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with ID " + id + " not found.");
        }
        return productService.updateProduct(product, productDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        if (productService.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with ID " + id + " not found.");
        }
        productService.deleteProduct(id);
    }
}
