package br.com.vsgdev.emotionsRoute.utils;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;

@Service
public class ConverterUtils {

	/**
	 * convert fields that violate a constrain in a String
	 * 
	 * @param constraintViolationException
	 */
	public String nullFields(ConstraintViolationException constraintViolationException) {
		return constraintViolationException.getConstraintViolations().stream().map(violation -> {
			return violation.getPropertyPath().toString();
		}).collect(Collectors.joining(", "));
	}
}
