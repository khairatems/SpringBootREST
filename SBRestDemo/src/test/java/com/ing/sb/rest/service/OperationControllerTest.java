/**
 * 
 */
package com.ing.sb.rest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.sb.rest.model.FormInput;

/**
 * Test class for OperationController.
 * 
 * @author 278684
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OperationController.class)
public class OperationControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objMapper;

	@Test
	public void testSumForPositiveInputs() throws Exception {
		final FormInput requestBody = new FormInput();
		requestBody.setNumber1(4);
		requestBody.setNumber2(5);
		String jsonBody = objMapper.writeValueAsString(requestBody);

		MvcResult mvcResult = mvc.perform(post("/api/sum").contentType(MediaType.APPLICATION_JSON).content(jsonBody))
				.andExpect(status().isOk()).andReturn();

		final String actualResponse = mvcResult.getResponse().getContentAsString();
		assertThat(objMapper.writeValueAsString(actualResponse)).isEqualTo(objMapper.writeValueAsString("9"));
	}

	@Test
	public void testSumForPartialInput() throws Exception {
		final FormInput requestBody = new FormInput();
		requestBody.setNumber2(5);
		String jsonBody = objMapper.writeValueAsString(requestBody);

		MvcResult mvcResult = mvc.perform(post("/api/sum").contentType(MediaType.APPLICATION_JSON).content(jsonBody))
				.andExpect(status().isOk()).andReturn();

		final String actualResponse = mvcResult.getResponse().getContentAsString();
		assertThat(objMapper.writeValueAsString(actualResponse)).isEqualTo(objMapper.writeValueAsString("5"));
	}
	
	@Test
	public void testSumForInvalidInputType() throws Exception {
		//TODO
	}

	@Test
	public void testSumForNegaiveInput() throws Exception {
		final FormInput requestBody = new FormInput();
		requestBody.setNumber1(4);
		requestBody.setNumber2(-5);
		String jsonBody = objMapper.writeValueAsString(requestBody);

		MvcResult mvcResult = mvc.perform(post("/api/sum").contentType(MediaType.APPLICATION_JSON).content(jsonBody))
				.andExpect(status().isBadRequest()).andReturn();

		assertThat(mvcResult.getResponse().getContentAsString()).contains("must be greater than or equal to 0");
	}

	@Test
	public void testSumForInputGreaterThanThreshold() throws Exception {
		final FormInput requestBody = new FormInput();
		requestBody.setNumber1(4000);
		requestBody.setNumber2(5);
		String jsonBody = objMapper.writeValueAsString(requestBody);

		MvcResult mvcResult = mvc.perform(post("/api/sum").contentType(MediaType.APPLICATION_JSON).content(jsonBody))
				.andExpect(status().isBadRequest()).andReturn();

		assertThat(mvcResult.getResponse().getContentAsString()).contains("must be less than or equal to 1000");
	}

}
