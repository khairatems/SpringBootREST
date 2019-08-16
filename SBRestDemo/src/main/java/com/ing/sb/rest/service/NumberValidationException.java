package com.ing.sb.rest.service;

/**
 * Exception for numeric validation errors.
 * 
 * @author 278684
 *
 */
public class NumberValidationException extends RuntimeException {

	private static final long serialVersionUID = 8503941884277677433L;

	public NumberValidationException(String msg) {
		super(msg);
	}

}
