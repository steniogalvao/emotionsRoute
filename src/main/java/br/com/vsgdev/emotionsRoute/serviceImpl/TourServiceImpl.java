package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Tour;
import br.com.vsgdev.emotionsRoute.repository.TourRepository;
import br.com.vsgdev.emotionsRoute.service.TourService;

@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourRepository tourRep;

	@Override
	public Tour get(Long id) throws NotFoundEntity {
		Optional<Tour> result = tourRep.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundEntity("id", String.valueOf(id));
		}
	}

	@Override
	public void delete(Long id) throws NotFoundEntity {
		tourRep.delete(get(id));

	}

	@Override
	public Tour put(Tour tour) throws NotFoundEntity {
		get(tour.getId());
		return tourRep.save(tour);
	}

	@Override
	public Tour save(Tour tour) {
		if (tour.getId() == 0) {
			return tourRep.save(tour);
		} else {
			// may throw an exception
			return null;
		}
	}

}
