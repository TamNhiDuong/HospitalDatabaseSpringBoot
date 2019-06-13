package com.example.hospitaldatabase.UseMongoDB;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//Anotation of using MongoDB
@Document(collection ="address")
public class Address {
	  @Id
	    String addressid;
		private String city;
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
		private List<DoctorDetails> doctors;
		
		public Address() {}
		
      public Address(String city) {
      	this.city = city; 
      }

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<DoctorDetails> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<DoctorDetails> doctors) {
		this.doctors = doctors;
	}
	
		
}