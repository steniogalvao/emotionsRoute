package br.com.vsgdev.emotionsRoute.enums;

public enum PaymentMethodEnum {

	CREDIT_CARD( "Credit Card" ),
	PAYPALL( "Credit Card" ),;

	private String paymentMethod;

	PaymentMethodEnum( String paymentMethod ) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}
}
