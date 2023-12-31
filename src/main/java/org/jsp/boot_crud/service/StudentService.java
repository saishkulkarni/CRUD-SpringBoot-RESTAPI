package org.jsp.boot_crud.service;

import java.util.List;

import org.jsp.boot_crud.dao.StudentDao;
import org.jsp.boot_crud.dto.Student;
import org.jsp.boot_crud.exception.DataNotFoundException;
import org.jsp.boot_crud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public ResponseStructure<Student> create(Student student) {
		double percentage = (student.getEnglish() + student.getMaths() + student.getScience()) / 3.0;
		student.setPercentage(percentage);
		if (student.getEnglish() < 35 || student.getScience() < 35 || student.getMaths() < 35)
			student.setResult("fail");
		else {
			if (percentage >= 85)
				student.setResult("distinction");
			else if (percentage >= 60)
				student.setResult("firstclass");
			else
				student.setResult("secondclass");
		}
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setMessage("Data Saved Success");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.save(student));
		return structure;

	}

	public ResponseStructure<List<Student>> create(List<Student> students) {
		for (Student student : students) {
			double percentage = (student.getEnglish() + student.getMaths() + student.getScience()) / 3.0;
			student.setPercentage(percentage);
			if (student.getEnglish() < 35 || student.getScience() < 35 || student.getMaths() < 35)
				student.setResult("fail");
			else {
				if (percentage >= 85)
					student.setResult("distinction");
				else if (percentage >= 60)
					student.setResult("firstclass");
				else
					student.setResult("secondclass");
			}
		}
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		List<Student> list = dao.saveAll(students);
		structure.setData(list);
		structure.setMessage("Data Saved Success");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseStructure<List<Student>> fetchAll() {
		List<Student> list = dao.fetchAll();
		if (list.isEmpty())
			throw new DataNotFoundException();

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(list);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<Student> findById(int id) {
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setMessage("Data Saved Success");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.findById(id));
		return structure;
	}

	public ResponseStructure<List<Student>> fetchByName(String name) {
		List<Student> list = dao.findByName(name);
		if (list.isEmpty())
			throw new DataNotFoundException();

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(list);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<List<Student>> fetchByMobile(long no) {
		List<Student> list = dao.findByMobile(no);
		if (list.isEmpty())
			throw new DataNotFoundException();

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(list);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<List<Student>> fetchByResult(String result) {
		List<Student> list = dao.findByResult(result);
		if (list.isEmpty())
			throw new DataNotFoundException();

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(list);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<List<Student>> fetchByPercentageGreater(double percentage) {
		List<Student> list = dao.findByPercentageGreater(percentage);
		if (list.isEmpty())
			throw new DataNotFoundException();

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(list);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<List<Student>> fetchByPercentageLesser(double percentage) {
		List<Student> list = dao.findByPercentageLesser(percentage);
		if (list.isEmpty())
			throw new DataNotFoundException();

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(list);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

}
