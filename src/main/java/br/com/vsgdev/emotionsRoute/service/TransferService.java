package br.com.vsgdev.emotionsRoute.service;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import br.com.vsgdev.emotionsRoute.model.Transfer;

public interface TransferService {

	Optional<Transfer> get(Long id) ;

	void delete(Long id) throws BadRequestException;

	Transfer put(Transfer transfer) throws BadRequestException;

	Transfer save(Transfer transfer);

}
