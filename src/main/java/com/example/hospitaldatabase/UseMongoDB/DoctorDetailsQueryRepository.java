package com.example.hospitaldatabase.UseMongoDB;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
//This repository is used for DoctorRESTController
//Used for testing, updating data from Command Line, Postman, Robo3T
@Repository
public interface DoctorDetailsQueryRepository extends MongoRepository<DoctorDetails, String>,QuerydslPredicateExecutor<DoctorDetails> {
DoctorDetails findByLastname(String lastname); 


List<DoctorDetails> findByPricePerHourLessThan(int maxPrice); 
//Find doctor where city is...
@Query(value = "{'address.city':?0}")
List<DoctorDetails> findByCity(String city);


}