package com.example.hospitaldatabase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hospitaldatabase.domain.DoctorRepository;
import com.example.hospitaldatabase.domain.Patient;
import com.example.hospitaldatabase.domain.PatientRepository;
import com.example.hospitaldatabase.service.PatientService;

@Controller
public class PatientController {
	@Autowired
	private PatientRepository repository;

	@Autowired
	private DoctorRepository crepository;
	
	// Search service
		@Autowired
		private PatientService patientService;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/patientlist")
	public String patientList(Model model) {
		model.addAttribute("patients", repository.findAll());
		return "patientlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePatient(@PathVariable("id") Long patientId, Model model) {
		repository.deleteById(patientId);
		return "redirect:../patientlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/add")
	public String addPatient(Model model) {
		// content of the method is completely empty new object
		model.addAttribute("patient", new Patient());
		model.addAttribute("doctors", crepository.findAll());
		// go to new html-end-point
		return "addpatient";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Patient patient) {
		repository.save(patient);
		return "redirect:patientlist";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") Long patientId, Model model) {
		model.addAttribute("patient", repository.findById(patientId));
		model.addAttribute("doctor", crepository.findAll());
		return "editpatient";
	}

	// RESTful service to get all books
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public @ResponseBody List<Patient> patientListRest() {
		return (List<Patient>) repository.findAll();
	}

	// RESTful service to get books by id
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Patient> findPatinetRest(@PathVariable("id") Long patientId) {
		return repository.findById(patientId);
	}
	
	// SEARCH function
		@GetMapping("/patient/search")
		public String search(@RequestParam("s") String s, Model model) {
			if (s.equals("")) {
				return "redirect:/patientlist";
			}

			model.addAttribute("patients", patientService.search(s));
			return "patientlist";
		}


}
