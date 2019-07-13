package br.com.vsgdev.emotionsRoute.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.BadRequestException;

import br.com.vsgdev.emotionsRoute.exception.MandatoryField;
import br.com.vsgdev.emotionsRoute.model.Agency;

public interface AgencyService {

	Optional<Agency> get( Long id );

	void delete( Long id );

	Agency put( Agency agency ) throws MandatoryField;

	Agency save( Agency agency ) throws BadRequestException;

	Agency findByIdAndActive( Long id, boolean active );

	Agency findByCnpj( String cnpj );

	List<Agency> findAllByName( String name );

	boolean existsByEmail( String email );

	boolean existsByCnpj( String cnpj );

}
