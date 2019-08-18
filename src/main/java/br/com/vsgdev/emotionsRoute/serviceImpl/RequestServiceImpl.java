package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.model.Request;
import br.com.vsgdev.emotionsRoute.repository.RequestRepository;
import br.com.vsgdev.emotionsRoute.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestRepository reqRep;

	@Override
	public Optional<Request> get( Long id ) {
		return reqRep.findById( id );
	}

	@Override
	public void delete( Long id ) throws BadRequestException {
		Optional<Request> response = get( id );
		if ( response.isPresent() ) {
			response.get().setDeleted( true );
			reqRep.save( response.get() );
		} else {
			throw new BadRequestException();
		}

	}

	@Override
	public Request put( Request request ) throws BadRequestException {
		if ( request.getId() != null && reqRep.existsById( request.getId() ) ) {
			return reqRep.save( request );
		} else {
			throw new BadRequestException();
		}
	}

	@Override
	public Request save( Request request ) {
		if ( request.getId() == 0 ) {
			return reqRep.save( request );
		} else {
			// may throw an exception
			return null;
		}
	}

}
