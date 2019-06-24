package br.com.vsgdev.emotionsRoute.service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Invoice;

public interface InvoiceService {

	Invoice get(int id) throws NotFoundEntity;

	void delete(int id) throws NotFoundEntity;

	Invoice put(Invoice invoice) throws NotFoundEntity;

	Invoice save(Invoice invoice);

}
