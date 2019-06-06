package br.com.vsgdev.emotionsRoute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vsgdev.emotionsRoute.enums.DocTypeEnum;
import br.com.vsgdev.emotionsRoute.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	Person findByIdAndActive( Long id, boolean active );

	boolean existsByEmail( String email );

	boolean existsByDocNumberAndDocType( String docNumber, DocTypeEnum docType );

}