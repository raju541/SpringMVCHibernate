package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.error.IdIsNotFoundException;
import com.cts.pojo.StudentPojo;
import com.cts.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping
	public ResponseEntity<List<StudentPojo>> insert(@RequestBody StudentPojo student){
		
		List<StudentPojo> list=studentService.insert(student);
		return new ResponseEntity<List<StudentPojo>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<StudentPojo>> select(){
		
		List<StudentPojo> list=studentService.getAll();
		return new ResponseEntity<List<StudentPojo>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/{id}/{name}")
	public ResponseEntity<StudentPojo> update(@PathVariable("id") int id, @PathVariable("name") String name){
		
		StudentPojo studentPojo=studentService.update(id,name);
		return new ResponseEntity<StudentPojo>(studentPojo, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<StudentPojo> delete(@PathVariable("id") int id) throws IdIsNotFoundException{
		
		StudentPojo studentPojo=studentService.delete(id);
		return new ResponseEntity<StudentPojo>(studentPojo, new HttpHeaders(), HttpStatus.OK);
	}
		
}
