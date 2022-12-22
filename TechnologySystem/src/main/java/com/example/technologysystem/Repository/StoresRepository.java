package com.example.technologysystem.Repository;

import com.example.technologysystem.Model.Stores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoresRepository extends JpaRepository<Stores,Integer> {

    Stores findStoresById(Integer id);


}
