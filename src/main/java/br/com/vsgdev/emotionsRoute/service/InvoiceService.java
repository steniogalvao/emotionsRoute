package br.com.vsgdev.emotionsRoute.service;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import br.com.vsgdev.emotionsRoute.model.Invoice;

public interface InvoiceService {

	Optional<Invoice> get(Long id);

	void delete(Long id) throws BadRequestException;

	Invoice put(Invoice invoice) throws BadRequestException;

	Invoice save(Invoice invoice);
	
	void payInvoice(Long id)throws BadRequestException;

}
