package org.glsid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public class Employee implements Serializable {
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codemEploye;
	private String nomEmployee;
	@ManyToOne
	@JoinColumn(name="code_emp_sup")
	private Employee employeSup;
	@ManyToMany
	@JoinTable(name="EMP_GR")
	private Collection<Groupe> groupes;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String nomEmployee) {
		super();
		this.nomEmployee = nomEmployee;
	}
	public Long getCodemEploye() {
		return codemEploye;
	}
	public void setCodemEploye(Long codemEploye) {
		this.codemEploye = codemEploye;
	}
	public String getNomEmployee() {
		return nomEmployee;
	}
	public void setNomEmployee(String nomEmployee) {
		this.nomEmployee = nomEmployee;
	}
	@JsonIgnore
	public Employee getEmployeSup() {
		return employeSup;
	}
	@JsonSetter
	public void setEmployeSup(Employee employeSup) {
		this.employeSup = employeSup;
	}
	@JsonIgnore
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	

}
