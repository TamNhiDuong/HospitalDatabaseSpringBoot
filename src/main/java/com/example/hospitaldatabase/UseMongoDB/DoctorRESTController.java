package com.example.hospitaldatabase.UseMongoDB;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.querydsl.core.types.dsl.BooleanExpression;

@RestController
@RequestMapping("/doctordb")
public class DoctorRESTController {

	private DoctorDetailsQueryRepository doctorRepository;
	
	public DoctorRESTController(DoctorDetailsQueryRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	//TESTING DATABASE vs Queries
	//POSTMAN + ROBO3T
	
	@GetMapping("/all")
	public List<DoctorDetails> getAll(){
		List<DoctorDetails> doctors = this.doctorRepository.findAll();
		return doctors; 
	}

	//Insert
	@PutMapping
	public void insert(@RequestBody DoctorDetails doctor) {
		this.doctorRepository.insert(doctor);
	}
	
	//Update an patient by Post
	@PostMapping
	public void update(@RequestBody DoctorDetails patient) {
		this.doctorRepository.save(patient); 
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete (@PathVariable("id") String id) {
		this.doctorRepository.deleteById(id);
	}
	
	//Find patient by lastname
	@GetMapping("/{lastname}")
	public DoctorDetails getByLastname(@PathVariable("lastname") String lastname) {
		DoctorDetails patient = this.doctorRepository.findByLastname(lastname); 
		return patient;
	}
	
	//Filter and search for patient with max weight
	@RequestMapping("/price/{maxPrice}")
	public List<DoctorDetails> getByPricePerHour(@PathVariable("maxPrice") int maxPrice){
		List<DoctorDetails> doctors = this.doctorRepository.findByPricePerHourLessThan(maxPrice);
		return doctors; 
	}
	
	//Filter by city
	 @GetMapping("/address/{city}")
	    public List<DoctorDetails> getByCity(@PathVariable("city") String city){
	        List<DoctorDetails> doctors = this.doctorRepository.findByCity(city);

	        return doctors;
	    }
	 
	 //Filter by Doctor name using Query class
	  @GetMapping("/doctorname/{name}")
	    public List<DoctorDetails> getByDoctorName(@PathVariable("name") String name){
	        // create a query class (QPatient)
	        QDoctorDetails qDoctorDetails = new QDoctorDetails("doctor");

	        // using the query class we can create the filters
	        BooleanExpression filterByDoctorName = qDoctorDetails.lastname.eq(name);

	        // we can then pass the filters to the findAll() method
	        List<DoctorDetails> doctors = (List<DoctorDetails>) this.doctorRepository.findAll(filterByDoctorName);

	        return doctors;
	    }



}