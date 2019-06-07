package com.example.hospitaldatabase;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.example.hospitaldatabase.domain.Doctor;
import com.example.hospitaldatabase.domain.Patient;
import com.example.hospitaldatabase.domain.PatientRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PatientRepositoryTest {
	 @Autowired
	    private PatientRepository repository;
	 
	    //Check if I can find a patient in patient list by name?
	    @Test
	    public void findByTitleShouldReturnBook() {
	        List<Patient> patient = repository.findByLastname("Smith");
	        
	        assertThat(patient).hasSize(1);
	        assertThat(patient.get(0).getLastname()).isEqualTo("Smith");
	    }
	    
	    //Check if I can create new patient?
	    @Test
	    public void createNewPatient() {
	    	Patient newPatient = new Patient("Tanja", "Radler", "0469664201", "female", 165, 50, "headache", new Doctor("Jenne Woo"),"https://i.ibb.co/FHYFhbM/5.jpg");
	    	repository.save(newPatient);
	    	assertThat(newPatient.getId()).isNotNull();
	    }  
	    
	    //Check if I can delete patient 
	    @Test
	    public void deletePatient() {
	    	List<Patient> patient = repository.findByLastname("Smith");
	    	assertThat(patient).hasSize(1);
	    	repository.deleteById((long) 7);
	    	patient = repository.findByLastname("Smith");
	    	assertThat(patient).hasSize(0);
	    }
}

