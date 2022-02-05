package com.scb.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.scb.pojo.StudentPojo;

@RestController
@RequestMapping("/emp")
public class EmpControler {

	
	  @GetMapping 
	  public ResponseEntity<List<StudentPojo>> getList(){ 
		  RestTemplate restTemplate = new RestTemplate();
		  final String uri = "http://localhost:8081/student"; //hdfc 
		  StudentPojo[] forNow = restTemplate.getForObject(uri, StudentPojo[].class); 
		  List<StudentPojo> list= Arrays.asList(forNow); 
		  
		
		  final String uri1 = "http://localhost:8085/customer"; //icici 
		  StudentPojo[] forNow1 = restTemplate.getForObject(uri1, StudentPojo[].class);
		  List<StudentPojo> list1= Arrays.asList(forNow1);
		  
		  List<StudentPojo> list2= new ArrayList<StudentPojo>();
		  
		
		  list1.forEach(item->{
		  
		  list.forEach(item1->{ 
			  if(item1.getId()==item.getId()) {
				  System.out.println("######################"+item.getEmail());
				  item1.setEmail(item.getEmail()); 
				  item1.setMobile(item.getMobile());
				  System.out.println("######################"+item1.getMobile());
				  list2.add(item1); }});
		  
		  });
		 
		  
		  
		  return new ResponseEntity<List<StudentPojo>>(list2, new HttpHeaders(), HttpStatus.OK);
		  
		  
	  }	
}
