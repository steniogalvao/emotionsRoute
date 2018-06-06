package br.com.vsgdev.emotionsRoute.controller;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.exception.MandatoryField;
import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Purchase;
import br.com.vsgdev.emotionsRoute.repository.PurchaseRepository;
import br.com.vsgdev.emotionsRoute.utils.ConverterUtils;

@RestController
public class PurchaseController {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private ConverterUtils converterUtils;

	@GetMapping( "/purchase{purchaseId}" )
	public Purchase getPurchase( @PathVariable Long purchaseId ) throws NotFoundEntity {
		Optional<Purchase> response = purchaseRepository.findById( purchaseId );
		if ( response.isPresent() ) {
			return response.get();
		} else {
			throw new NotFoundEntity( String.valueOf( purchaseId ) );
		}
	}

	@PostMapping( "/purchase" )
	public Purchase postPurchase( @Validated @RequestBody Purchase purchase ) throws MandatoryField {
		try {
			return purchaseRepository.save( purchase );
		} catch ( ConstraintViolationException e ) {
			throw new MandatoryField( converterUtils.nullFields( e ) );
		}
	}

	@PutMapping( "/purchase" )
	public Purchase putPurchase( @Validated @RequestBody Purchase purchase ) throws NotFoundEntity {
		if ( purchase.getId() == null ) {
			throw new NotFoundEntity( "null" );
		} else {
			return purchaseRepository.save( purchase );
		}
	}

	@DeleteMapping( "/purchase/{purchaseId}" )
	public void cancelPurchase( @PathVariable Long purchaseId ) throws NotFoundEntity {
		Optional<Purchase> response = purchaseRepository.findById( purchaseId );
		if ( !response.isPresent() ) {
			throw new NotFoundEntity( String.valueOf( purchaseId ) );
		} else {
			Purchase purchase = response.get();
			purchase.setCanceled( true );
			purchaseRepository.save( purchase );
		}
	}

}
