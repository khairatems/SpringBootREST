package com.ing.sb.rest.service;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.sb.rest.model.FormInput;

@RestController
@RequestMapping(path = "/api")
public class OperationController {

	@PostMapping(value = "/sum", produces = MediaType.APPLICATION_JSON_VALUE)
	@Validated
	public ResponseEntity<String> sum(@Valid @RequestBody FormInput request){
		final int result =  request.getNumber1() + request.getNumber2();
		return new ResponseEntity<String>(String.valueOf(result), HttpStatus.OK);
	}

}
