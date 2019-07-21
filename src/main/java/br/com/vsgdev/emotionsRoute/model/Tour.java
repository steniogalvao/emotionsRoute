package br.com.vsgdev.emotionsRoute.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Tour {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE )
	private Long Id;
	@NotNull
	private String name;

	@NotNull
	private String description;

	@NotNull
	private String city;

	@ElementCollection
	private List<String> pictures;

	private double rate;

	private boolean deleted = false;

	public Long getId() {
		return Id;
	}

	public void setId( Long id ) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity( String city ) {
		this.city = city;
	}

	public List<String> getPictures() {
		return pictures;
	}

	public void setPictures( List<String> pictures ) {
		this.pictures = pictures;
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

}
