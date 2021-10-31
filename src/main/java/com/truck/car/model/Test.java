package com.truck.car.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tests")
public class Test {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	//@Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private double number;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Test [id=" + id + ", name=" + name + ",number=" + number + "]";
    }

}
