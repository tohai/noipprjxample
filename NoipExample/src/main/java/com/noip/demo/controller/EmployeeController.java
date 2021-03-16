package com.noip.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noip.demo.entities.Employee;
import com.noip.demo.model.ResultEmployeeApi;
import com.noip.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/API/employee/{empid}")
	public ResultEmployeeApi getEmployeeByID(@PathVariable("empid") Long empid) {
		ResultEmployeeApi resultEmployeeApi = new ResultEmployeeApi();
		resultEmployeeApi.setMes("true");
		resultEmployeeApi.setData(employeeService.findById(empid));
		
		
		return  resultEmployeeApi;
	}
	
	@RequestMapping(value = "/API/employees")
	public ResultEmployeeApi getEmployees() {
		ResultEmployeeApi resultEmployeeApi = new ResultEmployeeApi();
		resultEmployeeApi.setMes("true");
		resultEmployeeApi.setData(employeeService.findAll());
		 
		return resultEmployeeApi;
	}
	
	@RequestMapping(value = "/API/employees",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResultEmployeeApi saveEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		ResultEmployeeApi resultEmployeeApi = new ResultEmployeeApi();
		resultEmployeeApi.setMes("true");
		resultEmployeeApi.setData("");
		return resultEmployeeApi;
		 
	}
	
	@RequestMapping(value = "/API/employee/delete/{empid}")
	public ResultEmployeeApi deleteEmployee(@PathVariable("empid") Long empid) {
		ResultEmployeeApi resultEmployeeApi = new ResultEmployeeApi();
		resultEmployeeApi.setData("");
		try {
			employeeService.deleteByID(empid);
			resultEmployeeApi.setMes("true");
		} catch (Exception e) {
			resultEmployeeApi.setMes("false");
		}
		return resultEmployeeApi;
		 
	}
	
	

}
