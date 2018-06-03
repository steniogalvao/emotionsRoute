package enums;

public enum UserTypeEnum {

	ADMIN( "ADMIN" ),
	USER( "USER" ),
	PARTNER( "PARTNER" ),;

	private String userType;

	private UserTypeEnum( String userType ) {
		this.userType = userType;
	}

	public String getUserType() {
		return this.userType;
	}

}
