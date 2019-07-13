package br.com.vsgdev.emotionsRoute.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Equipament extends Payable {

	@NotNull
	private String name;

	@NotNull
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
