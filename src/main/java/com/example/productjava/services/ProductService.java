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

    public void deleteProductById(long id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Product not found");
        }
    }

    public Product save(Product product){
        return this.repository.save(product);
    }

    public void update(long id, Product product) {
       
        try{
            var updateProduct = this.repository.getReferenceById(id);
            updateProduct.setName(product.getName());
            updateProduct.setPrice(product.getPrice());
            this.repository.save(updateProduct);
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Product not found");
        }
        
    }

}
