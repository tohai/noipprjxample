package com.noip.demo.service;

import java.util.List;

import com.noip.demo.entities.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(Long empId);
	
	public void deleteByID(Long empId) throws Exception;
	
	public void save(Employee employee);

}
