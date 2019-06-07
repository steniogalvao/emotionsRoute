package br.com.vsgdev.emotionsRoute.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.vsgdev.emotionsRoute.enums.TransferType;

@Entity
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int Id;

	private TransferType transferType;

	private Tour tour;

	private String origin;

	private String destiny;

	private BigDecimal value;
	/**
	 * Number of people allowed
	 */
	private int capacity;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Transfer [Id=" + Id + ", transferType=" + transferType + ", tour=" + tour + ", origin=" + origin
				+ ", destiny=" + destiny + ", value=" + value + ", capacity=" + capacity + "]";
	}

}
