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
	private String includedDescription;

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

	public String getIncludedDescription() {
		return includedDescription;
	}

	public void setIncludedDescription( String includeDescription ) {
		this.includedDescription = includeDescription;
	}

	@Override
	public String toString() {
		return "TourItem [tour=" + tour + ", duration=" + duration + ", includedDescription=" + includedDescription + "]";
	}

}
