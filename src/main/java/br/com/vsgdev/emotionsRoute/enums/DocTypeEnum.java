package br.com.vsgdev.emotionsRoute.enums;

public enum DocTypeEnum {

	RG( "RG" ),
	CPF( "CPF" ),
	PASSPORT( "Passport" ),
	CNH( "CNH" ),;

	private String docType;

	private DocTypeEnum( String docType ) {
		this.docType = docType;
	}

	public String getDocType() {
		return docType;
	}
	
	
}
