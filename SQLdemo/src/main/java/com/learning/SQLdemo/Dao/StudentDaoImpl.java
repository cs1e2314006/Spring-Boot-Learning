package com.learning.SQLdemo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.SQLdemo.tables.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository // this annotations helps in component scanning and translating JDBC related exceptions
public class StudentDaoImpl implements StudentDao{
	
	// define field for entity manager 
	private EntityManager entityManager;
	
	// injecting entity manager 
	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	@Override
	@Transactional // it automatically begin and ends a transaction with DB
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
		
	}


	@Override
	public Student findbyId(int id) {
		Student student=entityManager.find(Student.class, id);
		return student;
	}


	@Override
	public List<Student> findAll() {
		TypedQuery<Student> myQuery=entityManager.createQuery("FROM Student order by firstName desc",Student.class);
		List<Student>studentList=myQuery.getResultList();
		return studentList;
	}


	@Override
	public List<Student> findbyFirstName(String param) {
	    TypedQuery<Student> myQuery = entityManager.createQuery(
	        "FROM Student WHERE firstName = :Data", Student.class
	    );
	    myQuery.setParameter("Data", param);

	    return myQuery.getResultList();
	}


	@Override
	@Transactional
	public void update(Student std) {
		entityManager.merge(std);
		
	}


	@Override
	@Transactional
	public void delete(int id) {
		Student std = entityManager.find(Student.class, id);
		entityManager.remove(std);
		
	}


	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsDeleted;
	}






}
