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

import br.com.vsgdev.emotionsRoute.model.TourItem;
import br.com.vsgdev.emotionsRoute.service.TourItemService;

@RestController
@RequestMapping( value = "/tourItem" )
public class TourItemController {

	@Autowired
	private TourItemService TIService;

	@GetMapping( "/{id}" )
	public TourItem getTour( @PathVariable Long id ) {
		Optional<TourItem> saved = TIService.get( id );
		return saved.isPresent() ? saved.get() : null;

	}

	@PostMapping
	public ResponseEntity<TourItem> postTour( @Validated @RequestBody TourItem tourItem ) {
		TourItem saved = TIService.save( tourItem );
		URI uri = UriComponentsBuilder.fromPath( "/tourItem/{id}" ).buildAndExpand( saved.getId() ).toUri();
		return ResponseEntity.created( uri ).body( saved );
	}

	@PutMapping
	public TourItem putTour( @Validated @RequestBody TourItem tourItem ) throws BadRequestException {
		return TIService.put( tourItem );
	}

	@DeleteMapping( "/{id}" )
	public void deleteTour( @PathVariable Long id ) throws BadRequestException {
		TIService.delete( id );
	}

}
