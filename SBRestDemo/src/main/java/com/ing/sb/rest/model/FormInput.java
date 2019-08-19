/**
 * 
 */
package com.ing.sb.rest.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Represent request data.
 * 
 * @author 278684
 *
 */
public class FormInput {

	@Min(0)
	@Max(1000)
	private int number1;
	
	@Min(0)
	@Max(1000)
	private int number2;

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	@Override
	public String toString() {
		return "FormInput [number1=" + number1 + ", number2=" + number2 + "]";
	}

}
