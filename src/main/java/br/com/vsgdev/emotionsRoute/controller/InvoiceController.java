package br.com.vsgdev.emotionsRoute.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.model.Invoice;
import br.com.vsgdev.emotionsRoute.service.InvoiceService;

@RestController
public class InvoiceController extends BaseController {

	@Autowired
	private InvoiceService invoiceService;

	@GetMapping( value = "/invoice/{id}" )
	public Invoice getInvoiceById( @PathVariable( required = true ) Long id ) {
		Optional<Invoice> result = invoiceService.get( id );
		return result.isPresent() ? result.get() : null;
	}

	@PostMapping( value = "/invoice" )
	public Invoice postInvoice( @RequestBody @Validated Invoice invoice ) {
		return invoiceService.save( invoice );
	}

	@PutMapping( value = "/invoice/pay/{id}" )
	public void payInvoice( @PathVariable( required = true ) Long id ) {
		invoiceService.payInvoice( id );
	}

	@PutMapping( value = "/invoice" )
	public Invoice putInvoice( @RequestBody @Validated Invoice invoice ) {
		return invoiceService.put( invoice );
	}

	@DeleteMapping( value = "/invoice/{id}" )
	public void deleteInvoice( @PathVariable( required = true ) Long id ) {
		invoiceService.delete( id );
	}

}
