package br.com.vsgdev.emotionsRoute.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.vsgdev.emotionsRoute.model.ErrorResponse;

public abstract class BaseController {

	@ExceptionHandler
	@ResponseStatus( HttpStatus.BAD_REQUEST )
	public List<ErrorResponse> handleException( MethodArgumentNotValidException exception ) {
		return exception.getBindingResult().getFieldErrors().stream().map( ex -> {
			return new ErrorResponse( ex.getDefaultMessage(), ex.getField() );
		} ).collect( Collectors.toList() );
	}

}
