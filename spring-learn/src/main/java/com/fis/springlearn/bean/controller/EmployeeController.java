package com.fis.springlearn.bean.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fis.springlearn.bean.service.EmployeeService;

public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	private EmployeeService employeeService;
	
	public EmployeeController()
	{
		LOGGER.debug("Inside Employee Controller");
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	

}
