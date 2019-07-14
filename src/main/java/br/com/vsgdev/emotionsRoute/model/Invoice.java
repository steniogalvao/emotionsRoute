package br.com.vsgdev.emotionsRoute.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long Id;

	@ElementCollection
	private List<Payable> itens = new ArrayList<>();

	private BigDecimal total;

	private BigDecimal discount;

	@DateTimeFormat
	private LocalDateTime date;
	
	private boolean paid =false;
	
	private boolean deleted = false;
			
			

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public List<Payable> getItens() {
		return itens;
	}

	public void setItens(List<Payable> itens) {
		this.itens = itens;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid( boolean paid ) {
		this.paid = paid;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted( boolean deleted ) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Invoice [Id=" + Id + ", itens=" + itens + ", total=" + total + ", discount=" + discount + ", date=" + date + ", paid=" + paid + ", deleted=" + deleted + "]";
	}
	

}
