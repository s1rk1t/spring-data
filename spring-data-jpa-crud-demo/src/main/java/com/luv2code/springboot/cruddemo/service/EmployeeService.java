package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();

	public Employee findEmployeeById(int id);

	public void saveEmployee(Employee employee);

	public void deleteEmployeeById(int id);

}
