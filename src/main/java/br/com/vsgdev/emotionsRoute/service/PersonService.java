package br.com.vsgdev.emotionsRoute.service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Person;

public interface PersonService {

	Person get(Long id) throws NotFoundEntity;

	void delete(Long id) throws NotFoundEntity;

	Person put(Person person) throws NotFoundEntity;

	Person save(Person person);

	boolean existsByEmail(String email);

}
