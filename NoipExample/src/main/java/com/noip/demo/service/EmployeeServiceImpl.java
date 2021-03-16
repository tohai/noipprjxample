package com.noip.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noip.demo.entities.Employee;
import com.noip.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Long empId) {
		
		return employeeRepository.findById(empId).get();
	}

	@Override
	public void deleteByID(Long empId) throws Exception {
		try {
			employeeRepository.deleteById(empId);
		} catch (Exception e) {
			throw new Exception();
		}
		
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

}
