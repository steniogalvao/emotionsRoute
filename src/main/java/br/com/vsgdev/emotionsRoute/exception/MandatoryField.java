package br.com.vsgdev.emotionsRoute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST )
public class MandatoryField extends Exception {
	static final long serialVersionUID = -3387516993334229948L;

	public MandatoryField( String field ) {
		super( "must not be null " + field );
	}

}
