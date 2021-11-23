package com.truck.car.service.impl;

import java.util.List;
import java.util.UUID;

import com.truck.car.exception.NotFoundException;
import com.truck.car.model.Test;
import com.truck.car.repository.TestRepository;
import com.truck.car.service.ITestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService{

    @Autowired
    TestRepository testRepository;

    @Override
    public List<Test> getAllDatas() {
        return testRepository.findAll();
    }

    @Override
    public Test saveData(Test t) {
        return testRepository.save(t);
    }

    @Override
    public Test updateData(Test t) {
        return testRepository.save(t);
    }

    @Override
    public Test deleteDataById(UUID id) {
        getDataById(id);
        testRepository.deleteById(id);
        return getDataById(id);
    }

    @Override
    public Test getDataById(UUID id) {
        String str = String.valueOf(id).replace("-", "").toUpperCase();
		Test test = testRepository.findByUUID(str);
        if(test == null)
            throw new NotFoundException(id + "not found");
        return test;
    }
    
}
