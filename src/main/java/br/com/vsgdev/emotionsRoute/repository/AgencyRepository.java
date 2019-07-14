package br.com.vsgdev.emotionsRoute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.vsgdev.emotionsRoute.enums.UserTypeEnum;
import br.com.vsgdev.emotionsRoute.model.Agency;

@Repository
public interface AgencyRepository extends CrudRepository<Agency, Long> {

	Agency findByIdAndDeleted( Long id, boolean deleted);

	Agency findByCnpj( String cnpj );

	List<Agency> findAllByNameContainingIgnoreCaseOrderByName( String name );

	boolean existsByEmail( String email );

	boolean existsByCnpj( String cnpj );

	@Modifying
	@Query( "update Agency a set a.cnpj=:cnpj, a.email=:email, a.name=:name, a.rate=:rate, a.userType=:userType where a.id = :id" )
	int updateAllButPassword( @Param( "id" ) Long id, @Param( "cnpj" ) String cnpj, @Param( "email" ) String email, @Param( "name" ) String name, @Param( "rate" ) Double rate, @Param( "userType" ) UserTypeEnum userType );

	@Modifying
	@Query( "update Agency a set a.password=:password where a.id = :id" )
	Agency updatePassword( @Param( "id" ) Long id, @Param( "password" ) String password );

}
