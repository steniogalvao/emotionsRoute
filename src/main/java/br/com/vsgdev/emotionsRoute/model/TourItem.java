package br.com.vsgdev.emotionsRoute.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class TourItem {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@OneToOne
	private Tour tour;

	@NotNull
	private BigDecimal price;

	@NotNull
	private String duration;

	@NotNull
	private String includeDescription;

	@NotNull
	@OneToOne
	private User responsable;

	private boolean active = true;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour( Tour tour ) {
		this.tour = tour;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice( BigDecimal price ) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration( String duration ) {
		this.duration = duration;
	}

	public String getIncludeDescription() {
		return includeDescription;
	}

	public void setIncludeDescription( String includeDescription ) {
		this.includeDescription = includeDescription;
	}

	public User getResponsable() {
		return responsable;
	}

	public void setResponsable( User responsable ) {
		this.responsable = responsable;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive( boolean active ) {
		this.active = active;
	}

}
