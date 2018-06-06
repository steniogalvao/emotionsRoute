package br.com.vsgdev.emotionsRoute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vsgdev.emotionsRoute.model.Agency;
import br.com.vsgdev.emotionsRoute.model.Person;

@Repository
public interface AgencyRepository extends CrudRepository<Agency, Long>{

	Person findByIdAndActive( Long id, boolean active );
}
