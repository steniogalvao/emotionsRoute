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
import br.com.vsgdev.emotionsRoute.model.TourItem;
import br.com.vsgdev.emotionsRoute.repository.TourItemRepository;
import br.com.vsgdev.emotionsRoute.utils.ConverterUtils;

@RestController
@RequestMapping( "/tourItem" )
public class TourItemController {

	@Autowired
	private TourItemRepository tourItemRepository;

	@Autowired
	private ConverterUtils converterUtils;

	@GetMapping
	public TourItem getTourItem( @PathVariable Long tourItemId ) throws NotFoundEntity {
		Optional<TourItem> response = tourItemRepository.findById( tourItemId );
		if ( response.isPresent() ) {
			return response.get();
		} else {
			throw new NotFoundEntity( String.valueOf( tourItemId ) );
		}
	}

	@PostMapping
	public TourItem postTourItem( @RequestBody TourItem tourItem ) throws MandatoryField {
		try {
			return tourItemRepository.save( tourItem );
		} catch ( ConstraintViolationException e ) {
			throw new MandatoryField( converterUtils.nullFields( e ) );
		}
	}

	@PutMapping
	public TourItem putTourItem( @RequestBody TourItem tourItem ) throws MandatoryField {
		try {
			return tourItemRepository.save( tourItem );
		} catch ( ConstraintViolationException e ) {
			throw new MandatoryField( converterUtils.nullFields( e ) );
		}
	}

	@DeleteMapping
	public void deleteTourItem( @PathVariable Long tourItemId ) throws NotFoundEntity {
		Optional<TourItem> response = tourItemRepository.findById( tourItemId );
		if ( !response.isPresent() ) {
			throw new NotFoundEntity( String.valueOf( tourItemId ) );
		} else {
			TourItem tourItem = response.get();
			tourItem.setActive( false );
			tourItemRepository.save( tourItem );
		}
	}

}
