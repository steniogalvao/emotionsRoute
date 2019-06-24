package br.com.vsgdev.emotionsRoute.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipament extends Payable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;

	private String name;

	private String description;

	private boolean rented = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	@Override
	public String toString() {
		return "Equipament [id=" + id + ", name=" + name + ", description=" + description + ", rented=" + rented + "]";
	}

}
