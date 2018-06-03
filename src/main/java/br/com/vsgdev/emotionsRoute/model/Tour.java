package br.com.vsgdev.emotionsRoute.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Tour {

	@Id
	@GeneratedValue
	private int Id;
	@NotNull
	private String name;

	@NotNull
	private String description;

	@NotNull
	private String city;

	private List<String> pictures;

	private double rate;

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

}
