package org.jsp.crud_rest.controller;

import java.util.List;

import org.jsp.crud_rest.dto.Student;
import org.jsp.crud_rest.helper.ResponseStructure;
import org.jsp.crud_rest.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MyController {

	@Autowired
	MyService service;

	// Save One Record
	@PostMapping("/students")
	public ResponseEntity<ResponseStructure<Student>> insert(@RequestBody Student student) {
		return service.insert(student);
	}

	// Save Multiple Records
	@PostMapping("/students/many")
	public ResponseEntity<ResponseStructure<List<Student>>> insert(@RequestBody List<Student> students) {
		return service.insert(students);
	}

	// Fetch All Records
	@GetMapping("/students")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll() {
		return service.fetchAll();
	}

	// Fetch By Id Query Param
	@GetMapping("/students/id")
	public ResponseEntity<ResponseStructure<Student>> fetchById1(@RequestParam int id) {
		return service.fetchById(id);
	}

	// Fetch By Id Path Variable
	@GetMapping("/students/id/{id}")
	public ResponseEntity<ResponseStructure<Student>> fetchById2(@PathVariable int id) {
		return service.fetchById(id);
	}

	// Fetch By Name
	@GetMapping("/students/name/{name}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByName(@PathVariable String name) {
		return service.fetchByName(name);
	}

	// Fetch By Mobile
	@GetMapping("/students/mobile/{mobile}")
	public ResponseEntity<ResponseStructure<Student>> fetchByMobile(@PathVariable long mobile) {
		return service.fetchByMobile(mobile);
	}

	// Fetch By Result
	@GetMapping("/students/result/{result}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByResult(@PathVariable String result) {
		return service.fetchByResult(result);
	}

	// Fetch By Percentage Greater
	@GetMapping("/students/percentage/greater/{percentage}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageGreater(@PathVariable double percentage) {
		return service.fetchByPercentageGreater(percentage);
	}

	// Fetch By Percentage Between
	@GetMapping("/students/percentage/{percentage1}/{percentage2}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageBetween(@PathVariable double percentage1,
			@PathVariable double percentage2) {
		return service.fetchByPercentageBetween(percentage1, percentage2);
	}

	// Fetch By Percentage Lesser
	@GetMapping("/students/percentage/lesser/{percentage}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageLesser(@PathVariable double percentage) {
		return service.fetchByPercentageLesser(percentage);
	}

	// Fetch By Maths and English
	@GetMapping("/students/maths/english/{marks}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByMathsEnglish(@PathVariable int marks) {
		return service.fetchByMathsEnglish(marks);
	}

	// Fetch By Name or Number
	@GetMapping("/students/nameornumber/{data}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByNameorNumber(@PathVariable String data) {
		return service.fetchByNameorNumber(data);
	}

	// Delete By Id
	@DeleteMapping("/students/id/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}

	// Update One Record
	@PutMapping("/students")
	public ResponseEntity<ResponseStructure<Student>> update(@RequestBody Student student) {
		return service.update(student);
	}
	
	//Update Particular 
	@PatchMapping("/students/id/{id}")
	public ResponseEntity<ResponseStructure<Student>> update(@PathVariable int id,@RequestBody Student student) {
		return service.update(id,student);
	}
}
