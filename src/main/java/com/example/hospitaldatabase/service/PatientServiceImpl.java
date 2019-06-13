package com.example.hospitaldatabase.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitaldatabase.domain.Patient;
import com.example.hospitaldatabase.domain.PatientRepository;


@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
    private PatientRepository PatientRepository;
	
	@Override
    public List<Patient> search(String q) {
        return PatientRepository.findByLastname(q);
    }

	@Override
	public Iterable<Patient> findAll() {
		// TODO Auto-generated method stub
		return PatientRepository.findAll();
	}
}