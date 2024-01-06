package org.jsp.boot_crud.controller;

import java.util.List;

import org.jsp.boot_crud.dto.Student;
import org.jsp.boot_crud.helper.ResponseStructure;
import org.jsp.boot_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService service;

	@Operation(summary = "Save One Record")
	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> create(@RequestBody Student student) {
		return new ResponseEntity<ResponseStructure<Student>>(service.create(student), HttpStatus.CREATED);
	}

	// Save Multiple Data
	@PostMapping("/many")
	@Operation(summary = "Save Multiple Record")
	public ResponseEntity<ResponseStructure<List<Student>>> create(@RequestBody List<Student> students) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.create(students), HttpStatus.CREATED);
	}

	// Fetch All Data
	@GetMapping
	@Operation(summary = "Fetch All Records")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll() {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.fetchAll(), HttpStatus.FOUND);
	}

	// Fetch Data By Id
	@GetMapping("/{id}")
	@Operation(summary = "Fetch Record By Id")
	public ResponseEntity<ResponseStructure<Student>> fetchById(@PathVariable int id) {
		return new ResponseEntity<ResponseStructure<Student>>(service.findById(id), HttpStatus.FOUND);
	}

	// Fetch By Name
	@GetMapping("/name/{name}")
	@Operation(summary = "Fetch Record By Name")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByName(@PathVariable String name) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.fetchByName(name), HttpStatus.FOUND);
	}

	// Fetch By Mobile
	@GetMapping("/mobile/{no}")
	@Operation(summary = "Fetch Record By Mobile")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByMobile(@PathVariable long no) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.fetchByMobile(no), HttpStatus.FOUND);
	}

	// Fetch By Result
	@GetMapping("/result/{result}")
	@Operation(summary = "Fetch Record By Result")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByResults(@PathVariable String result) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.fetchByResult(result), HttpStatus.FOUND);
	}

	// Fetch By Percentage Greater
	@GetMapping("/percentage/greater/{percentage}")
	@Operation(summary = "Fetch Record Greater")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageGreater(@PathVariable double percentage) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.fetchByPercentageGreater(percentage),
				HttpStatus.FOUND);
	}

	// Fetch By Percentage Greater
	@GetMapping("/percentage/lesser/{percentage}")
	@Operation(summary = "Fetch Record Lesser")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageLesser(@PathVariable double percentage) {
		return new ResponseEntity<ResponseStructure<List<Student>>>(service.fetchByPercentageLesser(percentage),
				HttpStatus.FOUND);
	}
	
	//Delete By Id
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Record By Id")
	public ResponseEntity<ResponseStructure<Student>> deleteById(@PathVariable int id)
	{
		return new ResponseEntity<ResponseStructure<Student>>(service.deleteById(id),HttpStatus.OK);
	}
	
	//Update Record
	@PutMapping
	@Operation(summary = "Update All Record")
	public ResponseEntity<ResponseStructure<Student>> update(@RequestBody Student student) {
		return new ResponseEntity<ResponseStructure<Student>>(service.update(student), HttpStatus.OK);
	}
	
	//Update Record
	@PatchMapping("/{id}")
	@Operation(summary = "Update Particular Record")
	public ResponseEntity<ResponseStructure<Student>> patchUpdate(@PathVariable int id,@RequestBody Student student) {
		return new ResponseEntity<ResponseStructure<Student>>(service.update(id,student), HttpStatus.OK);
	}
	
}
