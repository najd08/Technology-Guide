package com.example.technologysystem.Services;

import com.example.technologysystem.Exception.ApiException;
import com.example.technologysystem.Model.Stores;
import com.example.technologysystem.Repository.StoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    public final StoresRepository storesRepository;
    public List<Stores> getStores(){return storesRepository.findAll();}
    public void addStores(Stores stores){storesRepository.save(stores);}
    public void updateStores(Integer id,Stores stores){
        Stores stores1=storesRepository.findStoresById(id);
        if (stores1==null)
            throw new ApiException("Wrong is for store!");
        stores1.setName(stores.getName());
        storesRepository.save(stores1);
    }
    public void deleteStores(Integer id){
        Stores stores=storesRepository.findStoresById(id);
        if (stores==null)
            throw new ApiException("no ID found!");
        storesRepository.delete(stores);
    }
    public Stores getStoreById(Integer id){
        Stores stores=storesRepository.findStoresById(id);
        if (stores==null)
            throw new ApiException("No Store was Found for products!");
        storesRepository.findAll();
        return stores;
    }

}
