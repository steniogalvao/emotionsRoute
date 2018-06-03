package br.com.vsgdev.emotionsRoute.model;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.vsgdev.emotionsRoute.enums.UserTypeEnum;

public abstract class User {

	@Id
	@GeneratedValue
	private int Id;

	@NotNull
	private String name;

	@NotNull
	private List<String> phones;

	@NotNull
	private String email;

	@NotNull
	@OneToOne
	private Address address;

	@NotNull
	private String password;

	@NotNull
	@Enumerated( EnumType.STRING )
	private UserTypeEnum userType;

	private double rate;

	private boolean active;

	public int getId() {
		return Id;
	}

	public void setId( int id ) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones( List<String> phones ) {
		this.phones = phones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress( Address address ) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public UserTypeEnum getUserType() {
		return userType;
	}

	public void setUserType( UserTypeEnum userType ) {
		this.userType = userType;
	}

	public double getRate() {
		return rate;
	}

	public void setRate( double rate ) {
		this.rate = rate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive( boolean active ) {
		this.active = active;
	}

}
