package br.com.vsgdev.emotionsRoute.model;

public class ErrorResponse {
	private String message;
	private String field;

	public ErrorResponse( String message, String field ) {
		super();
		this.message = message;
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage( String message ) {
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField( String field ) {
		this.field = field;
	}

}
