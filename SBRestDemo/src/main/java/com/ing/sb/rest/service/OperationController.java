package com.ing.sb.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/perform")
public class OperationController {

	@Autowired
	private MathService mathService;

	@GetMapping("/add/{x}/{y}")
	@Validated
	public long add(@PathVariable Optional<Long> x, @PathVariable Optional<Long> y) throws NumberValidationException {
		final long valueX = (x.isPresent()) ? x.get().longValue() : 0L;
		final long valueY = (y.isPresent()) ? y.get().longValue() : 0L;
		long result = mathService.sum(valueX, valueY);
		return result;
	}

}
