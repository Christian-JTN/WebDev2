package com.johnverz.webdev1_g1.repository;

import com.johnverz.webdev1_g1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
