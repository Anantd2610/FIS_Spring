package com.fis.springjdbc.employee;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {
	
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("daoexample.xml");
		EmployeeDAOImpl bean = context.getBean("employeeDao",EmployeeDAOImpl.class);
		
		System.out.println("===============================");
		System.out.println("Insert a Employee");
		Employee newEmployee = new Employee();
		newEmployee.setId(3);
		newEmployee.setName("avinash");
		bean.insertEmployee(newEmployee);
		System.out.println("===============================");
		System.out.println("Delete Employee");
		int id = 2;
		bean.deleteEmployee(id);
		System.out.println("===============================");
		System.out.println("Get Employee Based on Id");
		id = 3;
		Employee EmployeeById = bean.getEmployeeById(id);
		System.out.println(EmployeeById);
		System.out.println("===============================");
		System.out.println("Update Employee");
		newEmployee = new Employee();
		newEmployee.setId(1);
		newEmployee.setName("Anant");
		bean.updateEmployee(newEmployee);
		System.out.println("===============================");
		System.out.println("Get All Employees");
		System.out.println(bean.getAllEmployees());
		System.out.println("===============================");

		context.close();
		
	}
	
	
	

}
