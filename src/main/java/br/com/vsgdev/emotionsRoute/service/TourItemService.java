package br.com.vsgdev.emotionsRoute.service;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import br.com.vsgdev.emotionsRoute.model.TourItem;

public interface TourItemService {

	Optional<TourItem> get( Long id );

	void delete( Long id ) throws BadRequestException;

	TourItem put( TourItem tourItem ) throws BadRequestException;

	TourItem save( TourItem tourItem );

}
