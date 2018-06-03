package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class TourItem {

	@Id
	@GeneratedValue
	private int Id;

	@NotNull
	@OneToOne
	private Tour tour;

	@NotNull
	private BigDecimal price;

	@NotNull
	private LocalDateTime duration;

	@NotNull
	private String includeDescription;

	@NotNull
	@OneToOne
	private User responsable;

	public int getId() {
		return Id;
	}

	public void setId( int id ) {
		Id = id;
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

	public LocalDateTime getDuration() {
		return duration;
	}

	public void setDuration( LocalDateTime duration ) {
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

}
