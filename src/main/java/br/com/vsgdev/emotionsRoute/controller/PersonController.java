package br.com.vsgdev.emotionsRoute.controller;

import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.DOCUMENT;
import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.EMAIL;
import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.ID;

import java.util.HashMap;
import java.util.Map;
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

import br.com.vsgdev.emotionsRoute.exception.MandatoryField;
import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Person;
import br.com.vsgdev.emotionsRoute.repository.AgencyRepository;
import br.com.vsgdev.emotionsRoute.repository.PersonRepository;
import br.com.vsgdev.emotionsRoute.utils.ConverterUtils;

@RestController
public class PersonController extends BaseController {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AgencyRepository agencyRepository;
	@Autowired
	private ConverterUtils converterUtils;

	@GetMapping( "/person/{personId}" )
	public Person getPerson( @PathVariable Long personId ) throws NotFoundEntity {
		Optional<Person> response = personRepository.findById( personId );
		if ( response.isPresent() ) {
			return response.get();
		} else {
			throw new NotFoundEntity( ID, String.valueOf( personId ) );
		}
	}

	@PostMapping( "/person" )
	public ResponseEntity<Object> postPerson( @Validated @RequestBody Person person ) throws MandatoryField {
		if ( person.getPassword() == null || person.getPassword().isEmpty() ) {
			throw new MandatoryField( "password" );
		}
		Map<String, String> violationsMap = checkUniqueFields( person );
		if ( !violationsMap.isEmpty() ) {
			return new ResponseEntity<Object>( converterUtils.errorReturn( "Already exists", violationsMap ), HttpStatus.BAD_REQUEST );
		}
		return new ResponseEntity<Object>( personRepository.save( person ), HttpStatus.OK );
	}

	@PutMapping( "/person" )
	public Person putPerson( @Validated @RequestBody Person person ) throws NotFoundEntity {
		if ( person.getId() == null ) {
			throw new NotFoundEntity( ID, String.valueOf( person.getId()));
		}
		Optional<Person> response = personRepository.findById( person.getId() );
		person.setPassword( response.get().getPassword() );
		return personRepository.save( person );
	}

	@DeleteMapping( "/person/{personId}" )
	public void deletePerson( @PathVariable Long personId ) throws NotFoundEntity {
		Optional<Person> response = personRepository.findById( personId );
		if ( !response.isPresent() ) {
			throw new NotFoundEntity( ID, String.valueOf( personId ) );
		} else {
			Person person = response.get();
			person.setActive( false );
			personRepository.save( person );
		}
	}

	private Map<String, String> checkUniqueFields( Person person ) {
		HashMap<String, String> uniqueFieldsMap = new HashMap<>();
		if ( personRepository.existsByEmail( person.getEmail() ) || agencyRepository.existsByEmail( person.getEmail() ) ) {
			uniqueFieldsMap.put( EMAIL, person.getEmail() );
		}
		if ( personRepository.existsByDocNumberAndDocType( person.getDocNumber(), person.getDocType() ) ) {
			uniqueFieldsMap.put( DOCUMENT, person.getDocType().name() + "_" + person.getDocNumber() );
		}
		return uniqueFieldsMap;
	}

}
