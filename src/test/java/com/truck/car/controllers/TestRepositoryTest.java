/**
 * 
 */
package com.truck.car.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.truck.car.repository.TestRepository;

/**
 * @author msi
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestRepositoryTest {
	
	@Autowired
	private TestRepository repo;
	
	com.truck.car.model.Test saveTest;

	String name = "Test One";
	
	@BeforeEach
	public void setUp() {
		saveTest = new com.truck.car.model.Test();
	}
	
	@Test
	@Order(1)
	void testSuccessSaveData() { 
		
		// given
		saveTest.setName(name);
		saveTest.setNumber(1.0);
		repo.save(saveTest);
		
//		// when 
		int expected = repo.selectExistsName(name);
		
		// then
		assertNotNull(expected);
	}
	
	@Test
	@Order(2)
	void testSuccessGetAllData() { 
		
		// given
		saveTest.setName(name);
		saveTest.setNumber(1.0);
		repo.save(saveTest);
		
		List<com.truck.car.model.Test> list = repo.findAll();
		// list.stream().filter(t->t.getId()>0).collect(Collectors.toList());
		list.forEach(System.out::println);
		assertThat(list).size().isGreaterThan(0);
	}
	
	// TODO find by name, find by id, update, delete
}
