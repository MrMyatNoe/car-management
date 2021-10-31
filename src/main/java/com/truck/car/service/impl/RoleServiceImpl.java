package com.truck.car.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truck.car.exception.NotFoundException;
import com.truck.car.model.Role;
import com.truck.car.repository.RoleRepository;
import com.truck.car.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> getAllDatas() {
		return roleRepository.findAll();
	}

	@Override
	public Role saveData(Role Role) {
		return roleRepository.save(Role);
	}

	@Override
	public Role updateData(Role Role) {
		return roleRepository.save(Role);
	}

	@Override
	public Role deleteDataById(UUID id) {
		getDataById(id);
        roleRepository.deleteById(id);
        return getDataById(id);
	}

	@Override
	public Role getDataById(UUID id) {
		String str = String.valueOf(id).replace("-", "").toUpperCase();
		Role role = roleRepository.findByUUID(str);
        if(role == null)
            throw new NotFoundException(id + "not found");
        return role;
    }
}
