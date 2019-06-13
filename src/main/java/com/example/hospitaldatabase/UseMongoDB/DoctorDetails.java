package com.example.hospitaldatabase.UseMongoDB;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

//Anotation of using MongoDB

@Document(collection ="doctors")
public class DoctorDetails {
	    //In MongoDB, Id must be String obj
	    @Id
	    String id;
	    String firstname;
	    String lastname;
	    @Indexed(direction = IndexDirection.ASCENDING)
	    int pricePerHour;
	    String img;
	    @ManyToOne
		@JoinColumn(name = "address")
		private Address address; 
	    
		public DoctorDetails() {}
		
		
	   
	    public DoctorDetails(String firstname,String lastname, int pricePerHour, Address address, String img) {
	        this.firstname = firstname;
	        this.lastname = lastname; 
	        this.pricePerHour = pricePerHour;
	        this.address = address;
	        this.img = img;
	    }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public int getPricePerHour() {
			return pricePerHour;
		}

		public void setPricePerHour(int pricePerHour) {
			this.pricePerHour = pricePerHour;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}
		
		public String getImg() {
			return img;
		}



		public void setImg(String img) {
			this.img = img;
		}



		@Override
		public String toString() {
			if (this.address != null)
				return "Doctor [id=" + id + ", first name=" + firstname + ", lastname=" + lastname +", price per hour=" + pricePerHour + " Address =" + this.getAddress() + "]";		
			else
				return "Patient [id=" + id + ", first name=" + firstname + ", lastname=" + lastname + ", price per hour=" + pricePerHour + " Address =" +"]";
		}

		
	   
	}
