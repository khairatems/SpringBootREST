/**
 * 
 */
package com.ing.sb.rest.service;

import org.springframework.stereotype.Service;

/**
 * @author 278684
 *
 */
@Service
public class MathService {

	static MathService mathService = new MathService();
	public static long sum(final long valueX, final long valueY) {

		//default return 
		long result = 0L;
		
		//validate boundries
		validate(valueX);
		validate(valueY);
		

		if (valueX > 0 && valueY > 0) {
			//return sum
			result = (valueX + valueY);
		} else {
			//single number return value
			if (valueX == 0) {
				result = valueY;
			} else if(valueY == 0) {
				result = valueX;
			}
		}

		return result;
	}
	
	private static boolean validate(final long number) {
		if(number < 0) {
			throw new IllegalArgumentException("Negative numbers not allowed.");
		} else if(number > 1000) {
			throw new IllegalArgumentException("Number can not be greater than 1000.");
		}
		return true;
	}

}
