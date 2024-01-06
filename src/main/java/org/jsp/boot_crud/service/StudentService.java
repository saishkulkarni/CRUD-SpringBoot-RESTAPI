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
			throw new DataNotFoundException("No Data Found with Name: " + name);

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(list);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<List<Student>> fetchByMobile(long no) {
		List<Student> list = dao.findByMobile(no);
		if (list.isEmpty())
			throw new DataNotFoundException("No Data Found with Mobile: " + no);

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(list);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<List<Student>> fetchByResult(String result) {
		List<Student> list = dao.findByResult(result);
		if (list.isEmpty())
			throw new DataNotFoundException("No Data Found with Result: " + result);

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(list);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<List<Student>> fetchByPercentageGreater(double percentage) {
		List<Student> list = dao.findByPercentageGreater(percentage);
		if (list.isEmpty())
			throw new DataNotFoundException("No Data Found with Percentage Greater Than: " + percentage);

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(list);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<List<Student>> fetchByPercentageLesser(double percentage) {
		List<Student> list = dao.findByPercentageLesser(percentage);
		if (list.isEmpty())
			throw new DataNotFoundException("No Data Found with Percentage Lesser Than: " + percentage);

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setData(list);
		structure.setMessage("Data Found");
		structure.setStatus(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<Student> deleteById(int id) {
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setData(dao.findById(id));
		dao.delete(id);
		structure.setMessage("Record Deleted Success");
		structure.setStatus(HttpStatus.OK.value());
		return structure;
	}

	public ResponseStructure<Student> update(Student student) {
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
		structure.setMessage("Data Updated Success");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.update(student));
		return structure;
	}

	public ResponseStructure<Student> update(int id, Student student) {
		Student student2 = dao.findById(id);

		if (student.getScience() != 0)
			student2.setScience(student.getScience());
		if (student.getMaths() != 0)
			student2.setMaths(student.getMaths());
		if (student.getEnglish() != 0)
			student2.setEnglish(student.getEnglish());
		if (student.getMobile() != 0)
			student2.setMobile(student.getMobile());
		if (student.getName() != null)
			student2.setName(student.getName());

		double percentage = (student2.getEnglish() + student2.getMaths() + student2.getScience()) / 3.0;
		student2.setPercentage(percentage);
		if (student2.getEnglish() < 35 || student2.getScience() < 35 || student2.getMaths() < 35)
			student2.setResult("fail");
		else {
			if (percentage >= 85)
				student2.setResult("distinction");
			else if (percentage >= 60)
				student2.setResult("firstclass");
			else
				student2.setResult("secondclass");
		}
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setMessage("Data Updated Success");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.update(student2));
		return structure;
	}

}
