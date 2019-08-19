package com.ing.sb.rest.service;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.sb.rest.model.FormInput;

@RestController
@RequestMapping(path = "/api")
public class OperationController {

	@PostMapping("/sum")
	@Validated
	public long sum(@Valid @RequestBody FormInput request){
		final int result =  request.getNumber1() + request.getNumber2();
		return result;
	}

}
