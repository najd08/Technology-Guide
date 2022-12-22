package com.example.technologysystem.Controller;

import com.example.technologysystem.ApiResponse.ApiResponse;
import com.example.technologysystem.Model.ProductsDetails;
import com.example.technologysystem.Services.ProductsDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/details")
@RequiredArgsConstructor
public class ProdDetController {
    private final ProductsDetailsService productsDetailsService;
    @GetMapping("/get")
    public ResponseEntity getDetail(){
        List<ProductsDetails> productsDetails=productsDetailsService.getDetails();
        return ResponseEntity.status(200).body(productsDetails);
    }
    @PostMapping("/add")
    public ResponseEntity addDetails(@RequestBody @Valid ProductsDetails productsDetails){
        productsDetailsService.addDetails(productsDetails);
        return ResponseEntity.status(200).body(new ApiResponse("Detail has been added!"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateDetails(@PathVariable Integer id,@RequestBody @Valid ProductsDetails details){
        productsDetailsService.updateDetails(id,details);
        return ResponseEntity.status(200).body(new ApiResponse("Detail has been updated!"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDetails(@PathVariable Integer id){
        productsDetailsService.deleteDetails(id);
        return ResponseEntity.status(200).body(new ApiResponse("Detail has been deleted!"));
    }
    @GetMapping("/storage/{storage}")
    public ResponseEntity getDetailsProductStorage(@PathVariable String storage){
        ProductsDetails productsDetails= productsDetailsService.findAllDetailsByStorage(storage);
        return ResponseEntity.status(200).body(productsDetails);
    }
    @GetMapping("/releaseyear/{year}")
    public ResponseEntity getDetailsProductReleaseYear(@PathVariable String year){
        ProductsDetails productsDetails=productsDetailsService.getDetailsYearRelease(year);
        return ResponseEntity.status(200).body(productsDetails);
    }
    @GetMapping("/prodbyid/{id}")
    public ResponseEntity getDetailsProductByProdId(@PathVariable Integer id){
        List<ProductsDetails> productsDetails=productsDetailsService.getDetailsByProductId(id);
        return ResponseEntity.status(200).body(productsDetails);
    }

}
