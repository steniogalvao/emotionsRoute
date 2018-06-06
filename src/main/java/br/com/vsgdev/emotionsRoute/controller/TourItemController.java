package br.com.vsgdev.emotionsRoute.controller;

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
import br.com.vsgdev.emotionsRoute.model.TourItem;
import br.com.vsgdev.emotionsRoute.repository.TourItemRepository;

@RestController
public class TourItemController {

	@Autowired
	private TourItemRepository tourItemRepository;

	@GetMapping( "/tourItem/{tourItemId}" )
	public TourItem getTourItem( @PathVariable Long tourItemId ) throws NotFoundEntity {
		Optional<TourItem> response = tourItemRepository.findById( tourItemId );
		if ( response.isPresent() ) {
			return response.get();
		} else {
			throw new NotFoundEntity( String.valueOf( tourItemId ) );
		}
	}

	@PostMapping( "/tourItemId" )
	public TourItem postTourItem( @Validated @RequestBody TourItem tourItem ) {
		return tourItemRepository.save( tourItem );
	}

	@PutMapping( "/tourItemId" )
	public TourItem putTourItem( @Validated @RequestBody TourItem tourItem ) throws NotFoundEntity {
		if ( tourItem.getId() == null ) {
			throw new NotFoundEntity( "null" );
		}
		return tourItemRepository.save( tourItem );
	}

	@DeleteMapping( "/tourItem" )
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
