package br.com.vsgdev.emotionsRoute.model.vo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import br.com.vsgdev.emotionsRoute.enums.DocTypeEnum;
import br.com.vsgdev.emotionsRoute.model.Person;

public class PersonVO extends UserVO {

	@NotNull
	@Enumerated( EnumType.STRING )
	private DocTypeEnum docType;

	@NotNull
	private String docNumber;

	public PersonVO() {}

	public PersonVO( Person person ) {
		super( person );
		this.docType = person.getDocType();
		this.docNumber = person.getDocNumber();
	}

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
