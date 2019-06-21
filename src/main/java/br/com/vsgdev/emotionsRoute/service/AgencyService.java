package br.com.vsgdev.emotionsRoute.service;

import java.util.List;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Agency;

public interface AgencyService {

	Agency get(int id) throws NotFoundEntity;

	void delete(int id) throws NotFoundEntity;

	Agency put(Agency agency) throws NotFoundEntity;

	Agency save(Agency agency);

	Agency findByIdAndActive(int id, boolean active) throws NotFoundEntity;

	Agency findByCnpj(String cnpj) throws NotFoundEntity;

	List<Agency> findAllByName(String name);

	boolean existsByEmail(String email);

	boolean existsByCnpj(String cnpj);
}
