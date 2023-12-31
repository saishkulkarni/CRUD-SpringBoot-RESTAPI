package org.jsp.boot_crud.dao;

import java.util.List;

import org.jsp.boot_crud.dto.Student;
import org.jsp.boot_crud.exception.DataNotFoundException;
import org.jsp.boot_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository repository;

	public Student save(Student student) {
		return repository.save(student);
	}

	public List<Student> saveAll(List<Student> students) {
		return repository.saveAll(students);
	}

	public List<Student> fetchAll() {
		return repository.findAll();
	}

	public Student findById(int id) {
		return repository.findById(id).orElseThrow(() -> new DataNotFoundException());
	}

	public List<Student> findByName(String name) {
		return repository.findByName(name);
	}

	public List<Student> findByMobile(long no) {
		return repository.findByMobile(no);
	}

	public List<Student> findByResult(String result) {
		return repository.findByResult(result);
	}

	public List<Student> findByPercentageGreater(double percentage) {
		return repository.findByPercentageGreaterThanEqual(percentage);
	}

	public List<Student> findByPercentageLesser(double percentage) {

		return repository.findByPercentageLessThan(percentage);
	}

}
