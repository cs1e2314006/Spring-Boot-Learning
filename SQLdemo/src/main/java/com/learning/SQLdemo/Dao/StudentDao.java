package com.learning.SQLdemo.Dao;

import java.util.List;

import com.learning.SQLdemo.tables.Student;

public interface StudentDao {
	void save(Student theStudent);
	Student findbyId(int id);
	List<Student> findAll();
	List<Student> findbyFirstName(String param);
	void update(Student std);
	void delete(int id);
	int deleteAll();
}
