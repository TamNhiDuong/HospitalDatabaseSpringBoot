package com.example.hospitaldatabase.UseMongoDB;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
//This repository is used for DoctorController
public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findByCity(String city);
    
}

