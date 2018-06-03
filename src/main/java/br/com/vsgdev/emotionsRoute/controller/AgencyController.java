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
import br.com.vsgdev.emotionsRoute.model.Agency;
import br.com.vsgdev.emotionsRoute.repository.AgencyReposirory;
import br.com.vsgdev.emotionsRoute.utils.ConverterUtils;

@RestController
@RequestMapping( "/agency" )
public class AgencyController {

	@Autowired
	private AgencyReposirory agencyRepository;

	@Autowired
	private ConverterUtils converterUtils;

	@GetMapping
	public Agency getAgency( @PathVariable Long agencyId ) throws NotFoundEntity {
		Optional<Agency> response = agencyRepository.findById( agencyId );
		if ( response.isPresent() ) {
			return response.get();
		} else {
			throw new NotFoundEntity( String.valueOf( agencyId ) );
		}
	}

	@PostMapping
	public Agency postAgency( @RequestBody Agency agency ) throws MandatoryField {
		try {
			return agencyRepository.save( agency );
		} catch ( ConstraintViolationException e ) {
			throw new MandatoryField( converterUtils.nullFields( e ) );
		}
	}

	@PutMapping
	public Agency putAgency( @RequestBody Agency agency ) throws MandatoryField {
		try {
			return agencyRepository.save( agency );
		} catch ( ConstraintViolationException e ) {
			throw new MandatoryField( converterUtils.nullFields( e ) );
		}
	}

	@DeleteMapping
	public void deleteAgency( @PathVariable Long agencyId ) throws NotFoundEntity {
		Optional<Agency> response = agencyRepository.findById( agencyId );
		if ( !response.isPresent() ) {
			throw new NotFoundEntity( String.valueOf( agencyId ) );
		} else {
			Agency agency = response.get();
			agency.setActive( false );
			agencyRepository.save( agency );
		}
	}

}
