package com.em.expensemeter.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.em.expensemeter.model.ExpType;
import com.em.expensemeter.service.IExpTypeService;

@Controller
@RequestMapping("/exptype")
public class ExpTypeController {

	@Autowired
	IExpTypeService expTypeService;

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ExpType>> getAllExpenseType() {
		List<ExpType> expTypeList = null;
		expTypeList = expTypeService.getAllExpenseType();
		if(expTypeList == null){
			return new ResponseEntity<List<ExpType>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ExpType>>(expTypeList, HttpStatus.OK);

	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExpType> getExpenseTypeDetailsById(@PathVariable int id) {
		ExpType expType = expTypeService.getExpenseTypeDetailsById(id);

		if(expType == null){
			return new ResponseEntity<ExpType>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ExpType>(expType, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExpType> addExpenseType(@RequestBody ExpType expType) {
		expTypeService.addExpenseType(expType);
		return new ResponseEntity<ExpType>(HttpStatus.OK);

	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExpType> updateExpenseType(@RequestBody ExpType expType) {
		expTypeService.updateExpenseType(expType);
		return new ResponseEntity<ExpType>(HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExpType> deleteExpenseType(@PathVariable int id) {
		expTypeService.deleteExpenseType(id);
		return new ResponseEntity<ExpType>(HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> errorHandler(Exception e) {
		System.out.println("In exception handler..");
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
