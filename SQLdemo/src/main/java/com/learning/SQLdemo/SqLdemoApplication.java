package com.learning.SQLdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learning.SQLdemo.Dao.StudentDao;
import com.learning.SQLdemo.tables.Student;

import jakarta.persistence.EntityManager;

@SpringBootApplication
public class SqLdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqLdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {// injecting the studentDao
		return runner -> {
			// createStudent(studentDao);
			createMultiple(studentDao);

			// readStudent(studentDao);

			// ReadQuery(studentDao);
			// ReadByFirstName(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			// deleteAll(studentDao);
		};

	}

	private void deleteAll(StudentDao studentDao) {
		System.out.println("Deleting all rows");
		int numRow = studentDao.deleteAll();
		System.out.println("Number of Rows Deleted:- " + numRow);
	}

	private void deleteStudent(StudentDao studentDao) {
		// id of student who has to be deleted from database
		int id = 101;
		studentDao.delete(id);
		// checking in database
		ReadQuery(studentDao);

	}

	private void updateStudent(StudentDao studentDao) {

		int id = 1;
		// fetching data from table
		Student student = studentDao.findbyId(id);
		// changing the content
		student.setFirstName("Mohd");
		// updating the table
		studentDao.update(student);

		// printing result
		System.out.println(student);
	}

	private void ReadByFirstName(StudentDao studentDao) {

		List<Student> students = studentDao.findbyFirstName("jack");

		for (Student theStudent : students) {

			System.out.println(theStudent);
		}

	}

	private void ReadQuery(StudentDao studentDao) {

		List<Student> students = studentDao.findAll();

		for (Student theStudent : students) {

			System.out.println(theStudent);
		}

	}

	private void readStudent(StudentDao studentDao) {

		Student student = studentDao.findbyId(1);
		Student student2 = studentDao.findbyId(101);

		System.out.println("retreiving data from database");
		System.out.println(student);
		System.out.println(student2);
	}

	private void createMultiple(StudentDao studentDao) {

		System.out.println("Creating 3 student object");
		Student student1 = new Student("Mary", "Jain", "mary@gmail.com");
		Student student2 = new Student("John", "doe", "john@gmail.com");
		Student student3 = new Student("jack", "curran", "jack@gmail.com");
		// saving the object to database
		System.out.println("saving the object into database");
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);

	}

	private void createStudent(StudentDao studentDao) {

		// create a student object
		System.out.println("Creating a student object");
		Student student = new Student("Mohd", "Faizan", "abc@gmail.com");

		// saving the object to database
		System.out.println("saving the object into database");
		studentDao.save(student);

		// displaying the detail of saved student
		System.out.println(student.getFirstName() + " " + student.getLastName() + "\nid:- " + student.getId());
	}
}
