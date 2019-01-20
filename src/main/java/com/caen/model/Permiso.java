package com.caen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name="permiso")
@Entity
public class Permiso {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idPermiso;
	
	
	//Cambios
	@JoinColumn(name="id_app",nullable=true)
	@ManyToOne(fetch=FetchType.EAGER)
	private Application application;
	
	
	@Column(name="nombre_permiso")
	 private String nombre;
	
	

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
