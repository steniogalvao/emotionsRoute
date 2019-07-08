package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.vsgdev.emotionsRoute.model.Address;
import br.com.vsgdev.emotionsRoute.repository.AddressRepository;
import br.com.vsgdev.emotionsRoute.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addRep;

	@Override
	public Optional<Address> get( Long id ) {
		Optional<Address> result = addRep.findById( id );
		return result;
	}

	@Override
	public void delete( Long id ) throws BadRequestException {
		if ( StringUtils.isEmpty( id ) || !addRep.existsById( id ) ) {
			throw new BadRequestException();
		}
		addRep.deleteById( id );

	}

	@Override
	public Address put( Address address ) {
		if ( StringUtils.isEmpty( address.getId() ) || !addRep.existsById( address.getId() ) ) {
			throw new BadRequestException();
		}
		return addRep.save( address );
	}

	@Override
	public Address save( Address address ) {
		if ( address.getId() == null ) {
			return addRep.save( address );
		} else {
			// may throw an exception
			return null;
		}
	}

}
