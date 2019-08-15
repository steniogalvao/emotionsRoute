package br.com.vsgdev.emotionsRoute.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.vsgdev.emotionsRoute.enums.DocTypeEnum;
import br.com.vsgdev.emotionsRoute.enums.UserRoleEnum;
import br.com.vsgdev.emotionsRoute.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	Optional<Person> findByIdAndDeleted( Long id, boolean deleted );

	Optional<Person> findById( Long id );

	boolean existsByEmail( String email );

	boolean existsByDocNumberAndDocType( String docNumber, DocTypeEnum docType );

	@Modifying
	@Query( "update Person p set p.docType=:docType, p.docNumber=:docNumber, p.email=:email, p.name=:name, p.rate=:rate, p.userType=:userType where p.id = :id" )
	int updateAllButPassword( @Param( "id" ) Long id, @Param( "docType" ) DocTypeEnum docType, @Param( "docNumber" ) String docNumber, @Param( "email" ) String email, @Param( "name" ) String name, @Param( "rate" ) Double rate, @Param( "userType" ) UserRoleEnum userType );

	@Modifying
	@Query( "update Person p set p.password=:password where p.id = :id" )
	Person updatePassword( @Param( "id" ) Long id, @Param( "password" ) String password );

}