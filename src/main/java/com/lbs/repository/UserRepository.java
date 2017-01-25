package com.lbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbs.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
//	List<User> findUserByNameAndLastname(String name,String lastname);
	
	
	//PageRequest pageRequest = new PageRequest(page, size)
//	List<User> findUserByFirstname(String firstname, Pageable pageable);

	
	// Custom query
//	@Query("select * from User where firstname = :name1")
//	List<User> findByfirstAndLast(@Param(value = "name1") String name1,@Param(value = "name2") String name2);
}
