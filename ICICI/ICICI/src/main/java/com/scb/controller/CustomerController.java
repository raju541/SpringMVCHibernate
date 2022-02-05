package com.scb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.scb.pojo.StudentPojo;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@GetMapping
	public ResponseEntity<List<StudentPojo>> getList(){
		
	    StudentPojo studentPojo1=new StudentPojo();
	    studentPojo1.setId(1);
	    studentPojo1.setMobile("995209876");
	    studentPojo1.setEmail("abc@gmail.com1");
	    
	    StudentPojo studentPojo2=new StudentPojo();
	    studentPojo2.setId(2);
	    studentPojo2.setMobile("9955555555");
	    studentPojo2.setEmail("xyz@gmail.com1");
	    
	    StudentPojo studentPojo3=new StudentPojo();
	    studentPojo3.setId(3);
	    studentPojo3.setMobile("44555555");
	    studentPojo3.setEmail("ftg@gmail.com1");
	    
	    List<StudentPojo> list=new ArrayList<StudentPojo>();
	    list.add(studentPojo1);
	    list.add(studentPojo2);
	    list.add(studentPojo3);
		   // List<StudentPojo> list = restTemplate.getForObject(uri, List.class);
		    
		return new ResponseEntity(list, new HttpHeaders(), HttpStatus.OK);
	}
	
}
