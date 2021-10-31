package com.truck.car.repository;

import org.springframework.stereotype.Repository;

import com.truck.car.model.Role;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RoleRepository  extends JpaRepository<Role,UUID>{
	 @Query(value = "SELECT * FROM role " + "WHERE id = unhex(?1)", nativeQuery = true)
		Role findByUUID(@Param("id")String id);
	
}
