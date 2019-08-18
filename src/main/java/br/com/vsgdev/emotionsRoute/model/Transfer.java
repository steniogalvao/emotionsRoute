package br.com.vsgdev.emotionsRoute.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import br.com.vsgdev.emotionsRoute.enums.TransferType;

@Entity
public class Transfer {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE )
	private Long id;

	@Enumerated( EnumType.STRING )
	private TransferType transferType;

	@OneToOne
	private Tour tour;

	@NotEmpty
	private String origin;

	@NotEmpty
	private String destiny;

	private boolean deleted;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted( boolean deleted ) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", transferType=" + transferType + ", tour=" + tour + ", origin=" + origin + ", destiny=" + destiny + ", deleted=" + deleted + "]";
	}

}
