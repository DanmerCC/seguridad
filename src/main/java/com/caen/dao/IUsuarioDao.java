package com.caen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caen.model.Application;
import com.caen.model.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
	Usuario findOneByUsername(String username);
	
	List<Application> getApplicationsByUsername(String username);
}
