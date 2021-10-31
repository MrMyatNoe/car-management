package com.truck.car.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.truck.car.exception.BadRequestException;
import com.truck.car.exception.BaseException;
import com.truck.car.model.Role;
import com.truck.car.service.IRoleService;
@RestController
@RequestMapping("v1/roles")
public class RoleController extends BaseController {
	
	@Autowired
	IRoleService roleService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllDatas() {
      logInfo("All Roles");
		  return successResponse(roleService.getAllDatas());
	  }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveData(@RequestBody Role role){
      try {
        logInfo("Save Role");
        isValidData(role);
        return createResponse(roleService.saveData(role));
      } catch (BaseException e) {
        logError(e,e.getMessage());
        return e.response();
      }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateData(@RequestBody Role role){
      try {
        logInfo("Update Role");
        isValidData(role);
        return createResponse(roleService.updateData(role));
      } catch (BaseException e) {
        logError(e,e.getMessage());
        return e.response();
      }
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteById(@RequestParam("id") UUID id){
      try {
        logInfo("Delete Role By Id");
        return createResponse(roleService.deleteDataById(id));
      } catch (BaseException e) {
        logError(e,e.getMessage());
        return e.response();
      }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Object> getDataById(@PathVariable("id") UUID id) {
      logInfo("Get Role By Id" + id) ;
      try {
        return successResponse(roleService.getDataById(id));
      } catch (BaseException e) {
        logError(e, e.getMessage());
        return e.response();
      }
    }

    private void isValidData(Role role) throws BaseException {
      if (role== null) {
        throw new BadRequestException("Test data is not valid.");
      }
      if (role.getName() == null) {
        throw new BadRequestException("Please enter Test name.");
      }
    }
}
