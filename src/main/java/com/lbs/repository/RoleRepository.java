package com.lbs.repository;

import org.springframework.data.repository.CrudRepository;

import com.lbs.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findRoleByName(String name);

}
