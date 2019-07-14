package br.com.vsgdev.emotionsRoute.model.vo;

import javax.validation.constraints.NotNull;

public class AgencyVO extends UserVO {

	@NotNull
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj( String cnpj ) {
		this.cnpj = cnpj;
	}

}
