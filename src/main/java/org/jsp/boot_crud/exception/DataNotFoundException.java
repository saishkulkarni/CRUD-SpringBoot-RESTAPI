package org.jsp.boot_crud.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DataNotFoundException extends RuntimeException
{
	String message="No Data Found";
}
