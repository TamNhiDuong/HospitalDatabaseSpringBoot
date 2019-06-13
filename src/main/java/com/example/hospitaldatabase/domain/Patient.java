package com.example.hospitaldatabase.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity 
public class Patient {
	//Unique ID
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstname;
	private String lastname;
	private String phonenumber;	
	private String gender;
	private int height;
	private int weight;
	private String healthissue;
	private String img;
	
	@ManyToOne
	@JoinColumn(name = "doctor")
	private Doctor doctor; 
	
	public Patient() {}

	public Patient(String firstname, String lastname, String phonenumber, String gender, int height, int weight, String healthissue,
			Doctor doctor,String img) {
		super();

		this.firstname = firstname;
		this.lastname = lastname; 
		this.phonenumber = phonenumber;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.healthissue = healthissue;
		this.doctor = doctor;
		this.img = img;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getHealthissue() {
		return healthissue;
	}

	public void setHealthissue(String healthissue) {
		this.healthissue = healthissue;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	@Override
	public String toString() {
		if (this.doctor != null)
			return "Patient [id=" + id + ", first name=" + firstname + ", lastname=" + lastname +", gender=" + gender + ", height=" + height +  ", weight=" + weight +  ", health issue=" + healthissue +" doctor =" + this.getDoctor() + "]";		
		else
			return "Patient [id=" + id + ", first name=" + firstname + ", lastname=" + lastname + ", gender=" + gender + ", height=" + height + ", weightn=" + weight + ", health issue=" + healthissue + "]";
	}

}