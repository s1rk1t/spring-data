package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	EmployeeService empService;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {

		return empService.findAllEmployees();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployees(@PathVariable int employeeId) {

		Employee employee = empService.findEmployeeById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Employee with id of: " + employeeId + " not found");
		}

		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {

		employee.setId(0);

		empService.saveEmployee(employee);

		return employee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {

		empService.saveEmployee(employee);

		return employee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {

		Employee employee = empService.findEmployeeById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Employee with id of: " + employeeId + " not found!");
		}

		empService.deleteEmployeeById(employeeId);

	}

}
