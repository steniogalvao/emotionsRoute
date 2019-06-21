package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Agency;
import br.com.vsgdev.emotionsRoute.repository.AgencyRepository;
import br.com.vsgdev.emotionsRoute.service.AgencyService;

@Service
public class AgencyServiceImpl implements AgencyService {

	@Autowired
	private AgencyRepository agRep;

	@Override
	public Agency get(int id) throws NotFoundEntity {
		Optional<Agency> result = agRep.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundEntity("id", String.valueOf(id));
		}
	}

	@Override
	public void delete(int id) throws NotFoundEntity {
		agRep.delete(get(id));

	}

	@Override
	public Agency put(Agency agency) throws NotFoundEntity {
		get(agency.getId());
		return agRep.save(agency);
	}

	@Override
	public Agency save(Agency agency) {
		if (agency.getId() == 0) {
			return agRep.save(agency);
		} else {
			// may throw an exception
			return null;
		}
	}

	@Override
	public Agency findByIdAndActive(int id, boolean active) throws NotFoundEntity {
		Agency result = agRep.findByIdAndActive(id, active);
		if (result != null) {
			return result;
		} else {
			throw new NotFoundEntity("id", String.valueOf(id));
		}
	}

	@Override
	public Agency findByCnpj(String cnpj) throws NotFoundEntity {
		Agency result = agRep.findByCnpj(cnpj);
		if (result != null) {
			return result;
		} else {
			throw new NotFoundEntity("cnpj", cnpj);
		}
	}

	@Override
	public List<Agency> findAllByName(String name) {
		return agRep.findAllByNameContainingIgnoreCaseOrderByName(name);
	}

	@Override
	public boolean existsByEmail(String email) {
		return agRep.existsByEmail(email);
	}

	@Override
	public boolean existsByCnpj(String cnpj) {
		return agRep.existsByCnpj(cnpj);
	}

}
