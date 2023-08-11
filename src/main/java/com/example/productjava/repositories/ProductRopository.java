package com.example.productjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productjava.entities.Product;

public interface ProductRopository extends JpaRepository<Product, Long>{
    
}
