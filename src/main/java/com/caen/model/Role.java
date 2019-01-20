package com.caen.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idRole;
	
	@Column(name="nombre")
	String nombre;
	
	@Column(name="descripcion")
	String descripcion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permiso", joinColumns
            = @JoinColumn(name = "role_id",
            referencedColumnName = "idRole"),
            inverseJoinColumns = @JoinColumn(name = "permiso_id",
                    referencedColumnName = "idPermiso"))
	List<Permiso>permisos;
	
    @OneToMany(mappedBy="role",cascade= {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.REMOVE},fetch=FetchType.LAZY,orphanRemoval=true)
    List<Usuario>usuarios;
    
    
    
    
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}
	
	
}
