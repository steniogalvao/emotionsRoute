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

import br.com.vsgdev.emotionsRoute.model.Transfer;
import br.com.vsgdev.emotionsRoute.service.TransferService;

@RestController
@RequestMapping( value = "/transfer" )
public class TransferController {

	@Autowired
	private TransferService transService;

	@GetMapping( "/{id}" )
	public Transfer getTour( @PathVariable Long id ) {
		Optional<Transfer> saved = transService.get( id );
		return saved.isPresent() ? saved.get() : null;

	}

	@PostMapping
	public ResponseEntity<Transfer> postTour( @Validated @RequestBody Transfer transfer ) {
		Transfer saved = transService.save( transfer );
		URI uri = UriComponentsBuilder.fromPath( "/transfer/{id}" ).buildAndExpand( saved.getId() ).toUri();
		return ResponseEntity.created( uri ).body( saved );
	}

	@PutMapping
	public Transfer putTour( @Validated @RequestBody Transfer transfer ) throws BadRequestException {
		return transService.put( transfer );
	}

	@DeleteMapping( "/{id}" )
	public void deleteTour( @PathVariable Long id ) throws BadRequestException {
		transService.delete( id );
	}

}
