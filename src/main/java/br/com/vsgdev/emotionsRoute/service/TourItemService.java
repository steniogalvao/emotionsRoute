package br.com.vsgdev.emotionsRoute.service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.TourItem;

public interface TourItemService {

	TourItem get(Long id) throws NotFoundEntity;

	void delete(Long id) throws NotFoundEntity;

	TourItem put(TourItem tourItem) throws NotFoundEntity;

	TourItem save(TourItem tourItem);

}
