package br.com.vsgdev.emotionsRoute.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vsgdev.emotionsRoute.model.Agency;

@Repository
public interface AgencyRepository extends CrudRepository<Agency, Long> {

	Agency findByIdAndActive( Long id, boolean active );

	Agency findByCnpj( String cnpj );

	List<Agency> findAllByNameContainingIgnoreCaseOrderByName( String name );
}
