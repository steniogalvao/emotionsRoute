package br.com.vsgdev.emotionsRoute.service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Address;

public interface AddressService {

	Address get(int id) throws NotFoundEntity;

	void delete(int id) throws NotFoundEntity;

	Address put(Address address) throws NotFoundEntity;

	Address save(Address address);

}
