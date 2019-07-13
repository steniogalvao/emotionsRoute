package br.com.vsgdev.emotionsRoute.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class Payable {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE )
	private Long id;

	private BigDecimal value;

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

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted( Boolean deleted ) {
		this.deleted = deleted;
	}

}
