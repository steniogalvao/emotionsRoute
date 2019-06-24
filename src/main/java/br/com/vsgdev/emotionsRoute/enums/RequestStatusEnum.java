package br.com.vsgdev.emotionsRoute.enums;

/**
 *
 * ACCEPTED = the user accepted the request
 * 
 * REJECTED = User rejected the request
 * 
 * NO_RESPONSE = User didnt answer
 * 
 * CANCELED = User canceled the request after accept
 * 
 * EXPIRED = no answer after the preset time
 * 
 **/
public enum RequestStatusEnum {

	ACCEPTED, REJECTED, NORESPONSE, CANCELED, EXPIRED;

}
