package br.com.vsgdev.emotionsRoute.enums;

public enum UserTypeEnum {

	PERSON( "PERSON" ),
	AGENCY( "AGENCY" ),;

	private String userType;

	private UserTypeEnum( String userType ) {
		this.userType = userType;
	}

	public String getUserType() {
		return this.userType;
	}

}
