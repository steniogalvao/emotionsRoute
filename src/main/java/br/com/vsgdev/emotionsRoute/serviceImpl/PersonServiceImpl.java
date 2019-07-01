package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Person;
import br.com.vsgdev.emotionsRoute.repository.PersonRepository;
import br.com.vsgdev.emotionsRoute.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository peRep;

	@Override
	public Person get(Long id) throws NotFoundEntity {
		Optional<Person> result = peRep.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundEntity("id", String.valueOf(id));
		}
	}

	@Override
	public void delete(Long id) throws NotFoundEntity {
		peRep.delete(get(id));

	}

	@Override
	public Person put(Person person) throws NotFoundEntity {
		get(person.getId());
		return peRep.save(person);
	}

	@Override
	public Person save(Person person) {
		if (person.getId() == 0) {
			return peRep.save(person);
		} else {
			// may throw an exception
			return null;
		}
	}

	@Override
	public boolean existsByEmail(String email) {
		return peRep.existsByEmail(email);
	}

}
