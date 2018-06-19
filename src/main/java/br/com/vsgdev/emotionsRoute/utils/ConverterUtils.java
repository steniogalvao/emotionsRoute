package br.com.vsgdev.emotionsRoute.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.model.ErrorResponse;

@Service
public class ConverterUtils {

	/**
	 * convert fields that violate a constrain in a String
	 * 
	 * @param constraintViolationException
	 */
	public String nullFields( ConstraintViolationException constraintViolationException ) {
		return constraintViolationException.getConstraintViolations().stream().map( violation -> {
			return violation.getPropertyPath().toString();
		} ).collect( Collectors.joining( ", " ) );
	}

	public List<ErrorResponse> errorReturn( String msg, Map<String, String> mapFields ) {
		return mapFields.keySet().stream().map( key -> {
			return new ErrorResponse( msg, key );
		} ).collect( Collectors.toList() );
	}
}
