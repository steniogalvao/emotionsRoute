package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.model.Tour;
import br.com.vsgdev.emotionsRoute.repository.TourRepository;
import br.com.vsgdev.emotionsRoute.service.TourService;

@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourRepository tourRep;

	@Override
	public Optional<Tour> get( Long id ) {
		return tourRep.findById( id );
	}

	@Override
	public void delete( Long id ) throws BadRequestException {
		Optional<Tour> response = get( id );
		if ( response.isPresent() ) {
			response.get().setDeleted( false );
			tourRep.save( response.get() );
		} else {
			throw new BadRequestException();
		}

	}

	@Override
	public Tour put( Tour tour ) throws BadRequestException {
		if ( tour.getId() != null && tourRep.existsById( tour.getId() ) ) {
			return tourRep.save( tour );
		} else {
			throw new BadRequestException();
		}
	}

	@Override
	public Tour save( Tour tour ) {
		if ( tour.getId() == 0 ) {
			return tourRep.save( tour );
		} else {
			// may throw an exception
			return null;
		}
	}

}
