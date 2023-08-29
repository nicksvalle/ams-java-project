package com.example.productjava.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductRequest(

    @NotBlank(message = "Nome não pode ser em branco")
    String name,
    
    @Min(value = 0, message = "O valor mínimo para o preço é zero")
    double price
) {

}
