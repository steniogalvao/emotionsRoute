package br.com.vsgdev.emotionsRoute.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.vsgdev.emotionsRoute.enums.PaymentMethodEnum;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long Id;
	
	private LocalDateTime purchaseDate;

	@NotNull
	private LocalDateTime tourDate;

	@OneToOne
	private TourItem tourItem;

	@NotNull
	private int adults;

	@NotNull
	private int childrens;

	@OneToOne
	private Person buyer;

	@NotNull
	private PaymentMethodEnum paymentMethod;

	private boolean canceled = false;

	public Long getId() {
		return Id;
	}

	public void setId( Long id ) {
		Id = id;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate( LocalDateTime purchaseDate ) {
		this.purchaseDate = purchaseDate;
	}

	public LocalDateTime getTourDate() {
		return tourDate;
	}

	public void setTourDate( LocalDateTime tourDate ) {
		this.tourDate = tourDate;
	}

	public TourItem getTourItem() {
		return tourItem;
	}

	public void setTourItem( TourItem tourItem ) {
		this.tourItem = tourItem;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults( int adults ) {
		this.adults = adults;
	}

	public int getChildrens() {
		return childrens;
	}

	public void setChildrens( int childrens ) {
		this.childrens = childrens;
	}

	public Person getBuyer() {
		return buyer;
	}

	public void setBuyer( Person buyer ) {
		this.buyer = buyer;
	}

	public PaymentMethodEnum getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod( PaymentMethodEnum paymentMethod ) {
		this.paymentMethod = paymentMethod;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled( boolean canceled ) {
		this.canceled = canceled;
	}

}
