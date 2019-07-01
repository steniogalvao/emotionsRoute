package br.com.vsgdev.emotionsRoute.controller;

import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.CNPJ;
import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.EMAIL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.exception.MandatoryField;
import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Agency;
import br.com.vsgdev.emotionsRoute.service.AgencyService;
import br.com.vsgdev.emotionsRoute.service.PersonService;
import br.com.vsgdev.emotionsRoute.utils.ConverterUtils;

@RestController
public class AgencyController extends BaseController {

	@Autowired
	private AgencyService agencyService;
	@Autowired
	private PersonService personService;
	@Autowired
	private ConverterUtils converterUtils;

	@GetMapping( "/agency/{agencyId}" )
	public Agency getAgency( @PathVariable Long agencyId ) {
		Optional<Agency> agencyResult = agencyService.get( agencyId );
		return agencyResult.isPresent() ? agencyResult.get() : null;
	}

	@GetMapping( "/agency/cnpj" )
	@ResponseBody
	public Agency getAgencyByCnpj( @RequestParam( value = "cnpj", required = true ) String cnpj ) {
		return agencyService.findByCnpj( cnpj );
	}

	@GetMapping( "/agency/name" )
	public List<Agency> getAgencyByName( @RequestParam( value = "name", required = true ) String name ) throws NotFoundEntity {
		return agencyService.findAllByName( name );
	}

	@PostMapping( "/agency" )
	public ResponseEntity<Object> postAgency( @Validated @RequestBody Agency agency ) throws MandatoryField, ConstraintViolationException, BadRequestException {
		if ( StringUtils.isEmpty( agency.getPassword() ) ) {
			throw new MandatoryField( "password" );
		}
		Map<String, String> violationsMap = checkUniqueFields( agency );
		if ( !violationsMap.isEmpty() ) {
			return new ResponseEntity<Object>( converterUtils.errorReturn( "Already exists", violationsMap ), HttpStatus.BAD_REQUEST );
		}
		Agency agencySaved = agencyService.save( agency );
		return new ResponseEntity<Object>( agencySaved, HttpStatus.OK );
	}

	@PutMapping( "/agency" )
	public Agency putAgency( @Validated @RequestBody Agency agency ) throws NotFoundEntity, MandatoryField {
		return agencyService.put( agency );
	}

	@DeleteMapping( "/agency/{agencyId}" )
	public void deleteAgency( @PathVariable Long agencyId ) throws NotFoundEntity {
		agencyService.delete( agencyId );
	}

	private Map<String, String> checkUniqueFields( Agency agency ) {
		HashMap<String, String> uniqueFieldsMap = new HashMap<>();
		if ( agencyService.existsByEmail( agency.getEmail() ) || personService.existsByEmail( agency.getEmail() ) ) {
			uniqueFieldsMap.put( EMAIL, agency.getEmail() );
		}
		if ( agencyService.existsByCnpj( agency.getCnpj() ) ) {
			uniqueFieldsMap.put( CNPJ, agency.getCnpj() );
		}
		return uniqueFieldsMap;
	}

}
