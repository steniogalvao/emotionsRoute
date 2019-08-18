package br.com.vsgdev.emotionsRoute.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class TransferItem extends Payable {

	/**
	 * Number of people allowed
	 */
	@NotNull
	private int capacity;

	@NotNull
	@OneToOne
	private Transfer transfer;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity( int capacity ) {
		this.capacity = capacity;
	}

	public Transfer getTransfer() {
		return transfer;
	}

	public void setTransfer( Transfer transfer ) {
		this.transfer = transfer;
	}

	@Override
	public String toString() {
		return "TransferItem [capacity=" + capacity + ", transfer=" + transfer + "]";
	}

}
