package org.jsp.boot_crud.service;

import java.util.List;

import org.jsp.boot_crud.dao.StudentDao;
import org.jsp.boot_crud.dto.Student;
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

	public List<Student> create(List<Student> students) {
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

		return dao.saveAll(students);
	}

	public List<Student> fetchAll() {
		return dao.fetchAll();
	}

	public Student findById(int id) {
		return dao.findById(id);
	}

	public List<Student> fetchByName(String name) {
		return dao.findByName(name);
	}

	public List<Student> fetchByMobile(long no) {
		return dao.findByMobile(no);
	}

	public List<Student> fetchByResult(String result) {
		return dao.findByResult(result);
	}

	public List<Student> fetchByPercentageGreater(double percentage) {
		return dao.findByPercentageGreater(percentage);
	}

	public List<Student> fetchByPercentageLesser(double percentage) {
		return dao.findByPercentageLesser(percentage);
	}

}
