package br.com.vsgdev.emotionsRoute.service;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import br.com.vsgdev.emotionsRoute.model.TransferItem;

public interface TransferItemService {

	Optional<TransferItem> get( Long id );

	void delete( Long id ) throws BadRequestException;

	TransferItem put( TransferItem transferItem ) throws BadRequestException;

	TransferItem save( TransferItem transferItem );

}
