package com.example.hospitaldatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


import com.example.hospitaldatabase.domain.Doctor;
import com.example.hospitaldatabase.domain.DoctorRepository;
import com.example.hospitaldatabase.domain.Patient;
import com.example.hospitaldatabase.domain.PatientRepository;
import com.example.hospitaldatabase.domain.User;
import com.example.hospitaldatabase.domain.UserRepository;

@SpringBootApplication
//To be able to authenticate by Facebook

public class HospitaldatabaseApplication  extends SpringBootServletInitializer{

	private static final Logger log = LoggerFactory.getLogger(HospitaldatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HospitaldatabaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PatientRepository repository, DoctorRepository drepository,
			UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of patients");

			drepository.save(new Doctor("Jim Morgan"));
			drepository.save(new Doctor("Anton Ashley"));
			drepository.save(new Doctor("Katri Halonen"));

			Patient patient1 = new Patient("Stephene", "Mike", "0461567829", "male", 178, 60, "heart desease",
					drepository.findByName("Jim Morgan").get(0),"https://i.ibb.co/cNZn9sR/6.jpg");
			Patient patient2 = new Patient("Johnson", "John", "0461560225", "male", 181, 120, "obesity desease",
					drepository.findByName("Anton Ashley").get(0),"https://i.ibb.co/j3Q8svV/7.jpg");
			Patient patient3 = new Patient("Kate", "Winslet", "0461556729", "female", 165, 55, "blood pressure",
					drepository.findByName("Jim Morgan").get(0),"https://i.ibb.co/vHk2XgC/4.jpg" );
			Patient patient4 = new Patient("Adam", "Smith", "0462406643", "male", 188, 90, "headache",
					drepository.findByName("Katri Halonen").get(0),"https://i.ibb.co/phGbvFx/3.jpg");
			Patient patient5 = new Patient("Jenni", "Hamalainen", "0462400093", "male", 186, 92, "stomach sick",
					drepository.findByName("Katri Halonen").get(0),"https://i.ibb.co/FHYFhbM/5.jpg");
			
			repository.save(patient1);
			repository.save(patient2);
			repository.save(patient3);
			repository.save(patient4);
			repository.save(patient5);
			

			// Demo user
						// https://www.browserling.com/tools/bcrypt using this to generate bcrypt
						// password
						User user1 = new User("user", "$2a$10$n1UULdce1utCr3tC/XLP0OjIOAwjFB0yCImFkAgeyXcevf9jPnK3.","user@gmail.com",
								"USER");
						User user2 = new User("admin", "$2a$10$cDLOfjCusgDBg0WSaWOs7ewujF4PTAgW5FednrvNlpR05d73Jp./q", "admin@gmail.com",
								"ADMIN");
						urepository.save(user1);
						urepository.save(user2);

						log.info("fetch all patients");
						for (Patient patient : repository.findAll()) {
							log.info(patient.toString());
						}

		};
	}

}
