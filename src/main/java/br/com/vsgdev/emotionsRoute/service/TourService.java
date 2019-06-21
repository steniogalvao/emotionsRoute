package br.com.vsgdev.emotionsRoute.service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Tour;

public interface TourService {

	Tour get(Long id) throws NotFoundEntity;

	void delete(Long id) throws NotFoundEntity;

	Tour put(Tour tour) throws NotFoundEntity;

	Tour save(Tour tour);

}
