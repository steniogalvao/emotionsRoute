package br.com.vsgdev.emotionsRoute.controller;

import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.CNPJ;
import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.EMAIL;
import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.ID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.exception.MandatoryField;
import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Agency;
import br.com.vsgdev.emotionsRoute.repository.AgencyRepository;
import br.com.vsgdev.emotionsRoute.repository.PersonRepository;
import br.com.vsgdev.emotionsRoute.utils.ConverterUtils;

@RestController
public class AgencyController extends BaseController {

	@Autowired
	private AgencyRepository agencyRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private ConverterUtils converterUtils;

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
	public ResponseEntity<Object> postAgency( @Validated @RequestBody Agency agency ) throws MandatoryField, ConstraintViolationException {
		if ( agency.getPassword() == null || agency.getPassword().isEmpty() ) {
			throw new MandatoryField( "password" );
		}
		Map<String, String> violationsMap = checkUniqueFields( agency );
		if ( !violationsMap.isEmpty() ) {
			return new ResponseEntity<Object>( converterUtils.errorReturn( "Already exists", violationsMap ), HttpStatus.BAD_REQUEST );
		}
		Agency agencySaved = agencyRepository.save( agency );
		return new ResponseEntity<Object>( agencySaved, HttpStatus.OK );
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

	private Map<String, String> checkUniqueFields( Agency agency ) {
		HashMap<String, String> uniqueFieldsMap = new HashMap<>();
		if ( agencyRepository.existsByEmail( agency.getEmail() ) || personRepository.existsByEmail( agency.getEmail() ) ) {
			uniqueFieldsMap.put( EMAIL, agency.getEmail() );
		}
		if ( agencyRepository.existsByCnpj( agency.getCnpj() ) ) {
			uniqueFieldsMap.put( CNPJ, agency.getCnpj() );
		}
		return uniqueFieldsMap;
	}

}
