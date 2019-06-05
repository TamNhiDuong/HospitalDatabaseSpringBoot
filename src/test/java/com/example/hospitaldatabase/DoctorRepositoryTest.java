package com.example.hospitaldatabase;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hospitaldatabase.domain.Doctor;
import com.example.hospitaldatabase.domain.DoctorRepository;




@RunWith(SpringRunner.class)
@DataJpaTest
public class DoctorRepositoryTest {
	@Autowired
    private DoctorRepository drepository;

    //Test if I can find doctor by name?
    @Test
    public void findByNameShouldReturnCategory() {
        
        List<Doctor> doctors = drepository.findByName("Jim Morgan");
        assertThat(doctors).hasSize(1);
        assertThat(doctors.get(0).getDoctorid()).isNotNull();
    }
    
    //Test if I can delete a doctor by id
    @Test
    public void deleteDoctor() {
		List<Doctor> doctors = drepository.findByName("Katri Halonen");
		assertThat(doctors).hasSize(1);
    	drepository.deleteById((long) 3);
    	doctors = drepository.findByName("Katri Halonen");
    	assertThat(doctors).hasSize(0);
    }
  
}

