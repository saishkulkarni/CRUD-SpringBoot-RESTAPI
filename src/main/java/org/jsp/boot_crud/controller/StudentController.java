package org.jsp.boot_crud.controller;

import java.util.List;

import org.jsp.boot_crud.dto.Student;
import org.jsp.boot_crud.helper.ResponseStructure;
import org.jsp.boot_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@Operation(summary = "Save One Record")
	@PostMapping("/students")
	public ResponseEntity<ResponseStructure<Student>> create(@RequestBody Student student) {
		return new ResponseEntity<ResponseStructure<Student>>(service.create(student), HttpStatus.CREATED);
	}

	// Save Multiple Data
	@PostMapping("/students/many")
	public ResponseEntity<List<Student>> create(@RequestBody List<Student> students) {
		return new ResponseEntity<List<Student>>(service.create(students), HttpStatus.CREATED);
	}

	// Fetch All Data
	@GetMapping("/students")
	public ResponseEntity<List<Student>> fetchAll() {
		return new ResponseEntity<List<Student>>(service.fetchAll(), HttpStatus.FOUND);
	}

	// Fetch Data By Id
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> fetchById(@PathVariable int id) {
		return new ResponseEntity<Student>(service.findById(id), HttpStatus.FOUND);
	}

	// Fetch By Name
	@GetMapping("/students/name/{name}")
	public ResponseEntity<List<Student>> fetchByName(@PathVariable String name) {
		return new ResponseEntity<List<Student>>(service.fetchByName(name), HttpStatus.FOUND);
	}

	// Fetch By Mobile
	@GetMapping("/students/mobile/{no}")
	public ResponseEntity<List<Student>> fetchByMobile(@PathVariable long no) {
		return new ResponseEntity<List<Student>>(service.fetchByMobile(no), HttpStatus.FOUND);
	}

	// Fetch By Result
	@GetMapping("/students/result/{result}")
	public ResponseEntity<List<Student>> fetchByResults(@PathVariable String result) {
		return new ResponseEntity<List<Student>>(service.fetchByResult(result), HttpStatus.FOUND);
	}

	// Fetch By Percentage Greater
	@GetMapping("/students/percentage/greater/{percentage}")
	public ResponseEntity<List<Student>> fetchByPercentageGreater(@PathVariable double percentage) {
		return new ResponseEntity<List<Student>>(service.fetchByPercentageGreater(percentage), HttpStatus.FOUND);
	}

	// Fetch By Percentage Greater
	@GetMapping("/students/percentage/lesser/{percentage}")
	public ResponseEntity<List<Student>> fetchByPercentageLesser(@PathVariable double percentage) {
		return new ResponseEntity<List<Student>>(service.fetchByPercentageLesser(percentage), HttpStatus.FOUND);
	}
}
