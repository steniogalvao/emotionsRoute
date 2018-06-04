package br.com.vsgdev.emotionsRoute.controller;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.exception.MandatoryField;
import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Purchase;
import br.com.vsgdev.emotionsRoute.repository.PurchaseRepository;
import br.com.vsgdev.emotionsRoute.utils.ConverterUtils;

@RestController
@RequestMapping( "/purchase" )
public class PurchaseController {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private ConverterUtils converterUtils;

	@GetMapping
	public Purchase getPurchase( @PathVariable Long purchaseId ) throws NotFoundEntity {
		Optional<Purchase> response = purchaseRepository.findById( purchaseId );
		if ( response.isPresent() ) {
			return response.get();
		} else {
			throw new NotFoundEntity( String.valueOf( purchaseId ) );
		}
	}

	@PostMapping
	public Purchase postPurchase( @RequestBody Purchase purchase ) throws MandatoryField {
		try {
			return purchaseRepository.save( purchase );
		} catch ( ConstraintViolationException e ) {
			throw new MandatoryField( converterUtils.nullFields( e ) );
		}
	}

	@PutMapping
	public Purchase putPurchase( @RequestBody Purchase purchase ) throws MandatoryField {
		try {
			return purchaseRepository.save( purchase );
		} catch ( ConstraintViolationException e ) {
			throw new MandatoryField( converterUtils.nullFields( e ) );
		}
	}

	@DeleteMapping
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
