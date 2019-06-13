package com.example.hospitaldatabase.UseMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hospitaldatabase.domain.Patient;


@Controller
public class DoctorController {
	@Autowired
	private DoctorDetailsRepository repository;

	@Autowired
	private AddressRepository arepository;
	
	@RequestMapping("/doctorlist")
	public String patientList(Model model) {
		model.addAttribute("doctors", repository.findAll());
		return "doctorlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deletedoctor/{id}", method = RequestMethod.GET)
	public String deleteDoctor(@PathVariable("id") String doctorId, Model model) {
		repository.deleteById(doctorId);
		return "redirect:../doctorlist";
	}


}