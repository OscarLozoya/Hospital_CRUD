package com.hospitalcrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pacientes")
public class Paciente {
	
	@Id
	@Column(name="idPaciente")
	private int idPaciente;
	@Column(name="nombresP")
	private String name;
	@Column(name="apellidosP")
	private String lastName;
	
	public Paciente(){}
	
	public Paciente(int idPaciente, String name, String lastName) {
		this.idPaciente = idPaciente;
		this.name = name;
		this.lastName = lastName;
	}
	
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
