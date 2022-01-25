package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> findAllEmployees() {

		return employeeRepo.findAll();
	}

	@Override
	public Employee findEmployeeById(int id) {

		Optional<Employee> result = employeeRepo.findById(id);

		Employee employee = null;
		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("Employee with id of: " + id + " not found!");
		}

		return employee;

	}

	@Override
	public void saveEmployee(Employee employee) {

		employeeRepo.save(employee);

	}

	@Override
	public void deleteEmployeeById(int id) {

		employeeRepo.deleteById(id);
	}

}
