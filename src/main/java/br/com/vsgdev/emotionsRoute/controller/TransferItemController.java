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

import br.com.vsgdev.emotionsRoute.model.TransferItem;
import br.com.vsgdev.emotionsRoute.service.TransferItemService;

@RestController
@RequestMapping( value = "/transferItem" )
public class TransferItemController {

	@Autowired
	private TransferItemService transItemService;

	@GetMapping( "/{id}" )
	public TransferItem getTour( @PathVariable Long id ) {
		Optional<TransferItem> saved = transItemService.get( id );
		return saved.isPresent() ? saved.get() : null;

	}

	@PostMapping
	public ResponseEntity<TransferItem> postTour( @Validated @RequestBody TransferItem transferItem ) {
		TransferItem saved = transItemService.save( transferItem );
		URI uri = UriComponentsBuilder.fromPath( "/transferItem/{id}" ).buildAndExpand( saved.getId() ).toUri();
		return ResponseEntity.created( uri ).body( saved );
	}

	@PutMapping
	public TransferItem putTour( @Validated @RequestBody TransferItem transferItem ) throws BadRequestException {
		return transItemService.put( transferItem );
	}

	@DeleteMapping( "/{id}" )
	public void deleteTour( @PathVariable Long id ) throws BadRequestException {
		transItemService.delete( id );
	}

}
