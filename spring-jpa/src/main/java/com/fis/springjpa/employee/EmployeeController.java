package com.fis.springjpa.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(path = "/employees")

public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping(path = "/add")

	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam Double salary) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Employee n = new Employee();
		n.setName(name);
		n.setSalary(salary);
		employeeRepository.save(n);
		return "Saved employee details";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		// This returns a JSON or XML with the users
		return employeeRepository.findAll();
	}

}
