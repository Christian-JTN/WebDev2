package com.johnverz.webdev1_g1.service;

import com.johnverz.webdev1_g1.dto.ProductDTO;
import com.johnverz.webdev1_g1.model.Product;
import com.johnverz.webdev1_g1.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product save(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setStock(productDTO.stock());
        product.setUnit(productDTO.unit());
        product.setPrice(productDTO.price());
        return repository.save(product);
    }

    public Product updateProduct(Product product, ProductDTO productDTO) {
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setStock(productDTO.stock());
        product.setUnit(productDTO.unit());
        product.setPrice(productDTO.price());
        return repository.save(product);
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}
