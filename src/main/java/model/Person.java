package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import enums.DocTypeEnum;

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
