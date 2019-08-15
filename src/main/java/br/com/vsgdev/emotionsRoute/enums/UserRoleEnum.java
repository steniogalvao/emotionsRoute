package br.com.vsgdev.emotionsRoute.enums;

public enum UserRoleEnum {

	ADMIN( "ADMIN" ),
	USER( "USER" ),
	EPLOYEE( "EMPLOYEE" ),
	PARTNER( "PARTNER" ),;

	private String userRole;

	private UserRoleEnum( String userRole ) {
		this.userRole = userRole;
	}

	public String getUserRole() {
		return this.userRole;
	}

}
