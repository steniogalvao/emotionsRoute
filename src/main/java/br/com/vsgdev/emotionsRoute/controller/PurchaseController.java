package br.com.vsgdev.emotionsRoute.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.model.Purchase;
import br.com.vsgdev.emotionsRoute.service.PurchaseService;

@RestController
@RequestMapping( value = "/purchase" )
public class PurchaseController {

	@Autowired
	private PurchaseService purService;

	@GetMapping( "/{id}" )
	@ResponseBody
	public Purchase getPurchase( @PathVariable Long id ) {
		Optional<Purchase> response = purService.get( id );
		return response.isPresent() ? response.get() : null;
	}

	@PostMapping
	@ResponseBody
	public Purchase postPurchase( @Validated @RequestBody Purchase purchase ) throws BadRequestException {
		purchase.setPurchaseDate( LocalDateTime.now() );
		return purService.save( purchase );
	}

	@PutMapping
	@ResponseBody
	public Purchase putPurchase( @Validated @RequestBody Purchase purchase ) throws BadRequestException {
		return purService.put( purchase );
	}

	@PutMapping( "/{id}" )
	@ResponseBody
	public Purchase cancelPurchase( @PathVariable Long id ) throws BadRequestException {
		return purService.cancel( id );
	}

}
