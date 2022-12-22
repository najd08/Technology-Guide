package com.example.technologysystem.Services;

import com.example.technologysystem.Exception.ApiException;
import com.example.technologysystem.Model.ProductsDetails;
import com.example.technologysystem.Repository.DetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsDetailsService {
    private final DetailsRepository detailsRepository;
    public List<ProductsDetails> getDetails(){ return detailsRepository.findAll();}
    public void addDetails(ProductsDetails productsDetails){detailsRepository.save(productsDetails);}
    public void updateDetails(Integer id, ProductsDetails details){
        ProductsDetails oldDetails= detailsRepository.findDetailsById(id);
        if (oldDetails==null)
            throw new ApiException("no ID was found!");
        oldDetails.setYearRelease(details.getYearRelease());
        oldDetails.setPrice(details.getPrice());
        oldDetails.setStorage(details.getStorage());
        detailsRepository.save(oldDetails);
    }
    public void deleteDetails(Integer id){
        ProductsDetails productsDetails= detailsRepository.findDetailsById(id);
        if (productsDetails==null)
            throw new ApiException("Wrong id");
        detailsRepository.delete(productsDetails);
    }
    public ProductsDetails findAllDetailsByStorage(String storage){
        ProductsDetails productsDetails=detailsRepository.findAllDetailsByStorage(storage);
        if (productsDetails==null)
            throw new ApiException("no storage was found!");
        return productsDetails;
    }
    public ProductsDetails getDetailsYearRelease(String year){
        ProductsDetails productsDetails=detailsRepository.findProductsDetailsByYearRelease(year);
        if (productsDetails==null)
            throw new ApiException("no year was found!");
        return productsDetails;
    }
    public List<ProductsDetails> getDetailsByProductId(Integer id){
        List<ProductsDetails> productsDetails=detailsRepository.findAllByProductId(id);
        if (productsDetails==null)
            throw new ApiException("No Product Id was found");
        return productsDetails;
    }
}
