package com.truck.car.repository;

import java.util.UUID;

import com.truck.car.model.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test,UUID>{
    
    @Query(value = "SELECT * FROM tests " + "WHERE id = unhex(?1)", nativeQuery = true)
	Test findByUUID(@Param("id")String id);
    
//    // For test case
    @Query(value= 
			"SELECT CASE WHEN COUNT(*) > 0 THEN " + 
			"TRUE ELSE FALSE END " +
			"FROM tests t " + 
			"WHERE t.name = ?1",nativeQuery = true)
    int selectExistsName(@Param("name")String name);
}
