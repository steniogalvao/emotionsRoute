package br.com.vsgdev.emotionsRoute.service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Transfer;

public interface TransferService {

	Transfer get(Long id) throws NotFoundEntity;

	void delete(Long id) throws NotFoundEntity;

	Transfer put(Transfer transfer) throws NotFoundEntity;

	Transfer save(Transfer transfer);

}
