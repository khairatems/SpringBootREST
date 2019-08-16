/**
 * 
 */
package com.ing.sb.rest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test class for OperationController.
 * 
 * @author 278684
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationControllerTest {

	@Autowired
	OperationController controller;
	
	@MockBean
	MathService mathService;
	
	@Test
	public void testSumForPositiveInputs() {
		final long valueX = 10; 
		final long valueY = 15; 
		final long result = 25;
		when(mathService.sum(anyLong(), anyLong())).thenReturn(result);
		
		final long sumValue = controller.sum(valueX, valueY);

		assertEquals("Comparing result", sumValue, result);
		verify(mathService, times(1)).sum(anyLong(), anyLong());
	}
	
	@Test(expected = NumberValidationException.class)
	public void testSumForNegaiveInput() {
		final long valueX = -10; 
		final long valueY = 15; 
		doThrow(new NumberValidationException("Negative numbers not allowed.")).when(mathService).sum(valueX, valueY);
		
		controller.sum(valueX, valueY);
	}
	
	@Test(expected = NumberValidationException.class)
	public void testSumForInputGreaterThanThreshold() {
		final long valueX = 4000; 
		final long valueY = 15; 
		doThrow(new NumberValidationException("Number can not be greater than 1000.")).when(mathService).sum(valueX, valueY);
		
		controller.sum(valueX, valueY);
	}

}
