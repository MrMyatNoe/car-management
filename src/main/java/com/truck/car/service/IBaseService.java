package com.truck.car.service;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IBaseService<T> {
    
    List<T> getAllDatas();

    T saveData(T t);

    T updateData(T t);

    T deleteDataById(UUID id);

    T getDataById(UUID id);
}
