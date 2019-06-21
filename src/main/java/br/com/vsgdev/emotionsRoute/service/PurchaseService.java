package br.com.vsgdev.emotionsRoute.service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Purchase;

public interface PurchaseService {

	Purchase get(Long id) throws NotFoundEntity;

	void delete(Long id) throws NotFoundEntity;

	Purchase put(Purchase purchase) throws NotFoundEntity;

	Purchase save(Purchase purchase);

}
