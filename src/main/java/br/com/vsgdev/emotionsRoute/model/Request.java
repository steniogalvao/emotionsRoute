package br.com.vsgdev.emotionsRoute.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.vsgdev.emotionsRoute.enums.RequestStatusEnum;

@Entity
public class Request {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE )
	private Long Id;

	@ElementCollection
	private List<Person> clients = new ArrayList<>();

	private int adults;

	private int children;

	@DateTimeFormat
	@NotNull
	private LocalDateTime dateTime;

	@OneToOne
	@NotNull
	private Payable item;

	@Enumerated( EnumType.STRING )
	@NotNull
	private RequestStatusEnum status;

	private boolean deleted = false;

	public Long getId() {
		return Id;
	}

	public void setId( Long id ) {
		Id = id;
	}

	public List<Person> getClients() {
		return clients;
	}

	public void setClients( List<Person> clients ) {
		this.clients = clients;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime( LocalDateTime dateTime ) {
		this.dateTime = dateTime;
	}

	public RequestStatusEnum getStatus() {
		return status;
	}

	public void setStatus( RequestStatusEnum status ) {
		this.status = status;
	}

	public Payable getItem() {
		return item;
	}

	public void setItem( Payable item ) {
		this.item = item;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted( boolean deleted ) {
		this.deleted = deleted;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults( int adults ) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren( int children ) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Request [Id=" + Id + ", clients=" + clients + ", adults=" + adults + ", children=" + children + ", dateTime=" + dateTime + ", item=" + item + ", status=" + status + ", deleted=" + deleted + "]";
	}

}
