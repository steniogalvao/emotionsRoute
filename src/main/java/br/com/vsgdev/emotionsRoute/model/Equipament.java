package br.com.vsgdev.emotionsRoute.model;

import javax.persistence.Entity;

@Entity
public class Equipament extends Payable {

	private String name;

	private String description;

	private boolean rented = false;

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

	public boolean isRented() {
		return rented;
	}

	public void setRented( boolean rented ) {
		this.rented = rented;
	}

	@Override
	public String toString() {
		return "Equipament [id=" + getId() + ", name=" + name + ", description=" + description + ", rented=" + rented + "]";
	}

}
