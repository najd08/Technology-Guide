package com.example.technologysystem.Controller;

import com.example.technologysystem.ApiResponse.ApiResponse;
import com.example.technologysystem.Model.Stores;
import com.example.technologysystem.Services.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    @GetMapping("/getstore")
    public ResponseEntity getStore(){
        List<Stores> stores=storeService.getStores();
        return ResponseEntity.status(200).body(stores);
    }
    @PostMapping("/addstore")
    public ResponseEntity addStore(@RequestBody @Valid Stores stores){
        storeService.addStores(stores);
        return ResponseEntity.status(200).body(new ApiResponse("Store has been added!"));
    }
    @PutMapping("/updatestore/{id}")
    public ResponseEntity updateStore(@PathVariable Integer id,@RequestBody @Valid Stores stores){
        storeService.updateStores(id,stores);
        return ResponseEntity.status(200).body(new ApiResponse("Store has been updated!"));
    }
    @DeleteMapping("/deletestore/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id){
        storeService.deleteStores(id);
        return ResponseEntity.status(200).body(new ApiResponse("Store deleted!"));
    }
    @GetMapping("/storebyid/{id}")
    public ResponseEntity getstoreById(@PathVariable Integer id){
        Stores stores=storeService.getStoreById(id);
        return ResponseEntity.status(200).body(stores);
    }
}
