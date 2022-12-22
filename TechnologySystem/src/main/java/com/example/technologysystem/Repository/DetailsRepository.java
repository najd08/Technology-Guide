package com.example.technologysystem.Repository;

import com.example.technologysystem.Model.ProductsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsRepository extends JpaRepository<ProductsDetails,Integer> {
    ProductsDetails findDetailsById(Integer id);
    ProductsDetails findAllDetailsByStorage(String storage);
    ProductsDetails findProductsDetailsByYearRelease(String year);
    List<ProductsDetails> findAllByProductId(Integer id);
}
