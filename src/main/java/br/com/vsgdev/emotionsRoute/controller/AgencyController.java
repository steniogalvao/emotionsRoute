package br.com.vsgdev.emotionsRoute.controller;

import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.CNPJ;
import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.ID;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.exception.MandatoryField;
import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Agency;
import br.com.vsgdev.emotionsRoute.repository.AgencyRepository;

@RestController
public class AgencyController {

	@Autowired
	private AgencyRepository agencyRepository;

	@GetMapping( "/agency/{agencyId}" )
	public Agency getAgency( @PathVariable Long agencyId ) throws NotFoundEntity {
		Optional<Agency> response = agencyRepository.findById( agencyId );
		if ( response.isPresent() ) {
			return response.get();
		} else {
			throw new NotFoundEntity( ID, String.valueOf( agencyId ) );
		}
	}

	@GetMapping( "/agency/cnpj" )
	public Agency getAgencyByCnpj( @RequestParam( value = "cnpj", required = true ) String cnpj ) throws NotFoundEntity {
		Agency response = agencyRepository.findByCnpj( cnpj );
		if ( response != null ) {
			return response;
		} else {
			throw new NotFoundEntity( CNPJ, cnpj );
		}
	}

	@GetMapping( "/agency/name" )
	public List<Agency> getAgencyByName( @RequestParam( value = "name", required = true ) String name ) throws NotFoundEntity {
		return agencyRepository.findAllByNameContainingIgnoreCaseOrderByName( name );
	}

	@PostMapping( "/agency" )
	public Agency postAgency( @Validated @RequestBody Agency agency ) throws MandatoryField {
		if ( agency.getPassword() == null || agency.getPassword().isEmpty() ) {
			throw new MandatoryField( "password" );
		}
		return agencyRepository.save( agency );
	}

	@PutMapping( "/agency" )
	public Agency putAgency( @Validated @RequestBody Agency agency ) throws NotFoundEntity {
		if ( agency.getId() == null ) {
			throw new NotFoundEntity( ID, "null" );
		}
		Optional<Agency> response = agencyRepository.findById( agency.getId() );
		agency.setPassword( response.get().getPassword() );
		return agencyRepository.save( agency );
	}

	@DeleteMapping( "/agency/{agencyId}" )
	public void deleteAgency( @PathVariable Long agencyId ) throws NotFoundEntity {
		Optional<Agency> response = agencyRepository.findById( agencyId );
		if ( !response.isPresent() ) {
			throw new NotFoundEntity( ID, String.valueOf( agencyId ) );
		} else {
			Agency agency = response.get();
			agency.setActive( false );
			agencyRepository.save( agency );
		}
	}

}
