package com.truck.car.controller;

import java.util.UUID;

import com.truck.car.exception.BadRequestException;
import com.truck.car.exception.BaseException;
import com.truck.car.model.Test;
import com.truck.car.service.ITestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/tests")
public class TestController extends BaseController{
    
    @Autowired
    ITestService testService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllDatas() {
      logInfo("All Tests");
		  return successResponse(testService.getAllDatas());
	  }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveData(@RequestBody Test test){
      try {
        logInfo("Save Test");
        isValidData(test);
        return createResponse(testService.saveData(test));
      } catch (BaseException e) {
        logError(e,e.getMessage());
        return e.response();
      }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateData(@RequestBody Test test){
      try {
        logInfo("Update Test");
        isValidData(test);
        return createResponse(testService.updateData(test));
      } catch (BaseException e) {
        logError(e,e.getMessage());
        return e.response();
      }
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteById(@RequestParam("id") UUID id){
      try {
        logInfo("Delete Test By Id");
        return createResponse(testService.deleteDataById(id));
      } catch (BaseException e) {
        logError(e,e.getMessage());
        return e.response();
      }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Object> getDataById(@PathVariable("id") UUID id) {
      logInfo("Get Test By Id" + id) ;
      try {
        return successResponse(testService.getDataById(id));
      } catch (BaseException e) {
        logError(e, e.getMessage());
        return e.response();
      }
    }

    private void isValidData(Test test) throws BaseException {
      if (test == null) {
        throw new BadRequestException("Test data is not valid.");
      }
      if (test.getName() == null) {
        throw new BadRequestException("Please enter Test name.");
      }
      // if (test.getNumber() == 0.0) {
      //   throw new BadRequestException("Plese enter Test number.");
      // }
    }
}
