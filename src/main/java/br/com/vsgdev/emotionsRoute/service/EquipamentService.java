package br.com.vsgdev.emotionsRoute.service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Equipament;

public interface EquipamentService {

	Equipament get( Long id ) throws NotFoundEntity;

	void delete( Long id ) throws NotFoundEntity;

	Equipament put( Equipament equipament ) throws NotFoundEntity;

	Equipament save( Equipament equipament );

}
