package br.com.vsgdev.emotionsRoute.service;

import java.util.Optional;

import br.com.vsgdev.emotionsRoute.model.Address;

public interface AddressService {

	Optional<Address> get( Long id );

	void delete( Long id );

	Address put( Address address );

	Address save( Address address );

}
