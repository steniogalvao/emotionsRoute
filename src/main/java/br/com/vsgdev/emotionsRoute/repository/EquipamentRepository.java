package br.com.vsgdev.emotionsRoute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vsgdev.emotionsRoute.model.Equipament;

@Repository
public interface EquipamentRepository extends CrudRepository<Equipament, Integer>{

}
