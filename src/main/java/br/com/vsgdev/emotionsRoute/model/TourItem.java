package br.com.vsgdev.emotionsRoute.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class TourItem extends Payable {

	@NotNull
	@OneToOne
	private Tour tour;

	@NotNull
	private String duration;

	@NotNull
	private String includeDescription;

	@NotNull
	@OneToOne
	private User responsable;

	private boolean active = true;

	public Tour getTour() {
		return tour;
	}

	public void setTour( Tour tour ) {
		this.tour = tour;
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

	@Override
	public String toString() {
		return "TourItem [id=" + getId() + ", tour=" + tour + ", duration=" + duration + ", includeDescription=" + includeDescription + ", responsable=" + responsable + ", active=" + active + "]";
	}

}
