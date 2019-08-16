/**
 * 
 */
package com.ing.sb.rest.service;

import org.springframework.stereotype.Service;

/**
 * Class to provide implementation MathService.
 * 
 * @author 278684
 *
 */
@Service
public class MathServiceImpl implements MathService {

	/**
	 * Method to add two values.
	 * 
	 * @param valueX
	 * @param valueY
	 * @return
	 * @throws NumberValidationException
	 */
	public long sum(final long valueX, final long valueY) throws NumberValidationException {
		// default return
		long result = 0L;

		// validate boundries
		validate(valueX);
		validate(valueY);

		result = (valueX + valueY);
		return result;
	}

	/**
	 * Check input for boundary conditions.
	 * 
	 * @param number
	 * @return
	 * @throws NumberValidationException
	 */
	private boolean validate(final long number) throws NumberValidationException {
		if (number < 0) {
			throw new NumberValidationException("Negative numbers not allowed.");
		} else if (number > 1000) {
			throw new NumberValidationException("Number can not be greater than 1000.");
		}

		return true;
	}

}
