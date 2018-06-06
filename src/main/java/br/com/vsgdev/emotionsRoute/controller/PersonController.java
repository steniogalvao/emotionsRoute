package br.com.vsgdev.emotionsRoute.controller;

import java.util.Optional;

import static br.com.vsgdev.emotionsRoute.utils.StaticStrings.ID;

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
import br.com.vsgdev.emotionsRoute.model.Person;
import br.com.vsgdev.emotionsRoute.repository.PersonRepository;

@RestController
public class PersonController extends BaseController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping( "/person/{personId}" )
	public Person getPerson( @PathVariable Long personId ) throws NotFoundEntity {
		Optional<Person> response = personRepository.findById( personId );
		if ( response.isPresent() ) {
			return response.get();
		} else {
			throw new NotFoundEntity(ID, String.valueOf( personId ) );
		}
	}

	@PostMapping( "/person" )
	public Person postPerson( @Validated @RequestBody Person person ) throws MandatoryField {
		if ( person.getPassword() == null || person.getPassword().isEmpty() ) {
			throw new MandatoryField( "password" );
		}
		return personRepository.save( person );
	}

	@PutMapping( "/person" )
	public Person putPerson( @Validated @RequestBody Person person ) throws NotFoundEntity {
		if ( person.getId() == null ) {
			throw new NotFoundEntity(ID, "null" );
		}
		Optional<Person> response = personRepository.findById( person.getId() );
		person.setPassword( response.get().getPassword() );
		return personRepository.save( person );
	}

	@DeleteMapping( "/person/{personId}" )
	public void deletePerson( @PathVariable Long personId ) throws NotFoundEntity {
		Optional<Person> response = personRepository.findById( personId );
		if ( !response.isPresent() ) {
			throw new NotFoundEntity(ID, String.valueOf( personId ) );
		} else {
			Person person = response.get();
			person.setActive( false );
			personRepository.save( person );
		}
	}

}
