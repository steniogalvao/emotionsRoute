package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.model.Equipament;
import br.com.vsgdev.emotionsRoute.repository.EquipamentRepository;
import br.com.vsgdev.emotionsRoute.service.EquipamentService;

@Service
public class EquipamentServiceImpl implements EquipamentService {

	@Autowired
	private EquipamentRepository eqRep;

	@Override
	public Optional<Equipament> get( Long id ) {
		return eqRep.findById( id );

	}

	@Override
	public void delete( Long id ) throws BadRequestException {
		Optional<Equipament> result = get( id );
		if ( result.isPresent() ) {
			result.get().setDeleted( true );
			eqRep.save( result.get() );
		} else {
			throw new BadRequestException();
		}

	}

	@Override
	public Equipament put( Equipament equipament ) {
		return eqRep.existsById( equipament.getId() ) ? eqRep.save( equipament ) : null;
	}

	@Override
	public Equipament save( Equipament equipament ) {
		if ( equipament.getId() == null ) {
			return eqRep.save( equipament );
		} else {
			// may throw an exception
			return null;
		}
	}

}
