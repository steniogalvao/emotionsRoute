package br.com.vsgdev.emotionsRoute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vsgdev.emotionsRoute.model.Person;
import br.com.vsgdev.emotionsRoute.model.TourItem;

@Repository
public interface TourItemRepository extends CrudRepository<TourItem, Long> {

}
