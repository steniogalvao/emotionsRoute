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

import br.com.vsgdev.emotionsRoute.model.Tour;
import br.com.vsgdev.emotionsRoute.service.TourService;

@RestController
@RequestMapping( value = "/tour" )
public class TourController {

	@Autowired
	private TourService tourService;

	@GetMapping( "/{id}" )
	public Tour getTour( @PathVariable Long id ) {
		Optional<Tour> saved = tourService.get( id );
		return saved.isPresent() ? saved.get() : null;

	}

	@PostMapping
	public ResponseEntity<Tour> postTour( @Validated @RequestBody Tour tour ) {
		Tour saved = tourService.save( tour );
		URI uri = UriComponentsBuilder.fromPath( "/tour/{id}" ).buildAndExpand( saved.getId() ).toUri();
		return ResponseEntity.created( uri ).body( saved );
	}

	@PutMapping
	public Tour putTour( @Validated @RequestBody Tour tour ) throws BadRequestException {
		return tourService.put( tour );
	}

	@DeleteMapping( "/{id}" )
	public void deleteTour( @PathVariable Long id ) throws BadRequestException {
		tourService.delete( id );
	}

}
