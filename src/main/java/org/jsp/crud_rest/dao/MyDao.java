package org.jsp.crud_rest.dao;

import java.util.List;

import org.jsp.crud_rest.dto.Student;
import org.jsp.crud_rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyDao {

	@Autowired
	StudentRepository repository;

	public Student save(Student student) {
		return repository.save(student);
	}

	public List<Student> save(List<Student> students) {
		return repository.saveAll(students);
	}

	public List<Student> fetchAll() {
		return repository.findAll();
	}

	public Student fetchById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Student> fetchByName(String name) {
		return repository.findByName(name);
	}

	public Student fetchByMobile(long mobile) {
		return repository.findByMobile(mobile);
	}

	public List<Student> fetchByResult(String result) {
		return repository.findByResult(result);
	}

	public List<Student> fetchByPercentageGreater(double percentage) {
		return repository.findByPercentageGreaterThanEqual(percentage);
	}

	public List<Student> fetchByPercentageBetween(double percentage1, double percentage2) {
		return repository.findByPercentageBetween(percentage1, percentage2);
	}

	public List<Student> fetchByPercentageLesser(double percentage) {
		return repository.findByPercentageLessThan(percentage);
	}

	public List<Student> fetchByMathsEnglish(int marks) {
		return repository.findByMathsGreaterThanEqualAndEnglishGreaterThanEqual(marks, marks);
	}

	public List<Student> fetchByNameOrNumber(String name, long number) {
		return repository.findByNameOrMobile(name, number);
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
