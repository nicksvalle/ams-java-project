package com.example.productjava.mappers;

import com.example.productjava.dtos.ProductRequest;
import com.example.productjava.dtos.ProductResponse;
import com.example.productjava.entities.Product;

public class ProductMapper {
    
    public static Product toEntity(ProductRequest request){
        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        return product;
    }

    public static ProductResponse toDTO(Product product){
        return new ProductResponse(product.getId(),
                product.getName(),
                product.getPrice());
    }
}
