package br.com.vsgdev.emotionsRoute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class NotFoundEntity extends Exception {
	static final long serialVersionUID = -3387516993334229948L;

	public NotFoundEntity( String message ) {
		super( "Entidade com o id '" + message + "' não encontrada" );
	}

}
