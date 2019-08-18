package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.model.TransferItem;
import br.com.vsgdev.emotionsRoute.repository.TransferItemRepository;
import br.com.vsgdev.emotionsRoute.service.TransferItemService;

@Service
public class TransferItemServiceImpl implements TransferItemService {

	@Autowired
	private TransferItemRepository transItRep;

	@Override
	public Optional<TransferItem> get( Long id ) {
		return transItRep.findById( id );

	}

	@Override
	public void delete( Long id ) throws BadRequestException {
		Optional<TransferItem> response = get( id );
		if ( response.isPresent() ) {
			response.get().setDeleted( true );
			transItRep.save( response.get() );
		} else {
			throw new BadRequestException();
		}

	}

	@Override
	public TransferItem put( TransferItem transferItem ) throws BadRequestException {
		if ( transferItem.getId() != null && transItRep.existsById( transferItem.getId() ) ) {
			return transItRep.save( transferItem );
		} else {
			throw new BadRequestException();
		}
	}

	@Override
	public TransferItem save( TransferItem transferItem ) {
		if ( transferItem.getId() == null ) {
			return transItRep.save( transferItem );
		} else {
			// may throw an exception
			return null;
		}
	}

}
