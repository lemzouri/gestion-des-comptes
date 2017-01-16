package org.glsid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length=1)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")


@JsonSubTypes({
   @Type(name="V",value=Versement.class),
   @Type(name="R",value=Retrait.class)
})

@XmlSeeAlso({Versement.class,Retrait.class})

public abstract class Operation implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numeroOperation;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name="CODE_EMP")
	private Employee employee;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	public Long getNumeroOperation() {
		return numeroOperation;
	}
	public void setNumeroOperation(Long numeroOperation) {
		this.numeroOperation = numeroOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	@JsonIgnore
	@XmlTransient
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	@JsonIgnore
	@XmlTransient
	public Employee getEmployee() {
		return employee;
	}
	@JsonSetter
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}