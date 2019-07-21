package br.com.vsgdev.emotionsRoute.service;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import br.com.vsgdev.emotionsRoute.model.Tour;

public interface TourService {

	Optional<Tour> get( Long id );

	void delete( Long id ) throws BadRequestException;

	Tour put( Tour tour ) throws BadRequestException;

	Tour save( Tour tour );

}
