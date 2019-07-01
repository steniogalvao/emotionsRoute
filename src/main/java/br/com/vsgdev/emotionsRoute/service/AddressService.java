package br.com.vsgdev.emotionsRoute.service;

import java.util.Optional;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Address;

public interface AddressService {

	Optional<Address> get( Long id ) throws NotFoundEntity;

	void delete( Long id ) throws NotFoundEntity;

	Address put( Address address );

	Address save( Address address );

}
