package br.com.vsgdev.emotionsRoute.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Address;
import br.com.vsgdev.emotionsRoute.service.AddressService;

@RestController
public class AddressController extends BaseController {

	@Autowired
	private AddressService addressService;

	@GetMapping( "/address/{addressId}" )
	public Address gerAddress( @PathVariable Long addressId ) throws NotFoundEntity {
		Optional<Address> addressResult = addressService.get( addressId );
		return addressResult.isPresent() ? addressResult.get() : null;
	}

	@PostMapping( "/address" )
	public ResponseEntity<Object> postAgency( @Validated @RequestBody Address address ) {
		Address addressSaved = addressService.save( address );
		return new ResponseEntity<Object>( addressSaved, HttpStatus.OK );
	}

	@PutMapping( "/address" )
	public Address putAgency( @Validated @RequestBody Address address ) {
		return addressService.put( address );
	}

	@DeleteMapping( "/address/{addressId}" )
	public void deleteAgency( @PathVariable Long addressId ) {
		addressService.delete( addressId );
	}

}
