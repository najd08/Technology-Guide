package com.example.technologysystem.Controller;

import com.example.technologysystem.ApiResponse.ApiResponse;
import com.example.technologysystem.Model.Products;
import com.example.technologysystem.Services.ProductsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;
    @GetMapping("/getproduct")
    public ResponseEntity getProduct(){
        List<Products> products=productsService.getProducts();
        return ResponseEntity.status(200).body(products);
    }
    @PostMapping("/addproduct")
    public ResponseEntity addProduct(@RequestBody @Valid Products products){
        productsService.addProducts(products);
        return ResponseEntity.status(200).body(new ApiResponse("Product has been added!"));
    }
    @PutMapping("/updateproduct/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id,@RequestBody @Valid Products products){
        productsService.updateProducts(id,products);
        return ResponseEntity.status(200).body(new ApiResponse("Product have been updated!"));
    }
    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        productsService.deleteProducts(id);
        return ResponseEntity.status(200).body(new ApiResponse("Product deleted!"));
    }
    @GetMapping("/bycatgory/{catgory}")
    public ResponseEntity getByCatgory(@PathVariable String catgory){
        List<Products> products=productsService.findProductsByCategory(catgory);
        return ResponseEntity.status(200).body(products);
    }
    @GetMapping("/getbyname/{name}")
    public ResponseEntity getProductByName(@PathVariable String name){
        Products products=productsService.findProductsByName(name);
        return ResponseEntity.status(200).body(products);
    }
    @GetMapping("/storeid/{storeid}")
    public ResponseEntity getProductByStoreId(@PathVariable Integer storeid){
        List<Products> products=productsService.findProductsByStoreId(storeid);
        return ResponseEntity.status(200).body(products);
    }
}
