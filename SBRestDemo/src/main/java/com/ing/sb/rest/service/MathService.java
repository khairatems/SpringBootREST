/**
 * 
 */
package com.ing.sb.rest.service;
 
import org.springframework.stereotype.Service;

/**
 * Class to provide mathematical operation implementation.
 * 
 * @author 278684
 *
 */
@Service
public class MathService {

	public long sum(final long valueX, final long valueY) throws NumberValidationException {
		System.out.println("In service ..." + valueX + " : " + valueY);
		// default return
		long result = 0L;

		// validate boundries
		validate(valueX);
		validate(valueY);

		if (valueX >= 0 && valueY >= 0) {																							
			// return sum
			result = (valueX + valueY);
		} 

		return result;
	}

	private boolean validate(final long number) throws NumberValidationException {
		if (number < 0) {
			throw new NumberValidationException("Negative numbers not allowed.");
		} else if (number > 1000) {
			throw new NumberValidationException("Number can not be greater than 1000.");
		}
		return true;
	}

}
