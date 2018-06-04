package br.com.vsgdev.emotionsRoute.controller;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.exception.MandatoryField;
import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Tour;
import br.com.vsgdev.emotionsRoute.model.Tour;
import br.com.vsgdev.emotionsRoute.repository.TourRepository;
import br.com.vsgdev.emotionsRoute.utils.ConverterUtils;

@RestController
@RequestMapping( "/tour" )
public class TourController {

	@Autowired
	private TourRepository tourRepository;

	@Autowired
	private ConverterUtils converterUtils;

	@GetMapping
	public Tour getTour( @PathVariable Long tourId ) throws NotFoundEntity {
		Optional<Tour> response = tourRepository.findById( tourId );
		if ( response.isPresent() ) {
			return response.get();
		} else {
			throw new NotFoundEntity( String.valueOf( tourId ) );
		}
	}

	@PostMapping
	public Tour postTour( @RequestBody Tour tour ) throws MandatoryField {
		try {
			return tourRepository.save( tour );
		} catch ( ConstraintViolationException e ) {
			throw new MandatoryField( converterUtils.nullFields( e ) );
		}
	}

	@PutMapping
	public Tour putTour( @RequestBody Tour tour ) throws MandatoryField {
		try {
			return tourRepository.save( tour );
		} catch ( ConstraintViolationException e ) {
			throw new MandatoryField( converterUtils.nullFields( e ) );
		}
	}

	@DeleteMapping
	public void deleteTour( @PathVariable Long tourId ) throws NotFoundEntity {
		Optional<Tour> response = tourRepository.findById( tourId );
		if ( !response.isPresent() ) {
			throw new NotFoundEntity( String.valueOf( tourId ) );
		} else {
			Tour tour = response.get();
			tour.setActive( false );
			tourRepository.save( tour );
		}
	}

}
