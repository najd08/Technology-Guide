package com.example.technologysystem.Services;

import com.example.technologysystem.Exception.ApiException;

import com.example.technologysystem.Model.Products;
import com.example.technologysystem.Repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;
    public List<Products> getProducts(){ return productsRepository.findAll();}
    public void addProducts(Products products){productsRepository.save(products);}
    public void updateProducts(Integer id, Products products){
        Products oldProduct= productsRepository.findProductsById(id);
        if (oldProduct==null)
            throw new ApiException("no ID was found!");
        oldProduct.setCategory(products.getCategory());
        oldProduct.setName(products.getName());
        oldProduct.setMethod(products.getMethod());
        productsRepository.save(oldProduct);
    }
    public void deleteProducts(Integer id){
        Products products=productsRepository.findProductsById(id);
        if (products==null)
            throw new ApiException("Wrong ID!");
        productsRepository.delete(products);
    }


    public List<Products> findProductsByCategory(String catogory){
        List<Products> products=productsRepository.findAllByCategory(catogory);
        if (products==null)
            throw new ApiException("No match!");
        return products;
    }
    public Products findProductsByName(String name){
        Products products=productsRepository.findProductsByName(name);
        if (products==null)
            throw new ApiException("wrong name!");
        return products;
    }
    public List<Products> findProductsByStoreId(Integer storeid){
        List<Products> products=productsRepository.findAllByStoreId(storeid);
        if (products==null)
            throw new ApiException("Wrong store id");
        return products;
    }

}
