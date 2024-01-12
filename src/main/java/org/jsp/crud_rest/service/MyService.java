package org.jsp.crud_rest.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.jsp.crud_rest.dao.MyDao;
import org.jsp.crud_rest.dto.Student;
import org.jsp.crud_rest.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	ResponseStructure<Student> structure;

	@Autowired
	ResponseStructure<List<Student>> structure1;

	@Autowired
	MyDao dao;

	public ResponseEntity<ResponseStructure<Student>> insert(Student student) {
		student.setPercentage((student.getMaths() + student.getScience() + student.getEnglish()) / 3);
		if (student.getScience() < 35 || student.getEnglish() < 35 || student.getMaths() < 35)
			student.setResult("Fail");
		else {
			if (student.getPercentage() >= 85)
				student.setResult("Distinction");
			else if (student.getPercentage() >= 60)
				student.setResult("First Class");
			else
				student.setResult("Second Class");
		}

		structure.setMessage("Data Saved Success");
		structure.setData(dao.save(student));
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> insert(List<Student> students) {
		for (Student student : students) {
			student.setPercentage((student.getMaths() + student.getScience() + student.getEnglish()) / 3);
			if (student.getScience() < 35 || student.getEnglish() < 35 || student.getMaths() < 35)
				student.setResult("Fail");
			else {
				if (student.getPercentage() >= 85)
					student.setResult("Distinction");
				else if (student.getPercentage() >= 60)
					student.setResult("First Class");
				else
					student.setResult("Second Class");
			}
		}

		structure1.setMessage("Data Saved Success");
		structure1.setData(dao.save(students));
		structure1.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll() {
		List<Student> students = dao.fetchAll();
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Student>> fetchById(int id) {
		Student student = dao.fetchById(id);
		if (student == null)
			throw new NoSuchElementException("No Records with id: " + id);
		structure.setMessage("Data Foud");
		structure.setData(student);
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByName(String name) {
		List<Student> students = dao.fetchByName(name);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present with name: " + name);
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Student>> fetchByMobile(long mobile) {
		Student student = dao.fetchByMobile(mobile);
		if (student == null)
			throw new NoSuchElementException("No Records with mobile: " + mobile);
		structure.setMessage("Data Foud");
		structure.setData(student);
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByResult(String result) {
		List<Student> students = dao.fetchByResult(result);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present with Result: " + result);
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageGreater(double percentage) {
		List<Student> students = dao.fetchByPercentageGreater(percentage);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present with Percentage Greater: " + percentage);
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageBetween(double percentage1,
			double percentage2) {
		List<Student> students = dao.fetchByPercentageBetween(percentage1, percentage2);
		if (students.isEmpty())
			throw new NoSuchElementException(
					"No Records Present with Percentage between: " + percentage1 + " and " + percentage2);
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageLesser(double percentage) {
		List<Student> students = dao.fetchByPercentageLesser(percentage);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByMathsEnglish(int marks) {
		List<Student> students = dao.fetchByMathsEnglish(marks);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByNameorNumber(String data) {
		List<Student> students = null;
		try {
			students = dao.fetchByNameOrNumber(null, Long.parseLong(data));
		} catch (NumberFormatException e) {
			students = dao.fetchByNameOrNumber(data, 0);
		}

		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<Student>> deleteById(int id) {
		structure.setData(dao.fetchById(id));
		dao.deleteById(id);
		structure.setMessage("Data Deleted Success");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<Student>> update(Student student) {
		student.setPercentage((student.getMaths() + student.getScience() + student.getEnglish()) / 3);
		if (student.getScience() < 35 || student.getEnglish() < 35 || student.getMaths() < 35)
			student.setResult("Fail");
		else {
			if (student.getPercentage() >= 85)
				student.setResult("Distinction");
			else if (student.getPercentage() >= 60)
				student.setResult("First Class");
			else
				student.setResult("Second Class");
		}

		structure.setMessage("Data Updated Success");
		structure.setData(dao.save(student));
		structure.setStatus(HttpStatus.OK.value());

		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Student>> update(int id, Student student) {
		Student student2 = dao.fetchById(id);

		if (student.getName() != null)
			student2.setName(student.getName());
		if (student.getMobile() != 0)
			student2.setMobile(student.getMobile());
		if (student.getDob() != null)
			student2.setDob(student.getDob());
		if (student.getMaths() != 0)
			student2.setMaths(student.getMaths());
		if (student.getScience() != 0)
			student2.setScience(student.getScience());
		if (student.getEnglish() != 0)
			student2.setEnglish(student.getEnglish());

		student2.setPercentage((student2.getMaths() + student2.getScience() + student2.getEnglish()) / 3);
		if (student2.getScience() < 35 || student2.getEnglish() < 35 || student2.getMaths() < 35)
			student2.setResult("Fail");
		else {
			if (student2.getPercentage() >= 85)
				student2.setResult("Distinction");
			else if (student2.getPercentage() >= 60)
				student2.setResult("First Class");
			else
				student2.setResult("Second Class");
		}

		structure.setMessage("Data Updated Success");
		structure.setData(dao.save(student2));
		structure.setStatus(HttpStatus.OK.value());

		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}

}
