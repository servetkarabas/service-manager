package com.lbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbs.model.Role;
import com.lbs.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
//	@Transactional
	public boolean isRoleExist(String rolename){
		if(roleRepository.findRoleByName(rolename)==null)
			return false;
		return true;
	}
	

	public List<Role> findAll(){
		return (List<Role>) roleRepository.findAll();
	}
	
//	@Async
	public void saveRole(Role role){
		roleRepository.save(role);
	}
}
