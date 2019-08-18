package br.com.vsgdev.emotionsRoute.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class TransferItem extends Payable {

	/**
	 * Number of people allowed
	 */
	@NotNull
	private int capacity;

	@DateTimeFormat
	private LocalDateTime dateTime;

	@NotEmpty
	@OneToMany
	private List<User> users = new ArrayList<>();

	@NotNull
	@OneToOne
	private Transfer transfer;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity( int capacity ) {
		this.capacity = capacity;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime( LocalDateTime dateTime ) {
		this.dateTime = dateTime;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers( List<User> users ) {
		this.users = users;
	}

	public Transfer getTransfer() {
		return transfer;
	}

	public void setTransfer( Transfer transfer ) {
		this.transfer = transfer;
	}

	@Override
	public String toString() {
		return "TransferItem [capacity=" + capacity + ", dateTime=" + dateTime + ", users=" + users + ", transfer=" + transfer + "]";
	}

}
