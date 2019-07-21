package br.com.vsgdev.emotionsRoute.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.vsgdev.emotionsRoute.enums.UserTypeEnum;
import br.com.vsgdev.emotionsRoute.model.vo.UserVO;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class User {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE)
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
	@OneToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	private Address address;

	@JsonProperty( access = Access.WRITE_ONLY )
	private String password;

	@NotNull
	@Enumerated( EnumType.STRING )
	@Column( name = "userType" )
	private UserTypeEnum userType;

	private double rate;

	private boolean deleted = false;

	public User() {}

	public User( UserVO userVO ) {
		super();
		this.id = userVO.getId();
		this.name = userVO.getName();
		this.phones = userVO.getPhones();
		this.email = userVO.getEmail();
		this.address = userVO.getAddress();
		this.userType = userVO.getUserType();
		this.rate = userVO.getRate();
		this.deleted = userVO.isDeleted();
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted( boolean deleted ) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phones=" + phones + ", email=" + email + ", address=" + address + ", password=" + password + ", userType=" + userType + ", rate=" + rate + ", deleted=" + deleted + "]";
	}

}
