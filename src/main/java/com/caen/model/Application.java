package com.caen.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="application")
@Entity
public class Application {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name="nombre")
	public String nombre;
	
	@Column(name="comentario")
	public String comentario;

	@Column(name="ruta")
	public String ruta;
	
	@JsonIgnore
	@OneToMany(mappedBy="application",cascade= {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.REMOVE},fetch=FetchType.LAZY,orphanRemoval=true)
	public List<Permiso> permisos;
	
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
}
