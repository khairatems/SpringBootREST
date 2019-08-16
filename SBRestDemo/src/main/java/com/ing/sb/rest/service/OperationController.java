package com.ing.sb.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class OperationController {

	@Autowired
	private MathService mathService;

	@GetMapping("/sum")
	@Validated
	public long sum(@RequestParam(value = "x", required = false, defaultValue = "0")  Long x, 
			@RequestParam(value = "y", required = false, defaultValue = "0") Long y) throws NumberValidationException {
		final long result =  mathService.sum(x, y);
		return result;
	}

}
