package com.ra.session02.model.repository;

import com.ra.session02.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductsByProducerContains(String productName);
    Product findProductById(Long id);
}
