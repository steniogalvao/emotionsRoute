package br.com.vsgdev.emotionsRoute.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import br.com.vsgdev.emotionsRoute.enums.DocTypeEnum;

@Table( uniqueConstraints = @UniqueConstraint( columnNames = { "docType", "docNumber" } ) )
@Entity
public class Person extends User {

	@NotNull
	@Enumerated( EnumType.STRING )
	private DocTypeEnum docType;

	@NotNull
	private String docNumber;

	public DocTypeEnum getDocType() {
		return docType;
	}

	public void setDocType( DocTypeEnum docType ) {
		this.docType = docType;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber( String docNumber ) {
		this.docNumber = docNumber;
	}

}
