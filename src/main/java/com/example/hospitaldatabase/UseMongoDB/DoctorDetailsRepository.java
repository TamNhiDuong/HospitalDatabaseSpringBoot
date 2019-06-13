package com.example.hospitaldatabase.UseMongoDB;

import java.util.List;




import org.springframework.data.repository.CrudRepository;

import com.example.hospitaldatabase.domain.Doctor;

public interface DoctorDetailsRepository extends CrudRepository<DoctorDetails, Long> {
	 List<DoctorDetails> findByLastname(String lastname);

	void deleteById(String doctorId);
}