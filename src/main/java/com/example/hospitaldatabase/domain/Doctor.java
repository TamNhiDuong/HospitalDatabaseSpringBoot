package com.example.hospitaldatabase.domain;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
	  @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private Long doctorid;
		private String name;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
		private List<Patient> patients;
		
		public Doctor() {}
		
		public Doctor(String name) {
			super();
			this.name = name;
		}
		public Long getDoctorId() {
			return doctorid;
		}
		
		public void setDoctorId(Long doctorid) {
			this.doctorid = doctorid;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}

		public List<Patient> getPatients() {
			return patients;
		}

		public void setPatients(List<Patient> patients) {
			this.patients = patients;
		}

		@Override
		public String toString() {
			return "Doctor [doctorid=" + doctorid + ", doctorname=" + name + "]";
		}
	}

