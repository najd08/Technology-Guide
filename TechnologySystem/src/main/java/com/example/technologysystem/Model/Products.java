package com.example.technologysystem.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "hh")
    private String name;
    @Column(columnDefinition = "varchar(20) not null check (category='Phones' or category='Desktops')")
    private String category;

    @Column(columnDefinition = "varchar(15) not null check (method='Basic' or method='pro')")
    private String method;

    private Integer storeId;
}
