package com.ing.sb.rest.service;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MathServiceImplTest {

	@Autowired
	MathServiceImpl mathService;
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void testForPositiveNumbers() {
		long valueX = 3;
		long valueY = 5;

		long result = mathService.sum(valueX, valueY);
		assertTrue("Checking sum: ", (result==8));
	}
	
	@Test 
	public void testForNegativeNumbers() {
		expected.expect(NumberValidationException.class);
		expected.expectMessage("Negative numbers not allowed.");
		
		long valueX = 3;
		long valueY = -5;
		mathService.sum(valueX, valueY);
	}
	
	@Test 
	public void testForNumbersGreaterThanThreshold() {
		expected.expect(NumberValidationException.class);
		expected.expectMessage("Number can not be greater than 1000.");
		
		long valueX = 3;
		long valueY = 4000;
		mathService.sum(valueX, valueY);
	}

}
