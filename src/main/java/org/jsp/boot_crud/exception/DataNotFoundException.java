package org.jsp.boot_crud.exception;

public class DataNotFoundException extends RuntimeException
{
	@Override
	public String getMessage() {
		return "No Data Found";
	}
}
