package com.example.productjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productjava.entities.Product;
import com.example.productjava.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts(){
        return this.repository.findAll();
    }

    public Product getProduct(long id){
        return this.repository.findById(id).orElseThrow(
                                                () -> new EntityNotFoundException("Product not found")

                                            );
    }

}
