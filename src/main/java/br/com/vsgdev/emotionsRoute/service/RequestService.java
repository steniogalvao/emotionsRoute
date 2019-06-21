package br.com.vsgdev.emotionsRoute.service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Request;

public interface RequestService {

	Request get(Long id) throws NotFoundEntity;

	void delete(Long id) throws NotFoundEntity;

	Request put(Request request) throws NotFoundEntity;

	Request save(Request request);

}
