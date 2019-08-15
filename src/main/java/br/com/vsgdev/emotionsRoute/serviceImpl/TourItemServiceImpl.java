package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.model.TourItem;
import br.com.vsgdev.emotionsRoute.repository.TourItemRepository;
import br.com.vsgdev.emotionsRoute.service.TourItemService;

@Service
public class TourItemServiceImpl implements TourItemService {

	@Autowired
	private TourItemRepository tourItemRep;

	@Override
	public Optional<TourItem> get( Long id ) {
		return tourItemRep.findById( id );

	}

	@Override
	public void delete( Long id ) throws BadRequestException {
		Optional<TourItem> response = get( id );
		if ( response.isPresent() ) {
			response.get().setDeleted( true );
			tourItemRep.save( response.get() );
		} else {
			throw new BadRequestException();
		}

	}

	@Override
	public TourItem put( TourItem tourItem ) throws BadRequestException {
		if ( tourItem.getId() != null && tourItemRep.existsById( tourItem.getId() ) ) {
			return tourItemRep.save( tourItem );
		} else {
			throw new BadRequestException();
		}
	}

	@Override
	public TourItem save( TourItem tourItem ) {
		if ( tourItem.getId() == null ) {
			return tourItemRep.save( tourItem );
		} else {
			// may throw an exception
			return null;
		}
	}

}
