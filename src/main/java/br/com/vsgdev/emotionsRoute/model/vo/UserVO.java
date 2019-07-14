package br.com.vsgdev.emotionsRoute.model.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import br.com.vsgdev.emotionsRoute.enums.UserTypeEnum;
import br.com.vsgdev.emotionsRoute.model.Address;
import br.com.vsgdev.emotionsRoute.model.User;

public abstract class UserVO {

	private Long id;

	@NotNull
	private String name;

	@NotNull
	@ElementCollection
	private List<String> phones;

	@NotNull
	@Column( unique = true )
	private String email;

	@NotNull
	private Address address;

	@NotNull
	@Enumerated( EnumType.STRING )
	private UserTypeEnum userType;

	private double rate;

	private boolean deleted = false;

	public UserVO() {}

	public UserVO( User user ) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.phones = user.getPhones();
		this.email = user.getEmail();
		this.address = user.getAddress();
		this.userType = user.getUserType();
		this.rate = user.getRate();
		this.deleted = user.isDeleted();
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted( boolean deleted ) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", phones=" + phones + ", email=" + email + ", address=" + address + ", userType=" + userType + ", rate=" + rate + ", deleted=" + deleted + "]";
	}

}
