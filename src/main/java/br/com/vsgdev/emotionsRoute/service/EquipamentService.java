package br.com.vsgdev.emotionsRoute.service;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import br.com.vsgdev.emotionsRoute.model.Equipament;

public interface EquipamentService {

	Optional<Equipament> get( Long id );

	void delete( Long id ) throws BadRequestException;

	Equipament put( Equipament equipament );

	Equipament save( Equipament equipament );

}
