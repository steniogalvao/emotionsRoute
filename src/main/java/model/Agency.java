package model;

import javax.validation.constraints.NotNull;

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
