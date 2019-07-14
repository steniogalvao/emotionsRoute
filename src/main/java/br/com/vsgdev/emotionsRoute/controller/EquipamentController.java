package br.com.vsgdev.emotionsRoute.controller;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.emotionsRoute.model.Equipament;
import br.com.vsgdev.emotionsRoute.service.EquipamentService;

@RestController
public class EquipamentController extends BaseController {

	@Autowired
	private EquipamentService eqService;

	@GetMapping( value = "/equipament/{id}" )
	public Equipament getEquipamentById( @PathVariable Long id ) {
		Optional<Equipament> eq = eqService.get( id );
		return eq.isPresent() ? eq.get() : null;
	}

	@PutMapping( value = "/equipament" )
	public Equipament putEquipament( @RequestBody @Validated Equipament equipament ) {
		return eqService.put( equipament );

	}

	@DeleteMapping( value = "/equipament/{id}" )
	@ResponseStatus( HttpStatus.OK )
	public void deleteEquipament( @PathVariable Long id ) throws BadRequestException {
		eqService.delete( id );
	}

	@PostMapping( value = "/equipament" )
	public Equipament postEquipament( @RequestBody @Validated Equipament equipament ) {
		return eqService.save( equipament );
	}

}
