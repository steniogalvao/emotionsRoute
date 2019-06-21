package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.TourItem;
import br.com.vsgdev.emotionsRoute.repository.TourItemRepository;
import br.com.vsgdev.emotionsRoute.service.TourItemService;

@Service
public class TourItemServiceImpl implements TourItemService {

	@Autowired
	private TourItemRepository tourItemRep;

	@Override
	public TourItem get(Long id) throws NotFoundEntity {
		Optional<TourItem> result = tourItemRep.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundEntity("id", String.valueOf(id));
		}
	}

	@Override
	public void delete(Long id) throws NotFoundEntity {
		tourItemRep.delete(get(id));

	}

	@Override
	public TourItem put(TourItem tourItem) throws NotFoundEntity {
		get(tourItem.getId());
		return tourItemRep.save(tourItem);
	}

	@Override
	public TourItem save(TourItem tourItem) {
		if (tourItem.getId() == 0) {
			return tourItemRep.save(tourItem);
		} else {
			// may throw an exception
			return null;
		}
	}

}
