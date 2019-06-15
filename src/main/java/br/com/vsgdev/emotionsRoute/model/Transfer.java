package br.com.vsgdev.emotionsRoute.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.vsgdev.emotionsRoute.enums.TransferType;

@Entity
public class Transfer extends Payable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;

	private TransferType transferType;

	private Tour tour;

	private String origin;

	private String destiny;

	/**
	 * Number of people allowed
	 */
	private int capacity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TransferType getTransferType() {
		return transferType;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", transferType=" + transferType + ", tour=" + tour + ", origin=" + origin
				+ ", destiny=" + destiny + ", capacity=" + capacity + "]";
	}

}
