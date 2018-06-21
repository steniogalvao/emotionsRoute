package br.com.vsgdev.emotionsRoute.controller;

import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.ID;

import java.time.LocalDateTime;
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

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Purchase;
import br.com.vsgdev.emotionsRoute.repository.PurchaseRepository;

@RestController
public class PurchaseController {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@GetMapping( "/purchase{purchadisseId}" )
	public Purchase getPurchase( @PathVariable Long purchaseId ) throws NotFoundEntity {
		Optional<Purchase> response = purchaseRepository.findById( purchaseId );
		if ( response.isPresent() ) {
			return response.get();
		} else {
			throw new NotFoundEntity( ID, String.valueOf( purchaseId ) );
		}
	}

	@PostMapping( "/purchase" )
	public Purchase postPurchase( @Validated @RequestBody Purchase purchase ) throws NotFoundEntity {
		purchase.setPurchaseDate( LocalDateTime.now() );
		return purchaseRepository.save( purchase );
	}

	@PutMapping( "/purchase" )
	public Purchase putPurchase( @Validated @RequestBody Purchase purchase ) throws NotFoundEntity {
		if ( purchaseRepository.existsById( purchase.getId() ) ) {
			purchase.setPurchaseDate( LocalDateTime.now() );
			return purchaseRepository.save( purchase );
		} else {
			throw new NotFoundEntity( ID, String.valueOf( purchase.getId() ) );
		}
	}

	@DeleteMapping( "/purchase/{purchaseId}" )
	public void cancelPurchase( @PathVariable Long purchaseId ) throws NotFoundEntity {
		Optional<Purchase> response = purchaseRepository.findById( purchaseId );
		if ( !response.isPresent() ) {
			throw new NotFoundEntity( ID, String.valueOf( purchaseId ) );
		} else {
			Purchase purchase = response.get();
			purchase.setCanceled( true );
			purchaseRepository.save( purchase );
		}
	}

}
