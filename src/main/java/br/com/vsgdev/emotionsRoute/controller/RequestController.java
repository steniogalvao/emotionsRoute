package br.com.vsgdev.emotionsRoute.controller;

import java.net.URI;
import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vsgdev.emotionsRoute.model.Request;
import br.com.vsgdev.emotionsRoute.service.RequestService;

@RestController
@RequestMapping( value = "/request" )
public class RequestController {

	@Autowired
	private RequestService reService;

	@GetMapping( "/{id}" )
	public Request getRequest( @PathVariable Long id ) {
		Optional<Request> saved = reService.get( id );
		return saved.isPresent() ? saved.get() : null;

	}

	@PostMapping
	public ResponseEntity<Request> postRequest( @Validated @RequestBody Request request ) {
		Request saved = reService.save( request );
		URI uri = UriComponentsBuilder.fromPath( "/request/{id}" ).buildAndExpand( saved.getId() ).toUri();
		return ResponseEntity.created( uri ).body( saved );
	}

	@PutMapping
	public Request putRequest( @Validated @RequestBody Request request ) throws BadRequestException {
		return reService.put( request );
	}

	@DeleteMapping( "/{id}" )
	public void deleteRequest( @PathVariable Long id ) throws BadRequestException {
		reService.delete( id );
	}

}
