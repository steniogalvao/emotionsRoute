package br.com.vsgdev.emotionsRoute.service;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import br.com.vsgdev.emotionsRoute.model.Request;

public interface RequestService {

	Optional<Request> get(Long id);

	void delete(Long id) throws BadRequestException;

	Request put(Request request) throws BadRequestException;

	Request save(Request request);

}
