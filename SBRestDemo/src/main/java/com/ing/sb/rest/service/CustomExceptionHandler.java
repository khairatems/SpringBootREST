package com.ing.sb.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class to handle response for custom exceptions.
 * 
 * @author MontyLenovo
 *
 */
@RestController
@Validated
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handle numeric validation error.
	 * 
	 * @param validationError
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handlerValidationError(MethodArgumentNotValidException validationError) {
		return new ResponseEntity<>("Not a valid input. " +  validationError.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
