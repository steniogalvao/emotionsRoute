package br.com.vsgdev.emotionsRoute.controller;

import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.DOCUMENT;
import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.EMAIL;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.exception.MandatoryField;
import br.com.vsgdev.emotionsRoute.model.Person;
import br.com.vsgdev.emotionsRoute.model.vo.PersonVO;
import br.com.vsgdev.emotionsRoute.service.AgencyService;
import br.com.vsgdev.emotionsRoute.service.PersonService;
import br.com.vsgdev.emotionsRoute.utils.ConverterUtils;

@RestController
public class PersonController extends BaseController {

	@Autowired
	private PersonService personService;
	@Autowired
	private AgencyService agencyService;
	@Autowired
	private ConverterUtils converterUtils;

	@GetMapping( "/person/{id}" )
	public PersonVO getPerson( @PathVariable( required = true ) Long id, @RequestAttribute(required = false) boolean onlyActive ) {
		Optional<PersonVO> response = personService.getVO( id, onlyActive );
		return response.isPresent() ? response.get() : null;
	}

	@PostMapping( "/person" )
	public ResponseEntity<Object> postPerson( @RequestBody @Validated Person person ) throws MandatoryField {
		if ( person.getPassword() == null || person.getPassword().isEmpty() ) {
			throw new MandatoryField( "password" );
		}
		Map<String, String> violationsMap = checkUniqueFields( person );
		if ( !violationsMap.isEmpty() ) {
			return new ResponseEntity<Object>( converterUtils.errorReturn( "Already exists", violationsMap ), HttpStatus.BAD_REQUEST );
		}
		return new ResponseEntity<Object>( personService.save( person ), HttpStatus.OK );
	}

	@PutMapping( "/person" )
	public PersonVO putPerson( @RequestBody @Validated PersonVO person ) throws BadRequestException {
		return personService.put( person );
	}

	@DeleteMapping( "/person/{id}" )
	public void deletePerson( @PathVariable( required = true ) Long id ) throws BadRequestException {
		personService.delete( id );
	}

	private Map<String, String> checkUniqueFields( Person person ) {
		HashMap<String, String> uniqueFieldsMap = new HashMap<>();
		if ( personService.existsByEmail( person.getEmail() ) || agencyService.existsByEmail( person.getEmail() ) ) {
			uniqueFieldsMap.put( EMAIL, person.getEmail() );
		}
		if ( personService.existsByDocNumberAndDocType( person.getDocNumber(), person.getDocType() ) ) {
			uniqueFieldsMap.put( DOCUMENT, person.getDocType().name() + "_" + person.getDocNumber() );
		}
		return uniqueFieldsMap;
	}

}
