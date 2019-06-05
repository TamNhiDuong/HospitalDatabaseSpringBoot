package com.example.hospitaldatabase.service;
import java.util.List;

import com.example.hospitaldatabase.domain.Patient;


public interface PatientService {

	Iterable<Patient> findAll();

    List<Patient> search(String q);

}
