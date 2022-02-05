package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.StudentDao;
import com.cts.error.IdIsNotFoundException;
import com.cts.pojo.StudentPojo;
@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;
	
	public List<StudentPojo> insert(StudentPojo student) {
		return studentDao.insert(student);
	}

	public List<StudentPojo> getAll() {
		return studentDao.getAll();
	}

	public StudentPojo update(int id, String name) {
		return studentDao.update(id,name);
	}

	public StudentPojo delete(int id) throws IdIsNotFoundException {
		return studentDao.delete(id);
	}

}
