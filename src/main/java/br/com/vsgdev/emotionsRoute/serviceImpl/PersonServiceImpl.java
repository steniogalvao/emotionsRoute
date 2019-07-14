package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vsgdev.emotionsRoute.enums.DocTypeEnum;
import br.com.vsgdev.emotionsRoute.model.Person;
import br.com.vsgdev.emotionsRoute.model.vo.PersonVO;
import br.com.vsgdev.emotionsRoute.repository.PersonRepository;
import br.com.vsgdev.emotionsRoute.service.AddressService;
import br.com.vsgdev.emotionsRoute.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository peRep;
	@Autowired
	private AddressService adService;

	@Override
	public Optional<PersonVO> getVO( Long id, boolean onlyActive ) {
		Optional<Person> result = onlyActive ? peRep.findByIdAndDeleted( id, false ) : peRep.findById( id );
		if ( result.isPresent() ) {
			return Optional.of( new PersonVO( result.get() ) );
		}
		return Optional.empty();
	}

	@Override
	public void delete( Long id ) throws BadRequestException {
		Optional<Person> result = peRep.findById( id );
		if ( result.isPresent() ) {
			result.get().setDeleted( true );
			peRep.save( result.get() );
		} else {
			throw new BadRequestException();
		}

	}

	@Transactional( rollbackFor = { Exception.class } )
	@Override
	public PersonVO put( PersonVO person ) throws BadRequestException {
		if ( person.getId() != null && peRep.existsById( person.getId() ) ) {
			int result = peRep.updateAllButPassword( person.getId(), person.getDocType(), person.getDocNumber(), person.getEmail(), person.getName(), person.getRate(), person.getUserType() );
			adService.put( person.getAddress() );
			if ( result == 0 ) {
				throw new BadRequestException();
			}
			return person;
		} else {
			throw new BadRequestException();
		}
	}

	@Override
	public PersonVO save( Person person ) {
		if ( person.getId() == null ) {
			return new PersonVO( peRep.save( person ) );
		} else {
			// may throw an exception
			return null;
		}
	}

	@Override
	public boolean existsByEmail( String email ) {
		return peRep.existsByEmail( email );
	}

	@Override
	public boolean existsByDocNumberAndDocType( String docNumber, DocTypeEnum docType ) {
		return peRep.existsByDocNumberAndDocType( docNumber, docType );
	}

}
