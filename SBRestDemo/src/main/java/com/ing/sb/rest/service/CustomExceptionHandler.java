package com.ing.sb.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class to handle response for custom exceptions.
 * 
 * @author MontyLenovo
 *
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handle numeric validation error.
	 * 
	 * @param validationError
	 * @return
	 */
	@ExceptionHandler(NumberValidationException.class)
	public ResponseEntity<String> handlerValidationError(NumberValidationException validationError) {
		return new ResponseEntity<>(validationError.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
