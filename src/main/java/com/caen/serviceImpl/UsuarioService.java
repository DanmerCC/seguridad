package com.caen.serviceImpl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.caen.dao.IUsuarioDao;
import com.caen.model.Usuario;
import com.caen.model.Application;
import com.caen.model.Role;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	IUsuarioDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario=dao.findOneByUsername(username);
		System.out.println(usuario.getAuthorities().toString());
		return usuario;
	}


	public List<Application> appsUserByUsername(String username) throws UsernameNotFoundException {
		List<Application>apps=new ArrayList<Application>();
		dao.findOneByUsername(username).getRole().getPermisos().forEach(p->{
			if(!apps.contains(p.getApplication())) {
				apps.add(p.getApplication());
			}
			
		});
		return apps;
	}
	

}
