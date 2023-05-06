package com.example.demosoap.repository;

import com.example.demosoap.gen.Product;
import com.example.demosoap.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    Product findByName(String name);
}