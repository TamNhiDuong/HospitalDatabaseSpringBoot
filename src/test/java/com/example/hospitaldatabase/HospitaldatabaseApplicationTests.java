package com.example.hospitaldatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hospitaldatabase.controller.PatientController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitaldatabaseApplicationTests {

	@Autowired
	private PatientController controller;

	//@Autowired
	//private UserDetailServiceImpl userDetailServiceImpl;
	//@Test
	//public void contextLoads() throws Exception {
	//	assertThat(controller).isNotNull();
	//	assertThat(userDetailServiceImpl).isNotNull();
	}
//}
