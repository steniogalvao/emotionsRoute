package br.com.vsgdev.emotionsRoute.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.vsgdev.emotionsRoute.enums.RequestStatusEnum;

@Entity
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int Id;

	@ElementCollection
	private List<Person> clients = new ArrayList<>();

	@DateTimeFormat
	@NotNull
	private LocalDateTime dateTime;

	@NotNull
	private TourItem tourItem;

	@NotNull
	private RequestStatusEnum status;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public List<Person> getClients() {
		return clients;
	}

	public void setClients(List<Person> clients) {
		this.clients = clients;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public RequestStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RequestStatusEnum status) {
		this.status = status;
	}

	public TourItem getTourItem() {
		return tourItem;
	}

	public void setTourItem(TourItem tourItem) {
		this.tourItem = tourItem;
	}

	@Override
	public String toString() {
		return "Request [Id=" + Id + ", clients=" + clients + ", dateTime=" + dateTime + ", tourItem=" + tourItem
				+ ", status=" + status + "]";
	}

}
