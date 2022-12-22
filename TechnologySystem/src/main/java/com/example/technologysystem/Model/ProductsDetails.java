package com.example.technologysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Entity @NoArgsConstructor
public class ProductsDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Enter the Release year!")
    private String yearRelease;
    @NotNull(message = "Enter price!")
    private double price;
    @NotEmpty(message = "Enter the products storage!")
    private String storage;

    private Integer productId;
}
