package br.com.vsgdev.emotionsRoute.enums;

public enum TransferType {

	CITY("City"), TOUR("Tour"),;

	private String transferType;

	TransferType(String TransferType) {
		this.transferType = TransferType;
	}

	public String getTransferType() {
		return this.transferType;
	}

}
