package com.cts.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.cts.error.IdIsNotFoundException;
import com.cts.pojo.StudentPojo;

@Repository
public class StudentDao {
	@Autowired
	StudentRepository studentRepository;
	StudentPojo studentPojo=null;
	List<StudentPojo> list=null;

	public List<StudentPojo> insert(StudentPojo student) {
		
		studentRepository.save(student);
		
		return studentRepository.findAll();
	}
	@Cacheable("StudentCache")
	public List<StudentPojo> getAll() {
		System.out.println("This is Student Cache");
		return studentRepository.findAll();
	}

	public StudentPojo update(int id, String name) {
		
		StudentPojo studentPojo=studentRepository.findById(id).get();
		studentPojo.setName(name);
		studentRepository.save(studentPojo);
		return studentPojo;
	}

	public StudentPojo delete(int id) throws IdIsNotFoundException {
		Optional<StudentPojo> studentPojo=studentRepository.findById(id);
		if(studentPojo.isPresent()) {
			studentRepository.deleteById(id);
	    }
		else {
			throw new IdIsNotFoundException("Invalid Student uid : " + id);
		}
		return (StudentPojo) studentRepository.findAll();
	}

}
