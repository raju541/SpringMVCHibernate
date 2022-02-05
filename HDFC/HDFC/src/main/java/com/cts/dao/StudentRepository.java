package com.cts.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pojo.StudentPojo;

@Repository
public interface StudentRepository extends JpaRepository<StudentPojo, Integer>{

}
