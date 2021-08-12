package com.fis.springjpa.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController 
@RequestMapping(path = "/employee") 
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping
	public @ResponseBody String addNewUser(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Saved";
	}

	@GetMapping
	public @ResponseBody Iterable<Employee> getAllUsers() {
		
		return employeeRepository.findAll();
	}

	@PutMapping
	public String updateEmployee(@RequestBody Employee employee) {

		Optional<Employee> emp = employeeRepository.findById(employee.getId());
		if (emp.isPresent()) {
			employeeRepository.save(employee);
			return "Done with the updation";
		} else {
			return "Employee not found";
		}

	}

	@DeleteMapping
	public String Employee(@RequestParam int id) {

		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			employeeRepository.delete(emp.get());
			return "Done with the Deletion";
		} else {
			return "Employee not found";
		}

	}
	
	@GetMapping("/{id}")
	public Object getAnEmployee(@PathVariable int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			return "Employee Not Found!!";
		}
	}
}