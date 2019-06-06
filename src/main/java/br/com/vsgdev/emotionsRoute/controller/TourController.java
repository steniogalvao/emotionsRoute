package br.com.vsgdev.emotionsRoute.controller;

import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.ID;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Tour;
import br.com.vsgdev.emotionsRoute.repository.TourRepository;

@RestController
public class TourController {

	@Autowired
	private TourRepository tourRepository;

	@GetMapping( "/tour/{tourId}" )
	public Tour getTour( @PathVariable Long tourId ) throws NotFoundEntity {
		Optional<Tour> response = tourRepository.findById( tourId );
		if ( response.isPresent() ) {
			return response.get();
		} else {
			throw new NotFoundEntity( ID, String.valueOf( tourId ) );
		}
	}

	@PostMapping( "/tour" )
	public Tour postTour( @Validated @RequestBody Tour tour ) {
		return tourRepository.save( tour );
	}

	@PutMapping( "/tour" )
	public Tour putTour( @Validated @RequestBody Tour tour ) throws NotFoundEntity {
		if ( tourRepository.existsById( tour.getId() ) ) {
			return tourRepository.save( tour );
		} else {
			throw new NotFoundEntity( ID, String.valueOf( tour.getId() ) );
		}
	}

	@DeleteMapping( "/tour/{tourId}" )
	public void deleteTour( @PathVariable Long tourId ) throws NotFoundEntity {
		Optional<Tour> response = tourRepository.findById( tourId );
		if ( !response.isPresent() ) {
			throw new NotFoundEntity( ID, String.valueOf( tourId ) );
		} else {
			Tour tour = response.get();
			tour.setActive( false );
			tourRepository.save( tour );
		}
	}

}
