package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Address;
import br.com.vsgdev.emotionsRoute.repository.AddressRepository;
import br.com.vsgdev.emotionsRoute.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addRep;

	@Override
	public Address get(int id) throws NotFoundEntity {
		Optional<Address> result = addRep.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundEntity("id", String.valueOf(id));
		}
	}

	@Override
	public void delete(int id) throws NotFoundEntity {
		addRep.delete(get(id));

	}

	@Override
	public Address put(Address address) throws NotFoundEntity {
		get(address.getId());
		return addRep.save(address);
	}

	@Override
	public Address save(Address address) {
		if (address.getId() == 0) {
			return addRep.save(address);
		} else {
			// may throw an exception
			return null;
		}
	}

}
