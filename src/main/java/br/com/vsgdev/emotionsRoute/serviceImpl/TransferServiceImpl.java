package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.model.Transfer;
import br.com.vsgdev.emotionsRoute.repository.TransferRepository;
import br.com.vsgdev.emotionsRoute.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private TransferRepository transferRep;

	@Override
	public Optional<Transfer> get( Long id ) {
		return transferRep.findById( id );
	}

	@Override
	public void delete( Long id ) throws BadRequestException {
		Optional<Transfer> response = get( id );
		if ( response.isPresent() ) {
			response.get().setDeleted( true );
			transferRep.save( response.get() );
		} else {
			throw new BadRequestException();
		}

	}

	@Override
	public Transfer put( Transfer transfer ) throws BadRequestException {
		if ( transfer.getId() != null && transferRep.existsById( transfer.getId() ) ) {
			return transferRep.save( transfer );
		} else {
			throw new BadRequestException();
		}
	}

	@Override
	public Transfer save( Transfer transfer ) {
		if ( transfer.getId() == null ) {
			return transferRep.save( transfer );
		} else {
			// may throw an exception
			return null;
		}
	}

}
