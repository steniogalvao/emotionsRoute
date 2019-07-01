package br.com.vsgdev.emotionsRoute.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import br.com.vsgdev.emotionsRoute.enums.TransferType;

@Entity
public class Transfer extends Payable {

	@Enumerated( EnumType.STRING )
	private TransferType transferType;

	@OneToOne
	private Tour tour;

	@NotEmpty
	private String origin;

	@NotEmpty
	private String destiny;

	/**
	 * Number of people allowed
	 */
	private int capacity;

	public TransferType getTransferType() {
		return transferType;
	}

	public void setTransferType( TransferType transferType ) {
		this.transferType = transferType;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour( Tour tour ) {
		this.tour = tour;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin( String origin ) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny( String destiny ) {
		this.destiny = destiny;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity( int capacity ) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Transfer [id=" + getId() + ", transferType=" + transferType + ", tour=" + tour + ", origin=" + origin + ", destiny=" + destiny + ", capacity=" + capacity + "]";
	}

}
