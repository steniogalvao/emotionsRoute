package br.com.vsgdev.emotionsRoute.service;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import br.com.vsgdev.emotionsRoute.enums.DocTypeEnum;
import br.com.vsgdev.emotionsRoute.model.Person;
import br.com.vsgdev.emotionsRoute.model.vo.PersonVO;

public interface PersonService {

	Optional<PersonVO> getVO( Long id, boolean onlyActive);

	void delete( Long id ) throws BadRequestException;

	PersonVO save( Person person );

	boolean existsByEmail( String email );

	PersonVO put( PersonVO person ) throws BadRequestException;

	boolean existsByDocNumberAndDocType( String docNumber, DocTypeEnum docType );

}
