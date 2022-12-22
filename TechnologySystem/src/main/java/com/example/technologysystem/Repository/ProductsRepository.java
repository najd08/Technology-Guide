package com.example.technologysystem.Repository;

import com.example.technologysystem.Model.Products;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
    Products findProductsById(Integer id);
    List<Products> findAllByCategory(String category);
    Products findProductsByName(String name);
    List<Products> findAllByStoreId(Integer Id);

}
