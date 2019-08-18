package br.com.vsgdev.emotionsRoute.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class Payable {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE )
	private Long id;

	@NotNull
	private BigDecimal value;

	@NotNull
	@OneToOne( fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
	private User responsable;

	private Boolean deleted = false;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue( BigDecimal value ) {
		this.value = value;
	}

	public User getResponsable() {
		return responsable;
	}

	public void setResponsable( User responsable ) {
		this.responsable = responsable;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted( Boolean deleted ) {
		this.deleted = deleted;

	}

	@Override
	public String toString() {
		return "Payable [id=" + id + ", value=" + value + ", responsable=" + responsable + ", deleted=" + deleted + "]";
	}

}
