package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Equipament;
import br.com.vsgdev.emotionsRoute.repository.EquipamentRepository;
import br.com.vsgdev.emotionsRoute.service.EquipamentService;

@Service
public class EquipamentServiceImpl implements EquipamentService {

	@Autowired
	private EquipamentRepository eqRep;

	@Override
	public Equipament get(int id) throws NotFoundEntity {
		Optional<Equipament> result = eqRep.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundEntity("id", String.valueOf(id));
		}
	}

	@Override
	public void delete(int id) throws NotFoundEntity {
		eqRep.delete(get(id));

	}

	@Override
	public Equipament put(Equipament equipament) throws NotFoundEntity {
		get(equipament.getId());
		return eqRep.save(equipament);
	}

	@Override
	public Equipament save(Equipament equipament) {
		if (equipament.getId() == 0) {
			return eqRep.save(equipament);
		} else {
			// may throw an exception
			return null;
		}
	}

}
