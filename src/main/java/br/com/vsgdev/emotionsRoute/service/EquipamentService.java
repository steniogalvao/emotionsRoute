package br.com.vsgdev.emotionsRoute.service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Equipament;

public interface EquipamentService {

	Equipament get(int id) throws NotFoundEntity;

	void delete(int id) throws NotFoundEntity;

	Equipament put(Equipament equipament) throws NotFoundEntity;

	Equipament save(Equipament equipament);

}
