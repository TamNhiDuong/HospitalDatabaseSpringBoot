package com.example.hospitaldatabase.UseMongoDB;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.hospitaldatabase.HospitaldatabaseApplication;


@Component
public class DbSeeder implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(HospitaldatabaseApplication.class);

	private DoctorDetailsRepository doctorRepository;
	private AddressRepository addressRepository;

	public DbSeeder(DoctorDetailsRepository doctorRepository, AddressRepository addressRepository ) {
		this.doctorRepository = doctorRepository;
		this.addressRepository = addressRepository; 
	}

	@Override
	public void run(String... strings) throws Exception {
		addressRepository.save(new Address("Helsinki"));
		addressRepository.save(new Address("Vanta"));
		addressRepository.save(new Address("Espoo"));
		
		
		DoctorDetails doctor1 = new DoctorDetails("Anton", "Ashley", 50,addressRepository.findByCity("Helsinki").get(0),"https://i.ibb.co/Ry8C3jg/doc1.jpg");

		DoctorDetails doctor2 = new DoctorDetails("Katri", "Halonen", 40,addressRepository.findByCity("Vanta").get(0),"https://i.ibb.co/tCyCYsS/doc2.jpg" );

		DoctorDetails doctor3 = new DoctorDetails("Jim", "Morgan", 90,addressRepository.findByCity("Espoo").get(0),"https://i.ibb.co/s3bjg1S/doc3.jpg");
		
		doctorRepository.save(doctor1);
		doctorRepository.save(doctor2);
		doctorRepository.save(doctor3);
		
		log.info("fetch all doctors");
		for (DoctorDetails doctor : doctorRepository.findAll()) {
			log.info(doctor.toString());
		}
		

		// drop all patients
		this.doctorRepository.deleteAll();

		// add patients to the DB
		List<DoctorDetails> doctors = Arrays.asList(doctor1, doctor2, doctor3);
		this.doctorRepository.saveAll(doctors);
	}
}
