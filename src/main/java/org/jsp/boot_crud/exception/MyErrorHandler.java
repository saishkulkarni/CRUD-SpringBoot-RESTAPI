package org.jsp.boot_crud.exception;

import org.jsp.boot_crud.helper.ResponseStructure;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyErrorHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ResponseStructure<String>> handler(DataIntegrityViolationException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage("Data Can not be Saved");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
}
