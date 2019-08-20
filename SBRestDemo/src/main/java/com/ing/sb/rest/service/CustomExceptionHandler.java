package com.ing.sb.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class to handle response for custom exceptions.
 * 
 * @author MontyLenovo
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {

	/**
	 * Handle numeric validation error.
	 * 
	 * @param validationError
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handlerValidationError(MethodArgumentNotValidException validationError) {
		final ErrorResponse response = new ErrorResponse();

		for (FieldError fieldError : validationError.getBindingResult().getFieldErrors()) {
			response.getFieldErrors().add(new FieldValidationResult(fieldError.getField(),
					fieldError.getRejectedValue().toString(), fieldError.getDefaultMessage()));
		}

		return response;

	}

	@ExceptionHandler(HttpMessageNotReadableException.class) // TODO or should it handle JsonParserException?
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handlerPasingError(HttpMessageNotReadableException parsingError) {
		final ErrorResponse response = new ErrorResponse();
		// TODO:

		return response;

	}

	private static class ErrorResponse {
		private final List<FieldValidationResult> fieldErrors = new ArrayList<>();

		public List<FieldValidationResult> getFieldErrors() {
			return fieldErrors;
		}
	}

	@SuppressWarnings("unused")
	private static class FieldValidationResult {
		private final String fieldName;
		private final String fieldValue;
		private final String message;

		public FieldValidationResult(String fieldName, String fieldValue, String message) {
			super();
			this.fieldName = fieldName;
			this.fieldValue = fieldValue;
			this.message = message;
		}

		public String getFieldValue() {
			return fieldValue;
		}

		public String getFieldName() {
			return fieldName;
		}

		public String getMessage() {
			return message;
		}

	}
}
