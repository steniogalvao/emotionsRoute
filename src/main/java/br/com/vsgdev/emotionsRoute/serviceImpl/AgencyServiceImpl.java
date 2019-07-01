package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.vsgdev.emotionsRoute.exception.MandatoryField;
import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Agency;
import br.com.vsgdev.emotionsRoute.repository.AgencyRepository;
import br.com.vsgdev.emotionsRoute.service.AddressService;
import br.com.vsgdev.emotionsRoute.service.AgencyService;

@Service
public class AgencyServiceImpl implements AgencyService {

	@Autowired
	private AgencyRepository agRep;
	@Autowired
	private AddressService addressService;

	@Override
	public Optional<Agency> get( Long id ) {
		return agRep.findById( id );
	}

	@Override
	public void delete( Long id ) throws NotFoundEntity {
		Optional<Agency> agencyResult = get( id );
		if ( agencyResult.isPresent() ) {
			agencyResult.get().setActive( false );
			save( agencyResult.get() );
		}

	}

	/*
	 * TODO: solve password problem
	 * 
	 */
	@Transactional( rollbackFor = { Exception.class } )
	@Override
	public Agency put( Agency agency ) throws BadRequestException, MandatoryField {
		if ( StringUtils.isEmpty( agency.getId() ) || !agRep.existsById( agency.getId() ) ) {
			throw new BadRequestException();
		}
		updateAgencyAndAddress( agency );
		return agency;
	}

	void updateAgencyAndAddress( Agency agency ) {
		int result = agRep.updateAllButPassword( agency.getId(), agency.getCnpj(), agency.getEmail(), agency.getName(), agency.getRate(), agency.getUserType() );
		addressService.put( agency.getAddress() );
		if ( result == 0 ) {
			throw new BadRequestException();
		}
	}

	@Override
	public Agency save( Agency agency ) throws BadRequestException {
		if ( agency.getId() != null ) {
			return agRep.save( agency );
		} else {
			throw new BadRequestException();
		}
	}

	@Override
	public Agency findByIdAndActive( Long id, boolean active ) {
		return agRep.findByIdAndActive( id, active );
	}

	@Override
	public Agency findByCnpj( String cnpj ) {
		return agRep.findByCnpj( cnpj );
	}

	@Override
	public List<Agency> findAllByName( String name ) {
		return agRep.findAllByNameContainingIgnoreCaseOrderByName( name );
	}

	@Override
	public boolean existsByEmail( String email ) {
		return agRep.existsByEmail( email );
	}

	@Override
	public boolean existsByCnpj( String cnpj ) {
		return agRep.existsByCnpj( cnpj );
	}

}
