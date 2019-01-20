package com.caen.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="usuario")
	public class Usuario implements UserDetails{
	@Id
	private  int idUsuario;
	
	@Column(name="username",nullable=false,unique=true)
	private  String username;
	
	@Column(name="password",nullable=false)
	private  String password;
	
	@JoinColumn(name="id_rol",nullable=false)
	@ManyToOne(fetch=FetchType.EAGER)
	private  Role role;
	
	@Column(name="estado",nullable=false)
	private boolean enabled;

	
	
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
        role.getPermisos().forEach(p -> {
            authorities.add(new SimpleGrantedAuthority(p.getNombre()+'_'+p.getApplication().getNombre()));
        });
		return authorities;
	}

	
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	 
	
	 public List<Application>getApps() {
		 List<Application> paises = new ArrayList<>();
	        role.getPermisos().forEach(p -> {
	        	p.getApplication();
	        });
	return paises;
	 }
	 
}
