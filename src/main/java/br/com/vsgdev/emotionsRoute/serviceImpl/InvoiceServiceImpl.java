package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.model.Invoice;
import br.com.vsgdev.emotionsRoute.repository.InvoiceRepository;
import br.com.vsgdev.emotionsRoute.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invRep;

	@Override
	public Optional<Invoice> get( Long id ) {
		return invRep.findById( id );
	}

	@Override
	public void delete( Long id ) throws BadRequestException {
		Optional<Invoice> response = get( id );
		if ( response.isPresent() ) {
			response.get().setDeleted( true );
			invRep.save( response.get() );
		} else {
			throw new BadRequestException();
		}

	}

	@Override
	public Invoice put( Invoice invoice ) throws BadRequestException {
		if ( invoice.getId() != null && invRep.existsById( invoice.getId() ) ) {
			return invRep.save( invoice );
		} else {
			throw new BadRequestException();
		}
	}

	@Override
	public Invoice save( Invoice invoice ) {
		if ( invoice.getId() == null ) {
			invoice.setDate( LocalDateTime.now() );
			return invRep.save( invoice );
		} else {
			// may throw an exception
			return null;
		}
	}

	@Override
	public void payInvoice( Long id ) throws BadRequestException {
		Optional<Invoice> result = get( id );
		if ( result.isPresent() ) {
			result.get().setPaid( true );
			invRep.save( result.get() );
		} else {
			throw new BadRequestException();
		}
	}

}
