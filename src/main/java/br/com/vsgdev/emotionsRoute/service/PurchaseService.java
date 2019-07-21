package br.com.vsgdev.emotionsRoute.service;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import br.com.vsgdev.emotionsRoute.model.Purchase;

public interface PurchaseService {

	Optional<Purchase> get(Long id);

	Purchase cancel(Long id) throws BadRequestException;

	Purchase put(Purchase purchase) throws BadRequestException;

	Purchase save(Purchase purchase);

}
