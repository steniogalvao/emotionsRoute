package br.com.vsgdev.emotionsRoute.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Agency extends User {

	@NotNull
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj( String cnpj ) {
		this.cnpj = cnpj;
	}

}
